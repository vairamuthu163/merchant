package com.example.merchant.repository;

import com.example.merchant.document.Merchant;
import com.example.merchant.document.Product;
import com.example.merchant.dto.ProductDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends MongoRepository<Merchant,Integer> {
    Merchant save(Merchant merchant);
    Optional<Merchant> findById(int id);
    List<Merchant> findAll();
   // void save(Product product);
  //  @Query(value = "({ _id:1234567890 }{ $addToSet: {groups.$[elem].votes: { //new object data } },{ arrayFilters: [ { elem.userId: 123} ] } )")

//   @Query(value = "{'_id:?0',$push:{'products':?1}")
//    void findByIdAndUpdate(int id,Product product);


}
