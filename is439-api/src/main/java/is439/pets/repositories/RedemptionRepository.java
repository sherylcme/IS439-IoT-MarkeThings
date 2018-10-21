package is439.pets.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import is439.pets.model.Pets;
import is439.pets.model.Redemption;
public interface RedemptionRepository extends MongoRepository<Redemption, String> {
  Redemption findBy_id(ObjectId _id);
}