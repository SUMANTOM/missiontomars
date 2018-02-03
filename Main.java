// U1
// Rocket cost = $100 Million
// Rocket weight = 10 Tonnes
// Max weight (with cargo) = 18 Tonnes
// Chance of launch explosion = 5% * (cargo carried / cargo limit)
// Chance of landing crash = 1% * (cargo carried / cargo limit)

// U2
// Rocket cost = $120 Million
// Rocket weight = 18 Tonnes
// Max weight (with cargo) = 29 Tonnes
// Chance of launch explosion = 4% * (cargo carried / cargo limit)
// Chance of landing crash = 8% * (cargo carried / cargo limit)
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){      
        
        ArrayList<Item> phaseOneItemsArray = new ArrayList<Item>();
        ArrayList<Item> phaseTwoItemsArray = new ArrayList<Item>();

        Simulation sim1 = new Simulation();
        System.out.println("\nSTARTING SIMULATION");
        try{
            System.out.println("Loading Equipment list for PHASE 1");
            phaseOneItemsArray = sim1.loadItems(phaseOneItemsArray, "phase1.txt");
            System.out.println("Loading Equipment list for PHASE 2");
            phaseTwoItemsArray = sim1.loadItems(phaseTwoItemsArray, "phase2.txt");

            System.out.println("-------------------------------Using U1 Type Rockets---------------------------------");

            System.out.println("Loading Fleet of U1 Rockets for PHASE 1");
            ArrayList<U1> u1rocketsArrayPhase1 = new ArrayList<U1>();
            u1rocketsArrayPhase1 = sim1.loadU1(phaseOneItemsArray);

            System.out.println("Loading Fleet of U1 Rockets for PHASE 2");
            ArrayList<U1> u1rocketsArrayPhase2 = new ArrayList<U1>();
            u1rocketsArrayPhase2 = sim1.loadU1(phaseTwoItemsArray);
            
            System.out.println("\nSimulating U1 Fleet of " + u1rocketsArrayPhase1.size() + " rockets. Launch and Land Sequences for PHASE 1");
            System.out.println(">>>>>>>>>> BUDGET: $" + sim1.runSimulation(u1rocketsArrayPhase1) + " Million");

            System.out.println("\nSimulating U1 Fleet of " + u1rocketsArrayPhase2.size() + " rockets. Launch and Land Sequences for PHASE 2");
            System.out.println(">>>>>>>>>> BUDGET: $" + sim1.runSimulation(u1rocketsArrayPhase2) + " Million");
            
            System.out.println("-------------------------------Using U2 Type Rockets---------------------------------");
            //-------------------------------------------------------------------

            System.out.println("Loading Fleet of U2 Rockets for PHASE 1");
            ArrayList<U2> u2rocketsArrayPhase1 = new ArrayList<U2>();
            u2rocketsArrayPhase1 = sim1.loadU2(phaseOneItemsArray);

            System.out.println("Loading Fleet of U2 Rockets for PHASE 2");
            ArrayList<U2> u2rocketsArrayPhase2 = new ArrayList<U2>();
            u2rocketsArrayPhase2 = sim1.loadU2(phaseTwoItemsArray);
            
            System.out.println("\nSimulating U2 Fleet of " + u2rocketsArrayPhase1.size() + " rockets. Launch and Land Sequences for PHASE 1");
            System.out.println(">>>>>>>>>> BUDGET: $" + sim1.runSimulation(u2rocketsArrayPhase1) + " Million");

            System.out.println("\nSimulating U2 Fleet of " + u2rocketsArrayPhase2.size() + " rockets. Launch and Land Sequences for PHASE 2");
            System.out.println(">>>>>>>>>> BUDGET: $" + sim1.runSimulation(u2rocketsArrayPhase2) + " Million");
 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}