package com.attrabit.ecom.dto.request;


import com.attrabit.ecom.annotation.*;

import java.util.Date;

public record RequestUserDTO(
        @NullValid(message = "First name is not null")
        @SizeValid(min = 2, max = 25, message = "First name is length of 2 to 25")
        @NameValid(message = "Invalid name!")
        String firstName,
        @NullValid(message = "Last name is not null")
        @SizeValid(min = 2, max = 25, message = "Last name is length of 2 to 25")
        @NameValid(message = "Last name is not valid!")
        String lastName,
        @NullValid(message = "Email is not null")
        @SizeValid(min = 5, max = 25, message = "Email is length of 5 to 25")
        @EmailValid(message = "Email is not valid!")
        String email,
        @NullValid(message = "Phone number is not null")
        @SizeValid(min = 11, max = 14, message = "Phone number is length of 11 to 25")
        @PhoneNumberValid(message = "Phone number is not valid!")
        String phone,
        @NullValid(message = "Password is not null")
        @SizeValid(min = 8, max = 20, message = "Password is length of 8 to 20")
        @PasswordValid(message = "Invalid password!")
        String password
) {

}
