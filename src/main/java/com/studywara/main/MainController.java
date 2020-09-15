package com.studywara.main;/*
 * @created 14/09/2020 - 7:33 오후
 * @project studywara
 * @author ryan
 */

import com.studywara.account.CurrentUser;
import com.studywara.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(@CurrentUser Account account, Model model){
        if(account != null){
            model.addAttribute(account);
        }
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
