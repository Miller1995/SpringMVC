package md.miller1995.springmvc.dao;

import md.miller1995.springmvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;


    {
        people = new ArrayList<>();

        people.add(new Person( 1, "Mike"));
        people.add(new Person(2, "Bob"));
        people.add(new Person(3, "Nick"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse( null);
    }
}
