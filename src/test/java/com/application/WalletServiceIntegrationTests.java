package com.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class WalletServiceIntegrationTests {

    @Autowired
    private WalletService walletService;
    @Test
    void registerWalletTest() throws WalletException {
        WalletDto wallt = new WalletDto(1,"wallet1",1000.0);
        assertEquals("wallet1",this.walletService.registerWallet(wallt).getName());
    }
    @Test
    void getWalletByIdThrowsExceptionTest() {
        assertThrows(WalletException.class,()->this.walletService.getWalletById(1000));
    }

    @Test
    void getWalletByIdWithoutExceptionTest() throws WalletException {
        WalletDto wallt = new WalletDto(1,"wallet1",1000.0);
        this.walletService.registerWallet(wallt);
        assertEquals(wallt.toString(),this.walletService.getWalletById(wallt.getId()).toString());
    }

    @Test
    void updateWalletTest() throws WalletException {
        WalletDto wallt = new WalletDto(1,"wallet1",1000.0);
        this.walletService.registerWallet(wallt);
        assertEquals(wallt.toString(),this.walletService.updateWallet(wallt).toString());
    }



    @Test
    void deleteWalletByIdThrowsExceptionTest(){
        assertThrows(WalletException.class,()->this.walletService.deleteWalletById(1000));
    }

    @Test
    void deleteWalletByIdWithoutExceptionTest() throws WalletException {
        WalletDto wallt = new WalletDto(1,"wallet1",1000.0);
        this.walletService.registerWallet(wallt);
        assertEquals(wallt.toString(),this.walletService.deleteWalletById(wallt.getId()).toString());
    }

    @Test
    void addFundsToWalletByIdThrowsExceptionTest(){

    }

    @Test
    void addFundsToWalletByIdWithoutException() throws WalletException{


    }

    @Test
    void withdrawFundsFromWalletByIdThrowsException(){

    }

    @Test
    void withdrawFundsFromWalletByIdWithoutException() throws WalletException{

    }

    @Test
    void fundTransferThrowsException(){
        assertThrows(WalletException.class,()->this.walletService.fundTransfer(1,2,1000.0));

    }

    @Test
    void fundTransferWithoutException() throws WalletException{



    }




}
