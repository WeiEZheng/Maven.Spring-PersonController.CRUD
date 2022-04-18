package controller;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Person> createPerson(Person p) {
        return new ResponseEntity<>(personRespository.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(Person p){
        if (personRespository.findById(p.getId())!=null)
            return new ResponseEntity<>(personRespository.save(p), HttpStatus.OK);
        return new ResponseEntity<>(personRespository.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Person getPerson(int id) {
        return personRespository.findById((long) id).get();
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersonList() {
        List<Person> personList = new ArrayList<>();
        for (Person s: personRespository.findAll()){
            personList.add(s);
        }
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> DeletePerson(int id) {
        if (personRespository.findById((long)id)!=null) {
            personRespository.deleteById((long) id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
