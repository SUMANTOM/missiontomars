public class Rocket implements SpaceShip{
    public int costInMillion;
    public int rocketWeightKg;
    public int maxWeightKg;
    public double launchFailRate;
    public double landFailRate;

    public boolean launch(){
        return true;
    }
    public boolean land(){
        return true;
    }
    public void carry(Item item){
        this.rocketWeightKg += item.weight;
    }
    public boolean canCarry(Item item){
        return item.weight + this.rocketWeightKg <= this.maxWeightKg;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "costInMillion=" + costInMillion +
                ", rocketWeightKg=" + rocketWeightKg +
                ", maxWeightKg=" + maxWeightKg +
                ", launchFailRate=" + launchFailRate +
                ", landFailRate=" + landFailRate +
                '}';
    }
}