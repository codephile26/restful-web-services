package com.driver.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    //option 1 of implementing versioning - using different uri
    //uri versioning
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //option 2 of implementing versioning - using request params
    //Request Param versioning
    @GetMapping(value = "person/param",params="version=1")
    public PersonV1 personV1Param(){
        return new PersonV1("Charlie Chaplin");
    }

    @GetMapping(value = "person/param",params="version=2")
    public PersonV2 personV2Param(){
        return new PersonV2(new Name("Charlie","Chaplin"));
    }

    //option 3 of implementing versioning - using headers
    //Header type version
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //option 4 of implementing versioning - using produces - Content Negotiation Approach
    //AKA - Mime type versioning
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
