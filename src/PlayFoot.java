import java.util.Scanner;

public class PlayFoot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("It's kick off time! Are you ready to start the match? (yes/no)");
        String userInput = scanner.nextLine();
        
        if ("yes".equalsIgnoreCase(userInput)) {
            System.out.println("Who is the home team? (England/Netherlands)");
            String homeTeam = scanner.nextLine();
            String homeTeamCSV, awayTeamCSV;
            
            if ("England".equalsIgnoreCase(homeTeam)) {
                homeTeamCSV = "../resources/england.csv";
                awayTeamCSV = "../resources/netherlands.csv";
            } else if ("Netherlands".equalsIgnoreCase(homeTeam)) {
                homeTeamCSV = "../resources/netherlands.csv";
                awayTeamCSV = "../resources/england.csv";
            } else {
                System.out.println("Game shutdown. There was a problem loading the teamsheets.");
                scanner.close();
                return;
            }
            
            System.out.println("How strict is the match referee? (from 0 to 100):");
            int refereePersonality = -1; // Initialize with an invalid value to enter the loop
            while (refereePersonality < 0 || refereePersonality > 100) {
                try {
                    refereePersonality = Integer.parseInt(scanner.nextLine());
                    
                    if (refereePersonality < 0 || refereePersonality > 100) {
                        System.out.println("You must enter a number between 0 and 100. Please try again:");
                        refereePersonality = -1; // Reset to ensure the loop continues
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number between 0 and 100:");
                    }
                }
            
            try {
                CLIEngine engine = new CLIEngine(homeTeamCSV, awayTeamCSV, refereePersonality);
                engine.start();
                System.out.println("Engine started with home team as: " + homeTeam + ", referee discipline: " + refereePersonality);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("Ok then. Match abandoned! See you next time.");
        }
        
        scanner.close();
    }
}
