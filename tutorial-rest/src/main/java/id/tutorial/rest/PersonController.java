package id.tutorial.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.tutorial.entity.Person;
import id.tutorial.repo.PersonRepository;
import id.tutorial.rest.dto.PersonResponse;
import id.tutorial.rest.dto.Response;
import id.tutorial.rest.helper.ResponseHelper;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepo;

	@PostMapping("/create")
	public String newPerson(@RequestBody Person person) {
		Person savedPerson = personRepo.save(person);
		return savedPerson.getFirstName() + " " + savedPerson.getLastName();
	}
	
	@PostMapping("/edit")
	public String editPerson(@RequestBody Person person) {
		Person existing = personRepo.getOne(person.getId());
		existing.setFirstName(person.getFirstName());
		existing.setLastName(person.getLastName());
		personRepo.save(existing);
		return existing.getFirstName() + " " + existing.getLastName();
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/search")
	public Response getPerson(@RequestParam String firstName, Pageable pageable) {
		Page<Person> persons = personRepo.findByFirstName(firstName, pageable);
		
		if(!persons.hasContent() && !persons.isFirst()) {
			persons = personRepo.findByFirstName(firstName, PageRequest.of(persons.getTotalPages() - 1, persons.getSize(), persons.getSort()));
		}
		
		List<PersonResponse> personData = persons.getContent().stream()
			.map(person -> new PersonResponse(person.getFirstName(), person.getLastName()))
			.collect(Collectors.toList());
		Page<PersonResponse> personResponse = new PageImpl<>(personData, persons.getPageable(), persons.getTotalElements());
		return ResponseHelper.ok(personResponse);
	}

}
