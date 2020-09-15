package com.studywara.account;
/*
 * @created 14/09/2020 - 7:38 오후
 * @project studywara
 * @author ryan
 */


import com.studywara.domain.Account;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class UserAccount extends User {

    private Account account;

    public UserAccount(Account account){
        super(account.getNickname(),account.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.account = account;
    }
}
