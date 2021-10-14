package com.driver.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    //option 1 of implementing version - two separate URIs
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Charlie Chaplin");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Charlie","Chaplin"));
    }
}
