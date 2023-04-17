package edu.eci.agronomo.finance.controller;

import edu.eci.agronomo.finance.exceptions.FinanceNotFoundException;
import edu.eci.agronomo.finance.model.finance.Finance;
import edu.eci.agronomo.finance.model.finance.FinanceDto;
import edu.eci.agronomo.finance.service.FinanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    @Autowired
    private FinanceServiceImpl financeService;

    // Get all finances
    @GetMapping
    public List<Finance> getAllFinances() {
        return financeService.findAll();
    }

    // Get finance by ID
    @GetMapping("/{id}")
    public ResponseEntity<Finance> getFinanceById(@PathVariable String id) {
        Optional<Finance> finance = financeService.findById(id);
        if (finance.isPresent()) {
            return ResponseEntity.ok(finance.get());
        } else {
            throw new FinanceNotFoundException(id);
        }
    }

    // Create a new finance
    @PostMapping
    public ResponseEntity<Finance> createFinance(@RequestBody FinanceDto financeDto) {
        Finance createdFinance = financeService.save(financeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFinance);
    }

    // Delete a finance
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinance(@PathVariable String id) {
        Optional<Finance> finance = financeService.findById(id);
        if (finance.isPresent()) {
            financeService.delete(finance.get().getId());
            return ResponseEntity.ok().build();
        } else {
            throw new FinanceNotFoundException(id);
        }
    }

    //Update a finance
    @PutMapping("/{id}")
    public ResponseEntity<Finance> updateFinance(@PathVariable String id, @RequestBody FinanceDto updatedFinance) {
        Optional<Finance> finance = financeService.findById(id);
        if (finance.isPresent()) {
            Finance savedFinance = financeService.update(id, updatedFinance);
            return ResponseEntity.ok(savedFinance);
        } else {
            throw new FinanceNotFoundException(id);
        }
    }
}
