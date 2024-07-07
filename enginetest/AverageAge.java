import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AverageAge {

    public static void main(String[] args) {
        String pathNetherlands = "../resources/netherlands.csv";
        String pathEngland = "../resources/england.csv";
        
        System.out.println("Average age of Netherlands starting lineup: " + calculateAverageAge(pathNetherlands) + " years old");
        System.out.println("Average age of England starting lineup: " + calculateAverageAge(pathEngland) + " years old");
    }

    private static int calculateAverageAge(String filePath) {
        List<Integer> ages = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields[4].equals("T")) {
                    LocalDate birthDate = LocalDate.parse(fields[6], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    int age = Period.between(birthDate, LocalDate.now()).getYears();
                    ages.add(age);
                }
            }
            return (int) Math.floor(ages.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN));
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}