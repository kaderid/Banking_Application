package com.kader.banking.controllers;


import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/adresses")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @PostMapping("/")
    public ResponseEntity<Integer> save(
            @RequestBody ContactDto contactDto
    ){
        return ResponseEntity.ok(service.save(contactDto));
    }


    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{address-id}")
    public ResponseEntity<ContactDto> findById(
            @PathVariable("address-id") Integer contactId
    ){
        return ResponseEntity.ok(service.findById(contactId));
    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity<List<ContactDto>> findAllByUserId(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.findAllByUserId());
    }

    @DeleteMapping("/{contact-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("contact-id") Integer contactId
    ){
        service.delete(contactId);
        return ResponseEntity.accepted().build();
    }
}
