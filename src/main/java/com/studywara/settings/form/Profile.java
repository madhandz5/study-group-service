package com.studywara.settings.form;/*
 * @created 15/09/2020 - 6:43 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
public class Profile {
    @Length(max=35)
    private String bio;
    @Length(max=50)
    private String url;
    @Length(max=50)
    private String occupation;
    @Length(max=50)
    private String location;

    private String profileImage;
}
