import java.util.Random;

public class U1 extends Rocket{

    public U1(){
        costInMillion = 100;
        rocketWeightKg = 10000;
        maxWeightKg = 18000;
        launchFailRate = 0.3; //0.05
        landFailRate = 0.1; //0.01
    }

    public boolean launch(){ //launch
        Random rnd = new Random();
        double modifier = (double)rocketWeightKg/ (double)maxWeightKg;
        double probabilityResult = launchFailRate * modifier;
        //System.out.println("Fail calculation: " + launchFailRate + "*" + "(" + rocketWeightKg + "/" + maxWeightKg +")" + " >> " + modifier);
        System.out.println("Launch Fail probability: " + probabilityResult);
        double val = rnd.nextDouble();
        if(val >= probabilityResult){
            return true;
        }
        return false;
    }
    public boolean land(){
        Random rnd = new Random();
        double modifier = (double)rocketWeightKg/ (double)maxWeightKg;
        double probabilityResult = landFailRate * modifier;
        System.out.println("Landing Fail probability: " + probabilityResult);
        double val = rnd.nextDouble();
        if(val >= probabilityResult){
            return true;
        }
        return false;
    }
}