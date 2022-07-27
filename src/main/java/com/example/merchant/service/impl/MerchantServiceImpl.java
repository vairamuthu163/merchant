package com.example.merchant.service.impl;

import com.example.merchant.document.Merchant;
import com.example.merchant.document.Product;
import com.example.merchant.dto.ProductDto;
import com.example.merchant.repository.MerchantRepository;
import com.example.merchant.service.MerchantService;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Merchant save(Merchant merchant) {
       return merchantRepository.save(merchant);
    }

    @Override
    public List<Merchant> findAll() {
        return merchantRepository.findAll();
    }

    @Override
    public Optional<Merchant> findById(int id) { return merchantRepository.findById(id); }

    @Override
    public void findByIdAndAdd(int id, Product product) {
        Update update = new Update();
        update.addToSet("products", product);
        Criteria criteria = where("_id").is(id);
        mongoTemplate.updateFirst(Query.query(criteria), update, "merchant");
        System.out.println("successfully updated!!!!");
    }

    @Override
    public void findByIdAndUpdate(int id, Product product) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id)); // find the parent
        query.addCriteria(Criteria.where("products._id").is(product.getId())); // find the child which will be changed
        Update update = new Update();
        update.set("products.$.name", product.getName()); // change the field inside the child that must be updated

       mongoTemplate
                // findAndModify:
                // Find/modify/get the "new object" from a single operation.
                .findAndModify(
                        query, update,
                        new FindAndModifyOptions().returnNew(true), Merchant.class
                )
                ;

    }
}
