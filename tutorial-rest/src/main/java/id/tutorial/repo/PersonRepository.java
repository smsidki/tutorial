package id.tutorial.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import id.tutorial.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByFirstName(String firstName);

}
