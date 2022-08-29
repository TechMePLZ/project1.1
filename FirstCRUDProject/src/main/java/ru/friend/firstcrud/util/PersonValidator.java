package ru.friend.firstcrud.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.friend.firstcrud.DAO.PersonDAO;
import ru.friend.firstcrud.models.Person;
@Component
public class PersonValidator  implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if(personDAO.show(person.getName()).isPresent()){
            errors.rejectValue("name", "", "Это имя не уникально!");
        }

            }
}
