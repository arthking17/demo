package tn.itss.t24.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.itss.t24.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String>{

}
