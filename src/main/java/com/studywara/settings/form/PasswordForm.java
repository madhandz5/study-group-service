package com.studywara.settings.form;/*
 * @created 16/09/2020 - 3:00 오후
 * @project studywara
 * @author ryan
 */

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PasswordForm {

    @Length(min = 8, max = 50)
    private String newPassword;

    @Length(min = 8, max = 50)
    private String newPasswordConfirm;

}
