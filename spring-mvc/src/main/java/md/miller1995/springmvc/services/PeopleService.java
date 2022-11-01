package md.miller1995.springmvc.services;


import md.miller1995.springmvc.models.Person;
import md.miller1995.springmvc.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    @Transactional
    public void save(Person person){
        person.setCreatedAt(new Date());
        peopleRepository.save(person);
    }

    public Person findOne(int id){
        Optional<Person> foundPerson  = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void update(int id, Person updatePerson){
        Person personToBeUpdate = peopleRepository.findById(id).get();

        updatePerson.setId(id);
        updatePerson.setDateOfBirth(personToBeUpdate.getDateOfBirth());
        updatePerson.setCreatedAt(personToBeUpdate.getCreatedAt());

        peopleRepository.save(updatePerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }


}
