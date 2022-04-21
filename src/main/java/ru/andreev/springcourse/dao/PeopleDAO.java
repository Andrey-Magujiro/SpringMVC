package ru.andreev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.andreev.springcourse.models.People;

import java.util.Arrays;
import java.util.List;

@Component
public class PeopleDAO {
    private List<People> people;
    public static int COUNTER_ID;

    {
        people= Arrays.asList(new People(++COUNTER_ID, "Duha"), new People(++COUNTER_ID, "Andrey"),
        new People(++COUNTER_ID, "Alexander"), new People(++COUNTER_ID, "Alexey"));
    }

    public List<People> index(){
        return people;
    }

    public People show(int id){
        return people.stream().filter(element -> element.getId() == id).findAny().orElse(null);
    }
}
