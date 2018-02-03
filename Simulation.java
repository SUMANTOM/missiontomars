import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Simulation{
    public ArrayList<Item> loadItems(ArrayList<Item> itemsArray, String fileName) throws Exception{
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);

        while(fileScanner.hasNextLine()){
            String[] itemArray = fileScanner.nextLine().split("=");
            Item item = new Item();
            item.name = itemArray[0];
            item.weight = Integer.parseInt(itemArray[1]);
            itemsArray.add(item);    
        }
        fileScanner.close();
        return itemsArray;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> itemsArrayList){
        
        ArrayList<U1> u1List = new ArrayList<U1>();
        
        int i = 0;
        System.out.println("Number of items to be loaded in U1 type Rockets: " + itemsArrayList.size());
        while (i <= (itemsArrayList.size() - 1)){
            U1 rocket = new U1();
            System.out.println("\nCreate New U1 Rocket.");
            while(rocket.rocketWeightKg <= rocket.maxWeightKg && i <= (itemsArrayList.size() - 1)){    
                Item item = itemsArrayList.get(i);
                if(rocket.canCarry(item)){
                    System.out.println("Add " + item.toString() + " to rocket.");
                    rocket.carry(item);
                    i++;
                } else {
                    System.out.println("Rocket Full");
                    u1List.add(rocket);
                    break;
                }    
            }

        }
        return u1List;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> itemsArrayList){
        
        ArrayList<U2> u2List = new ArrayList<U2>();
        
        int i = 0;
        System.out.println("Number of items to be loaded in U2 type Rockets: " + itemsArrayList.size());
        while (i <= (itemsArrayList.size() - 1)){
            U2 rocket = new U2();
            System.out.println("\nCreate New U2 Rocket.");
            while(rocket.rocketWeightKg <= rocket.maxWeightKg && i <= (itemsArrayList.size() - 1)){    
                Item item = itemsArrayList.get(i);
                if(rocket.canCarry(item)){
                    System.out.println("Add " + item.toString() + " to rocket.");
                    rocket.carry(item);
                    i++;
                } else {
                    System.out.println("Rocket Full");
                    u2List.add(rocket);
                    break;
                }    
            }

        }
        return u2List;
    }

    public int runSimulation(ArrayList rockets){
        int i = 0;
        int totalBudget = 0;

        Rocket rocket = new Rocket();
        while(i <= (rockets.size() - 1)){
            rocket = (Rocket) rockets.get(i);
            System.out.println("\nRocket Launch: " + (i + 1) + " (" + "Laden weight: " + rocket.rocketWeightKg + " | Max Weight: " + rocket.maxWeightKg + ")");
            totalBudget += rocket.costInMillion;
            if(rocket.launch()){
                System.out.println("Rocket Launch Success!");
                if(rocket.land()){
                    System.out.println("Rocket Landed Successfully!");
                    i++;
                }else{
                    System.out.println("Rocket Crashed on Landing!");
                }
            }else {
                System.out.println("Rocket Launch FAILURE!");
            }
        }
        return totalBudget;
    }
}