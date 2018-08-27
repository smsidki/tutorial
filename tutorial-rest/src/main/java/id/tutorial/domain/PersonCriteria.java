package id.tutorial.domain;

import java.util.Optional;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;

import id.tutorial.entity.QPerson;
import lombok.Data;

@Data
public class PersonCriteria {
	
	private String firstName;
	private String lastName;
	
	public Predicate toPredicate() {
		QPerson person = QPerson.person;
		StringPath firstNameCriterion = person.firstName;
		StringPath lastNameCriterion = person.lastName;
		
		return firstNameCriterion.containsIgnoreCase(Optional.ofNullable(firstName).orElse(""))
			   .and(lastNameCriterion.containsIgnoreCase(Optional.ofNullable(this.lastName).orElse("")));
	}

}
