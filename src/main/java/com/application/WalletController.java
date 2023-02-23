package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value = "/v1")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/")
    public String greet(){
        return "This is my Wallet Application!";
    }

    @PostMapping("/wallet")
    @ResponseStatus(value = HttpStatus.CREATED)
    public WalletDto addResource(@RequestBody WalletDto wallet) throws WalletException{
        return walletService.registerWallet(wallet);

    }

    @GetMapping("/wallet/{id}")
    public WalletDto getWalletById(@PathVariable Integer id) throws WalletException{
        return walletService.getWalletById(id);
    }

    @PutMapping("/product")
    public WalletDto replaceResource(@RequestBody WalletDto wallet) throws WalletException
    {
        return walletService.updateWallet(wallet);
    }



}
