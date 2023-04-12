package edu.eci.agronomo.finance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FinanceNotFoundException extends ResponseStatusException {

    public FinanceNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, "Finance with ID: " + id + " not found");
    }
}
