import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.TreeSet;

public class Main{
        public static void main(String[] args) {
            //size that is element size of objects
            int size = 10000;
            double total=0;
            double total2=0;
            double total3=0;
            Integer[] arr = new Integer[10];

            for (int i = 0; i < 10; i++) {
                double startTime2 = System.nanoTime();
                //TreeSet<Integer> temp= new TreeSet<>();
                //RedBlackTree<Integer> temp=new RedBlackTree<>();
                //SkipList<Integer> temp = new SkipList<>();
                //ConcurrentSkipListSet<Integer> temp = new ConcurrentSkipListSet<>();
                //BTree<Integer> temp= new BTree<>(4);
                BinarySearchTree<Integer> temp=new BinarySearchTree<>();
                for (int j = 0; j < size; j++) {
                    Random rand = new Random();
                    temp.add(rand.nextInt());
                }
                double endTime2 = System.nanoTime();
                System.out.printf("Time elapsed for tree (%d): %f \n ", size, (endTime2 - startTime2)/1000000);
                total=total+(endTime2 - startTime2)/1000000;
                startTime2 = System.nanoTime();
                for (int j = 0; j < 10; j++) {
                    Random rand = new Random();
                    arr[j]=rand.nextInt();
                    temp.add(arr[j]);
                }
                endTime2 = System.nanoTime();
                System.out.printf("Time elapsed for  tree extra 10 element : %f \n ", (endTime2 - startTime2)/1000000);
                total2=total2+(endTime2 - startTime2)/1000000;
                startTime2 = System.nanoTime();
                try {
                    for (int j = 0; j < 10; j++) {

                            temp.remove(arr[j]);

                    }
                }catch(UnsupportedOperationException e) {

                }
                endTime2 = System.nanoTime();
                total3=total3+(endTime2 - startTime2)/1000000;
                System.out.printf("Time elapsed for  tree extra 10 deletion element : %f \n ", (endTime2 - startTime2)/1000000);
                
            }
            System.out.println("total1 "+total/10+"  total2 "+ total2/10 + "  total3 " + total3/10);

        }



}
