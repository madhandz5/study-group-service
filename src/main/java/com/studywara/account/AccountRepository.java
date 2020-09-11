package com.studywara.account;/*
 * @created 11/09/2020 - 8:22 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
}
