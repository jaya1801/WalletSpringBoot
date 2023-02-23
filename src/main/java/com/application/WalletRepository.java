package com.application;

import java.util.List;

public interface WalletRepository {

    WalletDto createWallet(WalletDto newWallet);
    WalletDto getWalletById(Integer  walletId);
    WalletDto updateWallet(WalletDto wallet);
    WalletDto deleteWallet(Integer walletId);

    List<WalletDto> getAllWallets();
}
