import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AverageMatchScore {
    public static void main(String[] args) {
        List<Integer> englandScores = new ArrayList<>();
        List<Integer> netherlandsScores = new ArrayList<>();

        String filePath = "england_home_match_results.csv"; // Update this to your CSV file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("Red Cards")) {
                    String[] parts = line.split(",");
                    String team = parts[0].trim();
                    int score = Integer.parseInt(parts[1].trim());

                    if ("England".equals(team)) {
                        englandScores.add(score);
                    } else if ("Netherlands".equals(team)) {
                        netherlandsScores.add(score);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double englandAverage = englandScores.stream().mapToInt(Integer::intValue).average().orElse(0);
        double netherlandsAverage = netherlandsScores.stream().mapToInt(Integer::intValue).average().orElse(0);

        System.out.println("England Average Score: " + englandAverage);
        System.out.println("Netherlands Average Score: " + netherlandsAverage);
    }
}