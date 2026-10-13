package ch.zhaw.avalanger.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.avalanger.model.Avalange;
import ch.zhaw.avalanger.model.AvalangeState;
import ch.zhaw.avalanger.model.AvalangeStateAggregation;

/*
Repository interface for Avalange entities, extending MongoRepository to provide CRUD operations
and query methods for Avalange objects stored in a MongoDB database.
 */

/* AvalangeRepository erbt Funktionen und Queries von MongoRepository
um auf Entität Avalange diese zu verwenden.
AvalangeRepository erbt von MongoRepository */

public interface AvalangeRepository extends MongoRepository<Avalange, String> {
    List<Avalange> findByCountryAndState(String country, AvalangeState state);
    List<Avalange> findByCountry(String country);
    List<Avalange> findByState(AvalangeState state);

    @Aggregation(pipeline = {
        "{'$group': {'_id': '$state', 'avalange_count': {'$count': {}}}}",
        "{'$project': {'state': '$_id', 'avalange_count': 1, '_id': 0}}"
    })
    List<AvalangeStateAggregation> findAvalangeStates();
    
}
