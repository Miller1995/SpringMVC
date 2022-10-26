package md.miller1995.springmvc.dao;

import md.miller1995.springmvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_ID;


    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_ID, "Mike", 23, "mike@mail.ru"));
        people.add(new Person(++PEOPLE_ID, "Bob", 33, "bob@gmail.com"));
        people.add(new Person(++PEOPLE_ID, "Nick", 44, "nike@yahoo.com"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse( null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_ID);
        people.add(person);
    }

    public void update(int id, Person updatePerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
