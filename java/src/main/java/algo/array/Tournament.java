package algo.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * array [
 * html, c#
 * c#, python
 * python, html
 * ]
 *
 * results [0, 0, 1] 0 => second is winner, 1 => home is winner. home is first value
 * winner python
 */
public class Tournament {

    public static void main(String[] args) {
        List<List<String>> tournament = List.of(
                List.of("html", "c#"),
                List.of("c#", "python"),
                List.of("python", "html")
                );
        List<Integer> results = List.of(0, 0, 1);

        System.out.println(withStreamOnMap(tournament, results));
        System.out.println(withoutMapIteration(tournament, results));
    }

    private static String withoutMapIteration(List<List<String>> tournament, List<Integer> results) {
        String topScoreTeam = "";

        var mapOfScores = new HashMap<String, Integer>();
        mapOfScores.put(topScoreTeam, 0);

        for (int i=0; i < results.size(); i++) {
            int winnerPointer = results.get(i);
            int winnerIndex = winnerPointer == 0 ? 1 : 0;

            String winnerTeam = tournament.get(i).get(winnerIndex);

            mapOfScores.put(winnerTeam, mapOfScores.getOrDefault(winnerTeam, 0) + 3);

            if (mapOfScores.get(topScoreTeam) < mapOfScores.get(winnerTeam)) {
                topScoreTeam = winnerTeam;
            }
        }

        return topScoreTeam;
    }

    private static String withStreamOnMap(List<List<String>> tournament, List<Integer> results) {
        var mapOfScores =  new HashMap<String, Integer>();

        for (int i=0; i < results.size(); i++) {
            int winnerPointer = results.get(i);
            int winnerIndex = winnerPointer == 0 ? 1 : 0;

            String winnerTeam =  tournament.get(i).get(winnerIndex);

            mapOfScores.put(winnerTeam, mapOfScores.getOrDefault(winnerTeam, 0) + 3);
        }

        return mapOfScores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
