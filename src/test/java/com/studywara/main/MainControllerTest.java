package com.studywara.main;/*
 * @created 15/09/2020 - 3:43 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.account.AccountRepository;
import com.studywara.account.AccountService;
import com.studywara.account.SignUpForm;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    void addAccount(){
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setNickname("Ryan Oh");
        signUpForm.setEmail("madhandz5@gmail.com");
        signUpForm.setPassword("12345678");
        accountService.processNewAccount(signUpForm);
    }

    @AfterEach
    void deleteAccount(){
        accountRepository.deleteAll();
    }


    @Test
    @DisplayName("이메일로 로그인")
    void login_with_email() throws Exception{
        mockMvc.perform(post("/login")
                .param("username","madhandz5@gmail.com")
                .param("password","12345678")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(authenticated().withUsername("Ryan Oh"));
    }

    @Test@DisplayName("아이디로 로그인")
    void login_with_nickName() throws Exception{
        mockMvc.perform(post("/login")
                .param("username","Ryan Oh")
                .param("password","12345678")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(authenticated().withUsername("Ryan Oh"));
    }

    @Test
    @DisplayName("로그인 실패")
    void login_fail() throws Exception{
        mockMvc.perform(post("/login")
                .param("username","12345678")
                .param("password","12345678")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error"))
                .andExpect(unauthenticated());
    }

    @WithMockUser
    @Test
    @DisplayName("로그아웃")
    void logout() throws Exception{
        mockMvc.perform(post("/logout")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(unauthenticated());
    }

}
