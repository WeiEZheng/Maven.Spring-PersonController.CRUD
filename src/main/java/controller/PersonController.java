package controller;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.PersonRespository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private List<Person> personList = new ArrayList<>();
    private PersonRespository personRespository;

    @Autowired
    public PersonController (PersonRespository personRespository){
        this.personRespository=personRespository;
    }

    @PostMapping
    public Person createPerson(Person p) {
        return personRespository.save(p);
    }

    @PutMapping("/{id}")
    public Person updatePerson(Person p){
        return personRespository.save(p);
    }

    @GetMapping("/{id}")
    public Person getPerson(int id) {
        return personRespository.findOne((long) id);
    }

    @GetMapping
    public List<Person> getPersonList() {
        return (List<Person>) personRespository.findAll();
    }

    @DeleteMapping("/{id}")
    public void DeletePerson(int id) {
        personRespository.delete((long) id);
    }
}
