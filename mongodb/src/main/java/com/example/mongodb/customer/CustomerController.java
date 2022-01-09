package com.example.mongodb.customer;


import com.example.mongodb.model.ResponeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerResponsitory customerResponsitory;

    @GetMapping("")
    ResponseEntity<ResponeObject> findall() {
        List<Customer> findall = customerResponsitory.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject(findall)
        );

    }

    @GetMapping("/{id}")
    ResponseEntity<ResponeObject> findone(@PathVariable String id) {
        Optional<Customer> findone = customerResponsitory.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject(findone)
        );
    }

    @PostMapping("/{id}")
    ResponseEntity<ResponeObject> checkId(@PathVariable String id) {
        Optional<Customer> foundID = customerResponsitory.findById(id);
        return foundID.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponeObject("")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("")
                );
    }

    @GetMapping("/username/{username}")
    ResponseEntity<ResponeObject> username(@PathVariable String username) {
        Optional<Customer> foundCustomer = customerResponsitory.findByUsername(username);
        return foundCustomer.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponeObject("")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("")
                );
    }

    @GetMapping("/publickey/{e}&{n}")
    ResponseEntity<ResponeObject> publickey(@PathVariable String e, @PathVariable String n) {
        Optional<Customer> foundCustomer = customerResponsitory.findByEAndN(Integer.parseInt(e),Integer.parseInt(n));
        return foundCustomer.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponeObject("")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("")
                );
    }

    @PostMapping("/register")
    ResponseEntity<ResponeObject> register(@RequestBody Customer newCustomer) {
        Optional<Customer> foundCustomer = customerResponsitory.findByUsername(newCustomer.getUsername());
        return foundCustomer.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponeObject("")
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject(customerResponsitory.save(newCustomer))
                );
    }

    @PostMapping("/login")
    ResponseEntity<ResponeObject> login(@RequestBody Customer checkCustomer) {
    Optional<Customer> foundCustomer = customerResponsitory.findByUsernameAndPassword(checkCustomer.getUsername(), checkCustomer.getPassword());
        return foundCustomer.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject(foundCustomer)
                ) :
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponeObject("")
                );
    }

}
