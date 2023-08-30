package problemsolving;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairAddUptoSum {
    public static void main(String[] args) {

        HashSet hs = new HashSet();


        int[] data = {1,2,3,7,4,8,5};

        Map<Integer, Integer> pair = new HashMap<>();

        int target = 8;

        for (int i=0;i<data.length;i++) {

            if (pair.containsKey(i)) {
                System.out.println(i + ", " + pair.get(i));
            } else {
                pair.put(target - i, i);
            }

        }

    }

}
