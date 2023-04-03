// Пусть дан произвольный список целых чисел, удалить из него чётные числа

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class task_1 {
        public static void main(String[] args) {
            
            Random rnd = new Random();
            ArrayList<Integer> myList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                myList.add(rnd.nextInt(10));
            }

            System.out.println();
            System.out.print(myList + "\t");
            

            Iterator<Integer> myListIterator = myList.iterator();
            while(myListIterator.hasNext()){

                if (myListIterator.next()%2 == 0){
                    myListIterator.remove();
                }
            }
            
            System.out.println();
            System.out.print(myList);
        }
        
    }

