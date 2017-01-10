package com.einao.ordersapp.domain.common;

import com.einao.ordersapp.domain.beans.Error;

public class ErrorObjectMother {

    public Error getSimpleError() {
        Error error = new Error();
        error.setCode(0);
        error.setMessage("Error");

        return error;
    }
}
