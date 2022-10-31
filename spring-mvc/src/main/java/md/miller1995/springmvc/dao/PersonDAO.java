package md.miller1995.springmvc.dao;

import md.miller1995.springmvc.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.hibernate5.HibernateTransactionManager;


import java.util.List;

@Component
public class PersonDAO {


    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index(){
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id){
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }


    @Transactional
    public void save(Person person){
        Session session = sessionFactory.getCurrentSession();

        session.save(person);
    }

    @Transactional(readOnly = true)    // doesn't work
    public void update(int id, Person updatePerson){
        Session session = sessionFactory.getCurrentSession();

        Person personToBeUpdated = session.get(Person.class, id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
        personToBeUpdated.setAddress(updatePerson.getAddress());

    }

    @Transactional(readOnly = true)    // doesn't work
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Person.class, id));
        }



}
