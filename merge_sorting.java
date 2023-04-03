import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class merge_sorting {

    public static ArrayList<Integer> merging (ArrayList<Integer> left, ArrayList<Integer> right) {
        
        ArrayList<Integer> newArray = new ArrayList<>();

        while(Math.min(left.size(), right.size()) > 0){  //пока левая часть или правая часть существуют будем заполнять результирующий массив
            
            if (left.get(0) > right.get(0)){ // если первый элемент правой части меньше первого элемента левой, то удаляем его из левой части
                                                        // помещаем его в результирующий массив 
                int to_insert = right.remove(0);
                newArray.add(to_insert);
            }
            
            else { // если первый элемент левой части меньше первого элемента правой, 
                  // то удаляем его из правой части и помещаем его в результирующий массив 
                int to_insert = left.remove(0);
                newArray.add(to_insert);   
            }
        }
        
        Iterator<Integer> leftIterator = left.iterator();
        Iterator<Integer> rightIterator = right.iterator();

        if(left.size() > 0){ //если правая часть закончилась, то помещаем оставшиеся элементы левой части в результирующий массив 
            while(leftIterator.hasNext()){
                newArray.add(leftIterator.next());
            }
        }

        if(right.size() > 0){//если правая часть закончилась, то помещаем оставшиеся элементы левой части в результирующий массив 
            while(rightIterator.hasNext()){
                newArray.add(rightIterator.next());
            }
        }

        return newArray;
    }


    public static ArrayList<Integer> mergesort(ArrayList<Integer> initArray){

        ArrayList<Integer> newArray = new ArrayList<>();

        if(initArray.size() == 1){//если в исходном массиве остался один элемент, то завершаем разделение на левую и правую части
            newArray = initArray;
        }

        else{

            int half = initArray.size()/2;

            ArrayList<Integer> leftinitArray = new ArrayList<>(half);//рекурсивно разделяем исходный массив на левую часть
            for (int i = 0; i < half; i++) {
                leftinitArray.add(initArray.get(i));
            }
            ArrayList<Integer> leftTempinitArray = new ArrayList<>(leftinitArray);

            ArrayList<Integer> left = mergesort(leftTempinitArray);

            ArrayList<Integer> rightinitArray = new ArrayList<>(initArray.size() - half);//рекурсивно разделяем исходный массив на правую часть
            for (int i = half; i < initArray.size(); i++) { 
                rightinitArray.add(initArray.get(i)); 
            }

            ArrayList<Integer> rightTempinitArray = new ArrayList<>(rightinitArray);

            ArrayList<Integer> right = mergesort(rightTempinitArray);
            newArray = merging(left, right); //обращаемся к методу слияния, описанному выше
        }

        return(newArray);
    }
        
    
    public static void main(String[] args) {

        ArrayList<Integer> initArray = new ArrayList<>();

        Random rnd = new Random();//генерируем массив
        for (int i = 0; i < 10; i++) {
            int num = rnd.nextInt(10);
            initArray.add(num);
        }

        System.out.print(initArray);
        System.out.println();

        ArrayList<Integer> newArray = mergesort(initArray);//запускаем метод сортировки слиянием

        System.out.print(newArray);

    }
    
}
