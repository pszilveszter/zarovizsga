package hu.nive.ujratervezes.zarovizsga.dogs;

public class Beagle extends Dog {

    private int happiness;

    public Beagle(String name) {
        super(name);
        this.happiness = super.getHappiness();
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    void feed() {
        happiness += 2;
    }

    @Override
    void play(int hours) {
        happiness += (hours * 2);
    }
}
