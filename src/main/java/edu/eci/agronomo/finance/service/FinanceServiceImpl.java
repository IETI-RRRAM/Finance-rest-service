package edu.eci.agronomo.finance.service;

import edu.eci.agronomo.finance.model.finance.Finance;
import edu.eci.agronomo.finance.model.finance.FinanceDto;
import edu.eci.agronomo.finance.repository.FinanceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    FinanceRepositoryImpl financeRepository;

    @Override
    public ArrayList<Finance> findAll() {
        return financeRepository.findAll();
    }

    @Override
    public Optional<Finance> findById(String id) {
        return financeRepository.findById(id);
    }

    @Override
    public Finance save(FinanceDto financeDto) {
        return financeRepository.save(financeDto);
    }

    @Override
    public void delete(String id) {
        financeRepository.delete(id);
    }

    @Override
    public Finance update(String id, FinanceDto financeDto) {
        return financeRepository.update(id, financeDto);
    }
}
