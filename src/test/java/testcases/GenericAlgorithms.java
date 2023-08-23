package testcases;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericAlgorithms {

    /**
     * sort() - is used to sort elements
     * shuffle() - destroy any kind of order present in the data structure
     * reverse() - reverses the order of elements
     * fill() - replace every element in a collection with the specified value
     * copy() - creates a copy of elements from the specified source to destination
     * swap() - swaps the position of two elements in a collection
     * addAll() - adds all the elements of a collection to other collection
     * binarySearch() - searches for the specified element
     *
     * Composition:
     * frequency() - returns the count of the number of times an element is present in the collection
     * disjoint() - checks if two collections contain some common element
     *
     * Extreme Value:
     * min() - are used to find the minimum elements,
     * max() - are used to find the maximum elements,
     */

    @Test
    public void genericAlgorithms() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        System.out.println("Raw ArrayList: " + numbers);

        // Using the sort() method
        Collections.sort(numbers);
        System.out.println("Sorted ArrayList: " + numbers);

        // Using the shuffle() method
        Collections.shuffle(numbers);
        System.out.println("Shuffled ArrayList: " + numbers);

        // Using reverse() method
        Collections.reverse(numbers);
        System.out.println("Reversed ArrayList: " + numbers);

        // Using swap() method
        Collections.swap(numbers, 0, 1);
        System.out.println("ArrayList using swap(): " + numbers);

        // Using fill() method
        Collections.fill(numbers, 1);
        System.out.println("ArrayList using fill(): " + numbers);

        List<Integer> newNumbers = new ArrayList<>();

        // Using copy() method
        //Note: While performing the copy() method both the lists should be of the same size.
        Collections.copy(numbers, newNumbers);
        System.out.println("ArrayList2 using copy(): " + newNumbers);


        // Using addAll method
        newNumbers.addAll(numbers);
        System.out.println("ArrayList2 using addAll(): " + newNumbers);

        // Using binarySearch()
        //Note: The collection should be sorted before performing the binarySearch() method.
        Collections.sort(numbers);
        int pos = Collections.binarySearch(numbers, 3);
        System.out.println("The position of 3 is " + pos);
    }

    @Test
    public void compositionAlgorithms(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        System.out.println("ArrayList: " + numbers);

        // Using frequency()
        int count = Collections.frequency(numbers, 2);
        System.out.println("Count of 2: " + count);

        ArrayList<Integer> newNumbers = new ArrayList<>();
        newNumbers.add(5);
        newNumbers.add(6);
        System.out.println("ArrayList2: " + newNumbers);

        //Using disjoint()
        boolean value = Collections.disjoint(numbers, newNumbers);
        System.out.println("Two lists are disjoint: " + value);
    }

    @Test
    public void extremeValues(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Using min()
        int min = Collections.min(numbers);
        System.out.println("Minimum Element: " + min);

        // Using max()
        int max = Collections.max(numbers);
        System.out.println("Maximum Element: " + max);
    }
}
