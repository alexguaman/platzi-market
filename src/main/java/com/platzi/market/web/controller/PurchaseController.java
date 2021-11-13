package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @ApiOperation(value = "Get all purchases"
            , authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<List<Purchase>>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/clientes/{id}")
    @ApiOperation(value = "Get purchases by Id client"
            , authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<List<Purchase>> getByCliente(@PathVariable("id") String clientId){
        return purchaseService.getByCliente(clientId)
                .map(purchases -> new ResponseEntity<List<Purchase>>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save a purchase"
            , authorizations = {@Authorization(value = "JWT")})
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

}
