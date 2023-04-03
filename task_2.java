import java.util.ArrayList;
import java.util.Random;

public class task_2 {

    public static int minOfArray(ArrayList<Integer> myList){
            int arrayMin = myList.get(0);
            for (int i = 1; i < myList.size(); i++) {
                if(myList.get(i)<arrayMin){
                    arrayMin = myList.get(i);
                }
            }
            return arrayMin;
    }

    public static int maxOfArray(ArrayList<Integer> myList){

        int arrayMax = myList.get(0);
        for (int i = 1; i < myList.size(); i++) {
            if(myList.get(i)>arrayMax){
                arrayMax = myList.get(i);
            }
        }
        return arrayMax;
    }

    public static int average(ArrayList<Integer> myList){

        int sum = 0;

        for (int i = 0; i < myList.size(); i++) {
            sum = sum + myList.get(i);
            }
        
        int average = sum/myList.size();
        return average;
    }
    public static void main(String[] args) {
        
        Random rnd = new Random();
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(rnd.nextInt(10));
        }
        System.out.println("\n" + myList + "\n");
        System.out.println("Max --->" + " " + maxOfArray(myList)+ "\n");
        System.out.println("Min --->" + " " +  minOfArray(myList)+ "\n");
        System.out.println("Average --->" + " " +  average(myList)+ "\n");
    }
   
}

