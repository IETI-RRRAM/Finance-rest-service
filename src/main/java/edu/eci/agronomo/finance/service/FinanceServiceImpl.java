package edu.eci.agronomo.finance.service;

import edu.eci.agronomo.finance.model.finance.Finance;
import edu.eci.agronomo.finance.model.finance.FinanceDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FinanceServiceImpl implements FinanceService {


    @Override
    public ArrayList<Finance> findAll() {
        return null;
    }

    @Override
    public Optional<Finance> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Finance save(FinanceDto financeDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Finance update(String id, FinanceDto financeDto) {
        return null;
    }
}
