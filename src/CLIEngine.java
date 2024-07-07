import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class CLIEngine {

    private String homeTeamCSV;
    private String awayTeamCSV;
    private int refereePersonality;

    public CLIEngine(String homeTeamCSV, String awayTeamCSV, int refereePersonality) {
        this.homeTeamCSV = homeTeamCSV;
        this.awayTeamCSV = awayTeamCSV;
        this.refereePersonality = refereePersonality;
    }

    public void start() throws Exception {
        //Load info from CSV files
        LoadInfo info = new LoadInfo(homeTeamCSV, awayTeamCSV);

        //Start Simulation
        Team home = info.homeTeam;
        Team away = info.awayTeam;

        //Input info about Referee
        Referee ref = new Referee("Jose Viana",
                "portuguese",
                Integer.valueOf(refereePersonality));

        Game game = new Game(home, away, ref);
        Result res = game.startSimulation();

        //Show results
        System.out.println("\n");
        System.out.println(home.name + ": " + res.goalsHomeTeam);
        System.out.println(away.name + ": " + res.goalsAwayTeam);

        System.out.println("Red Cards " + home.name + ": " + res.redCardsHomeTeam);
        System.out.println("Red Cards " + away.name + ": " + res.redCardsAwayTeam);

        // Print match results to CSV file for bulk testing match variables
        try {
            FileWriter fileWriter = new FileWriter("../enginetest/match_results.csv", true); // Append mode
            PrintWriter printWriter = new PrintWriter(fileWriter);
        
            // Writing to the file
            printWriter.println(home.name + "," + res.goalsHomeTeam);
            printWriter.println(away.name + "," + res.goalsAwayTeam);
            printWriter.println("Red Cards " + home.name + "," + res.redCardsHomeTeam);
            printWriter.println("Red Cards " + away.name + "," + res.redCardsAwayTeam);
        
            printWriter.close(); // Close to flush and release resources
            System.out.println("Results also saved to match_results.csv");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void main(String homeTeamCSV, String awayTeamCSV, int refereePersonality) throws Exception {
        CLIEngine engine = new CLIEngine(homeTeamCSV, awayTeamCSV, refereePersonality);
        engine.start();
    }
} 
    

