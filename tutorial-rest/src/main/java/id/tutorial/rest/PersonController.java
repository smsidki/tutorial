package id.tutorial.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.tutorial.entity.Person;
import id.tutorial.repo.PersonRepository;

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
	
	@GetMapping("/search")
	public List<String> getPerson(@RequestParam String firstName) {
		List<Person> persons = personRepo.findByFirstName(firstName);
		return persons.stream().map(person -> person.getFirstName() + " " + person.getLastName()).collect(Collectors.toList());
	}

}
