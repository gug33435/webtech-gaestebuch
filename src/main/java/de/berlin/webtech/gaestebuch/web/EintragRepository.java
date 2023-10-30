package de.berlin.webtech.gaestebuch.web;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EintragRepository extends CrudRepository<Eintrag, Long> { }
