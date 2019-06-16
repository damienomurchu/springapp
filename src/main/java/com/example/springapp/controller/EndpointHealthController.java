package com.example.springapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to handle requests to check health of api
 */
@RestController
public class EndpointHealthController {

  /**
   * Basic endpoint to check if api is serving requests
   *
   * @return Confirmation that server is up
   */
  @RequestMapping(method = RequestMethod.GET, value = "/health")
  public String basicHealth() {
    return "Health check passed - server is up!";
  }

}

