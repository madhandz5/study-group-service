package com.studywara.account;/*
 * @created 11/09/2020 - 9:09 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final JavaMailSender javaMailSender;

    public void proccessNewAccount(SignUpForm signUpForm) {
        Account newAccount = saveNewAccount(signUpForm);
        newAccount.generateEmailCheckToken();
        sendSignUpConfirmEmail(newAccount);

    }

    private Account saveNewAccount(SignUpForm signUpForm) {
        Account account = Account.builder()
                .email(signUpForm.getEmail())
                .nickname(signUpForm.getNickname())
                .password(signUpForm.getPassword()) //TODO encoding 해야 함
                .studyCreateByWeb(true)
                .studyUpdatedByWeb(true)
                .studyEnrollmentResultByWeb(true)
                .build();

        return accountRepository.save(account);
    }

    private void sendSignUpConfirmEmail(Account newAccount) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(newAccount.getEmail());
        mailMessage.setSubject("스터디그룹서비스, 회원 가입 인증");
        mailMessage.setText("/check-email-token?"+ newAccount.getEmailCheckToken() + "token=&email="+ newAccount.getEmail());

        javaMailSender.send(mailMessage);
    }
}
