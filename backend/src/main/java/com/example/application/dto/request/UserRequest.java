package com.example.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Nullable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.application.dto.request.validator.UniqueUsername;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {
    @Nullable
    private String id;
    
    @NotBlank(message = "user name can not be blank")
    @UniqueUsername
    private String username;

    @NotBlank(message = "password can not be blank")
    private String password;

    @NotBlank(message = "name can not be blank")
    private String name;

    @Min(value = 0, message = "age cannot be smaller than 0")
    private int age;
    private String occupation;
    private String gender;
}
