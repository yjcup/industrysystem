package com.ruoyi.web.controller.movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
    @GetMapping("/index")
    public String getIndex(){
        return "movie/index";
    }
}
