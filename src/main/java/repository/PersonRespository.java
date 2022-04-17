package repository;

import model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRespository extends CrudRepository<Person, Long> {
}
