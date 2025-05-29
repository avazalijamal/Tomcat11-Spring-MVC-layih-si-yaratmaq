package com.avaz.springmvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Register {

    private Map<String, String> fakeUsers = new HashMap<>();

    @GetMapping("/register")
    public ModelAndView showRegister() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@RequestParam String username,
                                   @RequestParam String password,
                                   HttpSession session) {
        if (fakeUsers.containsKey(username)) {
            ModelAndView mv = new ModelAndView("register");
            mv.addObject("error", "Bu istifadəçi adı artıq mövcuddur.");
            return mv;
        }
        fakeUsers.put(username, password);
        session.setAttribute("user", username);
        return new ModelAndView("redirect:/profile");
    }

}
