package hu.nive.ujratervezes.zarovizsga;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }


    public void addDog(Dog dog) {
        dogs.add(dog);
    }
}
