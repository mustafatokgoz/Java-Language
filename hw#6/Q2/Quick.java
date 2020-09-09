import java.util.LinkedList;
/**
 * Quick sort with LinkedList
 * @author mustafa
 *
 */
public class Quick {
	/**
	 * Using LİnkedList instead of array
	 * @param <T>
	 * @param table
	 * @param first
	 * @param last
	 * @return
	 */
    protected <T extends Comparable<T>> int partition(LinkedList<T> table,
            int first, int last) {
			//Select the first item as the pivot value.
				T pivot = table.get(first);
				int up = first; int down = last;
				do {
				//Invariant:
				//All items in table[first . . . up - 1] <= pivot
				//All items in table[down + 1 . . . last] > pivot
				while ((up < last) && (pivot.compareTo(table.get(up)) >= 0)) {
				up++;
				}
				//assert: up equals last or table[up] > pivot.
				while (pivot.compareTo(table.get(down)) < 0) {
				down--;
				}
				//assert: down equals first or table[down] <= pivot.
				if (up < down) { // if up is to the left of down.
				//Exchange table[up] and table[down].
				T temp = table.get(up);
				table.set(up,table.get(down));
				table.set(down,temp);
				}
				} while (up < down); // Repeat while up is left of down.
				//Exchange table[first] and table[down] thus putting the
				//pivot value where it belongs.
				T temp = table.get(first);
				table.set(first,table.get(down));
				table.set(down,temp);
				//Return the index of the pivot value.
				return down;
			}
    /**
     * Using LinkedLİst istead of array
     * @param <T>
     * @param table
     * @param first
     * @param last
     */
			public <T extends Comparable<T>> void quickSort(LinkedList<T> table,
			             int first,
			             int last) {
						if (first < last) { // There is data to be sorted.
						//Partition the table.
						int pivIndex = partition(table, first, last);
						//Sort the left half.
						quickSort(table, first, pivIndex - 1);
						//Sort the right half.
						quickSort(table, pivIndex + 1, last);
						}
			}
			
}
