package com.rheehot.demospring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Validated
public class SampleController {

//    @GetMapping("/hey")
//    public String hey(@NotEmpty  String name, @Min(0) Integer age){
//        System.out.println("Name " + name);
//        System.out.println("age " + age);
//        return "hey";
//    }

    @GetMapping("/hey")
    public ResponseEntity hey(@Valid  Holoman holoman, BindingResult holomanError){

        //custom validation
        if(holomanError.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

//        System.out.println(holoman);
        return ResponseEntity.ok("hey");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, List<String>> handle(ConstraintViolationException e){
        List<String> errors = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return Collections.singletonMap("error",errors);
    }
}
