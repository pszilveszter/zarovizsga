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


    public void feedAll() {
        for (Dog d: dogs) {
            d.feed();
        }
    }


    public Dog findByName(String name) {
        for (Dog d: dogs) {
            if (name.equals(d.getName())) {
                return d;
            }
        }
        throw new IllegalArgumentException("Dog not found");
    }


    public void playWith(String name, int hours) {
        Dog d = findByName(name);
        d.play(hours);
    }


    public List<String> getHappyDogNames(int minHappiness) {
        List<String> happyDogNames = new ArrayList<>();
        for (Dog d: dogs) {
            if (minHappiness < d.getHappiness()) {
                happyDogNames.add(d.getName());
            }
        }
        return happyDogNames;

    }
}
