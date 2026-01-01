package com.kader.banking.controllers;
import com.kader.banking.dto.TransactionDto;

import com.kader.banking.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;


    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody TransactionDto transactionDto
    ){
        return ResponseEntity.ok(service.save(transactionDto));
    }


    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{address-id}")
    public ResponseEntity<TransactionDto> findById(
            @PathVariable("address-id") Integer transactionId
    ){
        return ResponseEntity.ok(service.findById(transactionId));
    }

    @DeleteMapping("/{transaction-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("transaction-id") Integer transactionId
    ){
        service.delete(transactionId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity<List<TransactionDto>> findAllByUserId(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }


}
