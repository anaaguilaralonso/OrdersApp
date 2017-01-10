package com.einao.ordersapp.domain.providers;

public interface Navigator<Param> {
    void goTo(Param viewModel);
}
