package service;


import model.Animal;
import model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServiceImpl<T> implements GenericServiceInterface<T> {
    private List<T> elements;

    public ServiceImpl(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public String add(T t) {
        elements.add(t);
        return "Added " + t ;
    }

    @Override
    public T getById(Long id) {
        for (T element : elements) {
            if (element instanceof model.Person) {
                Person person = (Person) element;
                if (person.getId()==(id)) {
                    return (T) person;
                }
            } else if (element instanceof model.Animal) {
                Animal animal = (Animal) element;
                if (animal.getId()==(id)) {
                    return (T) animal;
                }
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return elements;
    }

    @Override
    public List<T> sortByName(int sortOrder) {
        Collections.sort(elements, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof model.Person && o2 instanceof model.Person) {
                    Person person1 = (Person) o1;
                    Person person2 = (Person) o2;
                    return sortOrder == 1 ?
                            person1.getName().compareTo(person2.getName()) :
                            person2.getName().compareTo(person1.getName());
                } else if (o1 instanceof model.Animal && o2 instanceof model.Animal) {
                    Animal animal1 = (Animal) o1;
                    Animal animal2 = (Animal) o2;
                    return sortOrder == 1 ?
                            animal1.getName().compareTo(animal2.getName()) :
                            animal2.getName().compareTo(animal1.getName());
                }
                return 0;
            }
        });
        return elements;
    }

    @Override
    public List<T> clear() {
        elements.clear();
        return elements;
    }
}
