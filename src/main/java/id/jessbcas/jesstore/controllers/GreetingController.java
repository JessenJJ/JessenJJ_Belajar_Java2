package id.jessbcas.jesstore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/hello")
    //localhost:8080?name=putri
    //req.query
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

    @GetMapping("/hello2/{idUser}")
    //localhost:8080/hello2/1234567
    //req.params
    public String hello2(@PathVariable(value = "idUser") String id){
        return "ID nya adalah " + id;
    }

    //req.body
    @PostMapping("/user")
    public Object addUser(@RequestBody Object data){
        return data;
    }

}
