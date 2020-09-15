package com.studywara.settings;/*
 * @created 15/09/2020 - 6:43 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Profile {
    private String bio;
    private String url;
    private String occupation;
    private String location;

    public Profile(Account account){
        this.bio = account.getBio();
        this.url = account.getUrl();
        this.occupation = account.getOccupation();
        this.location = account.getLocation();
    }
}
