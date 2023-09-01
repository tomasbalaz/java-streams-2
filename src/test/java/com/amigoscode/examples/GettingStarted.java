package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        List<Person> peopleLessOrEqualThan18 = new ArrayList<>();
        List<Person> peopleLessOrEqualThan18_2 = new ArrayList<>();

        //1st solution
        for(Person person : people) {
            if(person.getAge() <= 18) {
                peopleLessOrEqualThan18.add(person);
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(peopleLessOrEqualThan18.get(i));
        }

        System.out.println();

        //2nd solution
        int limit = 10;
        int counter = 0;
        for(Person person : people) {
            if(person.getAge() <= 18) {
                peopleLessOrEqualThan18_2.add(person);
                counter++;
                if (counter == limit) {
                    break;
                }
            }
        }
        peopleLessOrEqualThan18_2.forEach(System.out::println);

    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();
        List<Person> youngPeople = people.stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .toList();

        youngPeople.forEach(System.out::println);
    }
}
