package com.driver.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    //option 1 of implementing versioning - using different uri
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //option 2 of implementing versioning - using request params
    @GetMapping(value = "person/param",params="version=1")
    public PersonV1 personV1Param(){
        return new PersonV1("Charlie Chaplin");
    }

    @GetMapping(value = "person/param",params="version=2")
    public PersonV2 personV2Param(){
        return new PersonV2(new Name("Charlie","Chaplin"));
    }

    //option 2 of implementing versioning - using request params
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
