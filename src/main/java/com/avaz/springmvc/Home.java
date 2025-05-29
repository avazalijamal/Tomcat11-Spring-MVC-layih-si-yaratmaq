package com.avaz.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home"); // home.jsp
    }
}
