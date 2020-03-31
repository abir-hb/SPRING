package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Disponibility;
import tn.esprit.spring.entities.UserDispo;

public interface UserDispoRepository extends CrudRepository<UserDispo, Long> {

}
