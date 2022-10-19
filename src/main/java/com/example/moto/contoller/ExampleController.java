package com.example.moto.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "calculator")
public class ExampleController {

    @GetMapping
    public String getMessage() {
        return "Hola soy cris";
    }

    @GetMapping(path = "add/{num1}/{num2}")
    public int add(@PathVariable int num1,
                   @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping(path  ="subtract/{num1}/{num2}")
    public  int subtract(@PathVariable int num1,@PathVariable int num2) {
        return num1 - num2;
    }
    @GetMapping(path = "multi/{num1}/{num2}")
    public int multi(@PathVariable int num1,@PathVariable int num2){
        return num1*num2;
    }
    @GetMapping(path = "split/{num1}/{num2}")
    public int Split(@PathVariable int num1,@PathVariable int num2){
        return num1/num2;
    }
    @GetMapping(path ="enhance/{num1}/{num2}" )
    public int enhance(@PathVariable int num1, @PathVariable int num2){
        return (int) Math.pow(num1,num2);
    }

}