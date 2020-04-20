
public class Card {
    private String name;
    private int weight;
    private int roarVolume;
    private int maxSpeed;
    private int numberOfTeeth;

    Card(String name){
        this.name = name;
    }

	public void setValues(int[] values) {
        this.weight = values[0];
        this.roarVolume = values[1];
        this.maxSpeed = values[2];
        this.numberOfTeeth = values[3];
    }
    
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getRoarVolume() {
        return roarVolume;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }


}