import java.util.LinkedList;
import java.util.Random;
/**
 * Main Class to test
 * @author mustafa
 *
 */
public class Main {
	public static void main(String[] args){

        int size = 100;
        double total2=0;
        double total=0;

        LinkedList<LinkedList<Integer>> deneme = new LinkedList<>();
        for(int i = 0; i < 20; i++) {
            LinkedList<Integer> temp=new LinkedList<>();
            for (int j = 0; j < size; j++) {
                Random rand = new Random();
                temp.add(rand.nextInt());
            }
            deneme.add(temp);
        }

        Merge merge=new Merge();
        Quick quick = new Quick();
        for(int j = 0; j < 20; ++j) {
            double startTime2 = System.nanoTime();
            merge.sort(deneme.get(j));
            double endTime2 = System.nanoTime();
            total2=total2+endTime2-startTime2;
            System.out.printf("Time elapsed for %d . merge list (%d): %f ns\n ", (j+1), size, endTime2-startTime2);
            
            startTime2 = System.nanoTime();
            quick.quickSort(deneme.get(j),0,size-1);
            endTime2 = System.nanoTime();
            total=total+endTime2-startTime2;
            System.out.printf("Time elapsed for %d . quick list (%d): %f ns\n ", (j+1), size, endTime2-startTime2);
        }
        

        LinkedList<Integer> sorted = new LinkedList<>();
        for(int i = 0; i < size ; i++)
            sorted.add(i);


        double startTime2 = System.nanoTime();
        merge.sort(sorted);
        double endTime2 = System.nanoTime();
        total2=total2+endTime2-startTime2;
        System.out.printf("Time elapsed for sorted merge list : %f ns\n ",endTime2-startTime2);
        
        startTime2 = System.nanoTime();
        quick.quickSort(sorted,0,size-1);
        endTime2 = System.nanoTime();
        total=total+endTime2-startTime2;
        System.out.printf("Time elapsed for sorted quick list : %f ns\n ",endTime2-startTime2);
        System.out.println("\nTOTAL for merge = " + total2 + " ns\n");
        System.out.println("\nTOTAL for quick = " + total + " ns\n");
    }
}
