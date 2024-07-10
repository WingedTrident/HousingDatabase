package com.housing_project.housing;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class HousingController {

    @RequestMapping("/path")
    public String requestMethodName() {
        return "Hello";
    }
    
    
}
