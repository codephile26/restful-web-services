package com.driver.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    //option 2 of implementing versioning - using request params
    @GetMapping(value = "person/param",params="version=1")
    public PersonV1 personV1(){
        return new PersonV1("Charlie Chaplin");
    }

    @GetMapping(value = "person/param",params="version=2")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Charlie","Chaplin"));
    }
}
