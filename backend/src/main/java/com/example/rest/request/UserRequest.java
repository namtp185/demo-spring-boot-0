package com.example.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequest {

    @NotBlank(message = "user name can not be blank")
    private String name;

    @Min(value = 0, message = "age cannot be smaller than 0")
    private int age;
    private String occupation;
    private String gender;
}
