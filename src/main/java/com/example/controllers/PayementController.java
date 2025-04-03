package com.example.controllers;

import com.example.service.PayementService;
import com.example.traitement.PayementRequest;
import com.example.traitement.PayementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api")
@RestController
public class PayementController {

    @Autowired
    PayementService payementService;

    @PostMapping("payment/{mode}")
    public ResponseEntity<PayementResponse> effectuerPayement(
            @RequestBody PayementRequest payementRequest,
            @PathVariable String mode)
    {
        return ResponseEntity.ok(payementService.payementResponse(mode,payementRequest));
    }
}
