package com.bestbank.instrumentos.domain.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bestbank.instrumentos.domain.models.Instrumento;

public interface InstrumentosRepository extends ReactiveMongoRepository<Instrumento, String>{
  
  

}
