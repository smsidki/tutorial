package id.tutorial.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import id.tutorial.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByFirstName(String firstName);
	Page<Person> findByFirstName(String firstName, Pageable pageable);

}
