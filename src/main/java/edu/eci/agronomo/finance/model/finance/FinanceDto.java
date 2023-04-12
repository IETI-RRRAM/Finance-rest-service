package edu.eci.agronomo.finance.model.finance;

public class FinanceDto {
    private String idAnimal;
    private float moneyProduced;
    private float moneySpent;
    private float profitability;

    public FinanceDto(String idAnimal, float moneyProduced, float moneySpent) {
        this.idAnimal = idAnimal;
        this.moneyProduced = moneyProduced;
        this.moneySpent = moneySpent;
        this.profitability = ((moneyProduced-moneySpent)*100)/moneyProduced;
    }

    public FinanceDto() {

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
        return ((this.moneyProduced-this.moneySpent)*100)/this.moneyProduced;
    }

    public void setProfitability(float profitability) {
        this.profitability = profitability;
    }
}
