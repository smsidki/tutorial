package id.tutorial.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;

import id.tutorial.entity.Person;
import id.tutorial.entity.QPerson;

public interface PersonRepository extends JpaRepository<Person, Long>, QuerydslPredicateExecutor<Person>, QuerydslBinderCustomizer<QPerson> {

	List<Person> findByFirstName(String firstName);

	Page<Person> findByFirstName(String firstName, Pageable pageable);
	
	default Page<Person> secureFindAll(Predicate predicate, Pageable pageable) {
		QPerson person = QPerson.person;
		Predicate wihtAuditorPredicate = person.createdBy.equalsIgnoreCase("system").or(person.modifiedBy.equalsIgnoreCase("system-update")).and(predicate);
		return findAll(wihtAuditorPredicate, pageable);
	}

	@Override
	default void customize(QuerydslBindings bindings, QPerson person) {
		bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
		bindings.including(person.firstName, person.lastName);
	}

}
