package com.ofss.controller;

import com.ofss.dto.CreateAccountRequest;
import com.ofss.model.Account;
import com.ofss.service.AccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;
    

    // Create a new account
    @Operation(
            summary = "Create a new account for customer",
            description = "This API creates a new account for a specific customer"
    )
    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request.getCustomerId(), request.getAccountType());
    }
    
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts()
    {
    	return accountService.getAllAccount();
    }
}
