package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.AuthenticationRequest;
import com.attrabit.ecom.dto.request.RequestUserDTO;
import com.attrabit.ecom.dto.respose.AuthenticationResponse;
import com.attrabit.ecom.enums.Role;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.mapper.RequestUserDTOMapper;
import com.attrabit.ecom.model.Roles;
import com.attrabit.ecom.model.UserRoles;
import com.attrabit.ecom.model.Users;
import com.attrabit.ecom.repository.RolesRepository;
import com.attrabit.ecom.repository.UserRolesRepository;
import com.attrabit.ecom.repository.UsersRepository;
import com.attrabit.ecom.security.config.JwtGenerator;
import com.attrabit.ecom.token.Token;
import com.attrabit.ecom.token.TokenRepository;
import com.attrabit.ecom.token.TokenType;
import com.attrabit.ecom.utils.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    private final RequestUserDTOMapper requestUserDTOMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;

    private final RolesRepository rolesRepository;
    private final UserRolesRepository userRolesRepository;
    private final UsersRepository usersRepository;
    private final TokenRepository tokenRepository;

    // TODO: 2/20/2023 Below this registration method
    @Override
    public AuthenticationResponse addUser(RequestUserDTO dto) throws ApiMessage {
        try {
            Users user = requestUserDTOMapper.apply(dto);

            Optional<Users> byEmail = usersRepository.findByEmail(user.getEmail());
            if (byEmail.isPresent()){
                throw new ApiMessage("Already user exited!");
            }
            // TODO: 2/16/2023 added user

            final String name = Role.ROLE_USER.name();
            final Roles roles = rolesRepository.findRolesByPermissions(name).orElse(null);


            String encode = passwordEncoder.encode(dto.password());
            user.setPassword(encode);
            user.setPermissions(name);
//            user.setPermissions(name+","+"ROLE_MEMBER");

            final Users save = usersRepository.save(user);

            UserRoles userRoles = new UserRoles();
            userRoles.setUser(save);
            userRoles.setRole(roles);
            userRoles.setCreatedAt(DateUtils.getDate());
            userRolesRepository.save(userRoles);

            var jwtToken = jwtGenerator.generateToken(save);
            saveUserToken(save, jwtToken);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();

        }catch (Exception e){
            throw new ApiMessage("Not inserted user!");
        }

    }

    // TODO: 2/20/2023 Below this login method
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = usersRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtGenerator.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken(Users user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(Users user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

}
