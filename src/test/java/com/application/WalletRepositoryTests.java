package com.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WalletRepositoryTests {

    @Autowired
    private WalletRepository walletRepository;

//    @BeforeEach
//    public void init(){
//        walletRepository.createWallet(new WalletDto(1,"wallet1",1000.0));
//    }

    @Test
    public void createWalletTest() {
        WalletDto wallet = new WalletDto(1,"wallet1",1000.0);
        assertEquals(wallet.toString(),walletRepository.createWallet(wallet).toString());

    }

    @Test
    public void getWalletByIdTest(){
        WalletDto wallet = new WalletDto(1,"wallet1",1000.0);
        walletRepository.createWallet(wallet);
        assertEquals(wallet.toString(),walletRepository.getWalletById(1).toString());

    }

    @Test
    public void updateWalletTest(){
        WalletDto wallet = new WalletDto(1,"wallet1",1000.0);
        walletRepository.createWallet(wallet);
        assertEquals(wallet.toString(),walletRepository.updateWallet(wallet).toString());

    }

    @Test
    public void deleteWalletTest(){
        WalletDto wallet = new WalletDto(1,"wallet1",1000.0);
        walletRepository.createWallet(wallet);
        assertEquals(wallet.toString(),walletRepository.deleteWallet(1).toString());
    }

    @Test
    public void getAllWalletsTest(){
        List<WalletDto> walletList = new ArrayList<>();
        walletList.add(new WalletDto(1,"wallet1",1000.0));
        walletList.add(new WalletDto(2,"wallet2",2000.0));
        walletList.add(new WalletDto(3,"wallet3",3000.0));

        for (WalletDto wallet:walletList){
            walletRepository.createWallet(wallet);
        }

        List<WalletDto> walletList1 = walletRepository.getAllWallets();
        assertEquals(walletList.size(),walletList1.size());

        for(int i=0;i<walletList.size();i++)
        {
            assertEquals(walletList.get(i),walletList1.get(i));
        }

    }





}
