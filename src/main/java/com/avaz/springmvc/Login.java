package com.avaz.springmvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Login {

    private Map<String, String> fakeUsers = new HashMap<>();

    @GetMapping("/login")
    public ModelAndView showLogin() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@RequestParam String username,
                                @RequestParam String password,
                                HttpSession session) {
        String storedPassword = fakeUsers.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            session.setAttribute("user", username);
            return new ModelAndView("redirect:/profile");
        }
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("error", "Yanlış istifadəçi adı və ya şifrə.");
        return mv;
    }

}
