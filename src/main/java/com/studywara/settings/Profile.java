package com.studywara.settings;/*
 * @created 15/09/2020 - 6:43 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
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

    public Profile(Account account){
        this.bio = account.getBio();
        this.url = account.getUrl();
        this.occupation = account.getOccupation();
        this.location = account.getLocation();
        this.profileImage = account.getProfileImage();
    }
}
