package code.algods.arrays;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TimeSliceProcessors {
    public static void main(String[] args) {

       for (List<List<Integer>> input: inputs()) { // test each input

           if (input.size() <= 1) { // if empty or just 1 element
               System.out.println("Processors: " + input.size() + " for " + input);
               continue;
           }

           // Sort on first element
           input = input.stream().sorted(Comparator.comparing(n -> n.get(0))).toList();

           TreeSet<Integer> endings = new TreeSet<>();
           endings.add(input.get(0).get(1)); // last element of first range

           for (int i = 1; i < input.size() ;i++) {
               var curr = input.get(i);

               Integer rangeEndingJustBefore = endings.floor(curr.get(0) - 1); // -1 to set end with 40 and start at 40 are overlapping
               if (rangeEndingJustBefore != null) { // means there ends a task before this
                    endings.remove(rangeEndingJustBefore);
               }

               endings.add(curr.get(1)); // add the ending of curr task
           }

           System.out.println("Processors: " + endings.size() + " for " + input);
       }
    }

    private static Set<List<List<Integer>>> inputs() {
        Set<List<List<Integer>>> inputs = Set.of(
                List.of(), // 0 task
                List.of(List.of(10, 20)), // just 1 task
                List.of(List.of(10, 20), List.of(5,9), List.of(25, 35), List.of(1, 2)), // nobody overlaps
                List.of(List.of(10, 20), List.of(15,27), List.of(25, 30)), // 1 overlap
                List.of(List.of(10, 30), List.of(10, 20), List.of(18,27)), // muliple overlap
                List.of(List.of(10, 51), List.of(11, 20), List.of(21,27), List.of(31, 40), List.of(41, 41), List.of(42, 50)), // 1 big task and other range within
                List.of(List.of(5, 15), List.of(10, 25), List.of(16,30), List.of(26, 35)) // chain of back to back tasks
        );

        return inputs;
    }
}
