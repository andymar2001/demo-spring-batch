package com.example.demo.spring.batch.processor;

import com.example.demo.spring.batch.model.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;

@Log4j2
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        String name = person.getName().toUpperCase();
        String lastName1 = person.getLastName1().toUpperCase();
        String phone = person.getPhone();

        Person newPerson = new Person(name, lastName1, phone);
        log.info("Convirtiendo {} a {}", person, newPerson);

        return newPerson;
    }

}
