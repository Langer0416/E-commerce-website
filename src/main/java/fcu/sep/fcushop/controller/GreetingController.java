package fcu.sep.fcushop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 点对 (x,y) 的水平和垂直距离.
 */

@RestController
public class GreetingController {

  @GetMapping("/greeting")
  public String sayHello(@RequestParam String name) {
    return "Hello " + name;
  }

}