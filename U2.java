import java.util.Random;

public class U2 extends Rocket{

    public U2(){
        costInMillion = 120;
        rocketWeightKg = 18000;
        maxWeightKg = 29000;
        launchFailRate = 0.04;
        landFailRate = 0.08;
    }

    public boolean launch(){ //launch
        Random rnd = new Random();
        double modifier = (double)rocketWeightKg/ (double)maxWeightKg;
        double probabilityResult = launchFailRate * modifier;
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