package io.javabrains.moviecatalogservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.moviecatalogservice.entity.EvtBaseEventsMaster;

@Repository
public interface BaseEventsRepository extends CrudRepository<EvtBaseEventsMaster, String> {

	List<EvtBaseEventsMaster> findAll();
}