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

        people.add(new Person(++PEOPLE_ID, "Mike"));
        people.add(new Person(++PEOPLE_ID, "Bob"));
        people.add(new Person(++PEOPLE_ID, "Nick"));

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
}
