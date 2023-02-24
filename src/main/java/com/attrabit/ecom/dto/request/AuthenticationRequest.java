package com.attrabit.ecom.dto.request;

import com.attrabit.ecom.annotation.EmailValid;
import com.attrabit.ecom.annotation.NullValid;
import com.attrabit.ecom.annotation.PasswordValid;
import com.attrabit.ecom.annotation.SizeValid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @NullValid(message = "Email is not null")
    @SizeValid(min = 5, max = 25, message = "Email is length of 5 to 25")
    @EmailValid(message = "Email is not valid!")
    private String email;
    @NullValid(message = "Password is not null")
    @SizeValid(min = 8, max = 20, message = "Password is length of 8 to 20")
    @PasswordValid(message = "Invalid password!")
    private String password;
}
