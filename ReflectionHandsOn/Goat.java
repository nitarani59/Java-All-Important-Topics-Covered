package ReflectionHandsOn;

public class Goat extends Animal implements Locomotion {
    @Override
    protected String getSound() {
        return "bleat";
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }

    @Override
    public String eats() {
        return "grass";
    }

    public Goat(String  name) {
        super(name);
    }
}
