package edu.eci.agronomo.finance.repository;

import edu.eci.agronomo.finance.model.finance.Finance;
import edu.eci.agronomo.finance.model.finance.FinanceDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class FinanceRepositoryImpl implements FinanceRepository {

    @Autowired
    private final MongoTemplate mongoTemplate;

    public FinanceRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ArrayList<Finance> findAll() {
        return (ArrayList<Finance>) mongoTemplate.findAll(Finance.class);
    }

    @Override
    public Optional<Finance> findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, Finance.class));
    }

    @Override
    public Optional<Finance> findByIdAnimal(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("idAnimal").is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, Finance.class));
    }

    @Override
    public Finance save(FinanceDto financeDto) {
        return mongoTemplate.save(new Finance(String.valueOf(ObjectId.get()), financeDto));
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Finance.class);
    }

    @Override
    public Finance update(String id, FinanceDto financeDto) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update()
                .set("idAnimal", financeDto.getIdAnimal())
                .set("moneyProduced", financeDto.getMoneyProduced())
                .set("moneySpent", financeDto.getMoneySpent())
                .set("profitability", financeDto.getProfitability());
        mongoTemplate.updateFirst(query, update, Finance.class);
        return findById(id).orElse(null);
    }
}
