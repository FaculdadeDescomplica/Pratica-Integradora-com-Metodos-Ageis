package com.sys.vendas.steps;

import com.sys.vendas.models.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDefinitionSteps {

    @Autowired
    private TestRestTemplate restTemplate;

    private String name;
    private ResponseEntity<User> response;

    @Given("the user name is {string}")
    public void theUserNameIs(String name){
        this.name = name;
    }

    @When("I send a request to create the user")
    public void iSendRequestToCreateUser(){
        User user = new User();
        user.setName(name);

        response = restTemplate.postForEntity("/api/users", user, User.class);
    }

    @Then("the user should be saved with name {string}")
    public void theUserShouldBeSavedWithName(String expectedName){
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(expectedName, response.getBody().getName());
    }

}
