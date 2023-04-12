package edu.eci.agronomo.finance.model.finance;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "finance_collection")
public class Finance implements Serializable {

    @Id
    private String id;
    private String idRanch;
    private String name;
    private String type;
    private String gender;
    private String age;
    private String stage;
    private String weight;
    private String race;

    public Finance(String id, String idRanch, String name, String type, String gender, String age, String stage, String weight, String race) {
        this.id = id;
        this.idRanch = idRanch;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.age = age;
        this.stage = stage;
        this.weight = weight;
        this.race = race;
    }

    public Finance(String idRanch, String name, String type, String gender, String age, String stage, String weight, String race) {
        this.idRanch = idRanch;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.age = age;
        this.stage = stage;
        this.weight = weight;
        this.race = race;
    }

    public Finance(String id, FinanceDto financeDto) {
        this.id = id;
        this.idRanch = financeDto.getIdRanch();
        this.name = financeDto.getName();
        this.type = financeDto.getType();
        this.gender = financeDto.getGender();
        this.age = financeDto.getAge();
        this.stage = financeDto.getStage();
        this.weight = financeDto.getWeight();
        this.race = financeDto.getRace();
    }

    public Finance() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdRanch() {
        return idRanch;
    }

    public void setIdRanch(String idRanch) {
        this.idRanch = idRanch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}