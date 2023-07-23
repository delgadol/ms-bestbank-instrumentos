package com.bestbank.instrumentos.domain.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bestbank.instrumentos.domain.models.Instrumento;
import com.bestbank.instrumentos.domain.utils.TipoInstrumento;

import reactor.core.publisher.Flux;



/**
 * Interfaz que define las operaciones de acceso a datos para la entidad de Instrumentos.
 * Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * y otras consultas relacionadas con los instrumentos en la base de datos.
 */

public interface InstrumentosRepository extends ReactiveMongoRepository<Instrumento, String> {
  
  Flux<Instrumento> findAllByCodPersonaAndIndEliminado(String codPersona, Integer indEliminado);
  

}
