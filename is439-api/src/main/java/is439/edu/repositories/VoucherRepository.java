package is439.edu.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import is439.edu.model.Voucher;
public interface VoucherRepository extends MongoRepository<Voucher, String> {
  Voucher findBy_id(ObjectId _id);
}