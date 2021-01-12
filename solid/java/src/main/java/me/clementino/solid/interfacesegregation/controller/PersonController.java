package me.clementino.solid.interfacesegregation.controller;

import me.clementino.solid.interfacesegregation.crud.ICreateReadUpdateDelete;
import me.clementino.solid.interfacesegregation.entity.Person;

import java.util.List;
import java.util.Optional;

public class PersonController {

    private final ICreateReadUpdateDelete<Person> decoratedCRUD;

    public PersonController(ICreateReadUpdateDelete<Person> decoratedCRUD) {
        this.decoratedCRUD = decoratedCRUD;
    }

    public Optional<Person> findPerson(Person person){
        return Optional.ofNullable(this.decoratedCRUD.readOne(person));
    }

    public List<Person> findAll(){
        return this.decoratedCRUD.readAll();
    }

    public void savePerson(Person person){
        this.decoratedCRUD.create(person);
    }

    public void updatePerson(Person person){
        this.decoratedCRUD.update(person);
    }

    public void deletePerson(Person person){
        this.decoratedCRUD.delete(person);
    }
}
