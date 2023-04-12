package edu.eci.agronomo.finance.model.finance;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "finance_collection")
public class Finance implements Serializable {

    @Id
    private String id;
    @NotNull
    private String idAnimal;
    @NotNull
    private float moneyProduced;
    @NotNull
    private float moneySpent;
    private float profitability;

    public Finance(String id, String idAnimal, float moneyProduced, float moneySpent) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.moneyProduced = moneyProduced;
        this.moneySpent = moneySpent;
        this.profitability = ((moneyProduced-moneySpent)*100)/moneyProduced;
    }

    public Finance(String idAnimal, float moneyProduced, float moneySpent) {
        this.idAnimal = idAnimal;
        this.moneyProduced = moneyProduced;
        this.moneySpent = moneySpent;
        this.profitability = ((moneyProduced-moneySpent)*100)/moneyProduced;
    }

    public Finance(String id, FinanceDto financeDto) {
        this.id = id;
        this.idAnimal = financeDto.getIdAnimal();
        this.moneyProduced = financeDto.getMoneyProduced();
        this.moneySpent = financeDto.getMoneySpent();
        this.profitability = financeDto.getProfitability();
    }

    public Finance() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public float getMoneyProduced() {
        return moneyProduced;
    }

    public void setMoneyProduced(float moneyProduced) {
        this.moneyProduced = moneyProduced;
    }

    public float getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(float moneySpent) {
        this.moneySpent = moneySpent;
    }

    public float getProfitability() {
        return profitability;
    }

    public void setProfitability(float profitability) {
        this.profitability = profitability;
    }
}