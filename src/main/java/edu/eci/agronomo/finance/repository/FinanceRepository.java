package edu.eci.agronomo.finance.repository;

import edu.eci.agronomo.finance.model.finance.Finance;
import edu.eci.agronomo.finance.model.finance.FinanceDto;

import java.util.ArrayList;
import java.util.Optional;

public interface FinanceRepository {

    public ArrayList<Finance> findAll();

    public Optional<Finance> findById(String id);

    public Finance save(FinanceDto financeDto);

    public void delete(String id);

    public Finance update(String id, FinanceDto financeDto);

}
