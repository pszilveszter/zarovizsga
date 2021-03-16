package hu.nive.ujratervezes.zarovizsga.dogs;

public class Husky extends Dog {

    private int happiness;

    public Husky(String name) {
        super(name);
        this.happiness = super.getHappiness();
    }


    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    void feed() {
        happiness += 4;
    }

    @Override
    void play(int hours) {
        happiness += (hours * 3);
    }
}
