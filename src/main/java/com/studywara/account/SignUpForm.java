package com.studywara.account;/*
 * @created 11/09/2020 - 7:48 오후
 * @project studywara
 * @author ryan
 */

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class SignUpForm {

    @NotBlank
    @Length(min=3, max = 20)
    @Pattern(regexp="^[ㄱ-ㅎ가-힣a-z0-9_-]{3,20}$")
    private String nickname;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(min = 8, max = 50)
    private String password;
}
