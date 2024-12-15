import java.io.*;
import java.util.*;
public class Player {
    protected String name;
    protected int score = 0;
    public Player(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score += score;
    }
    public void totalScore(int deaths){
        this.score -= deaths;
    }
    public void writeScoreToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Francis Kyle\\Desktop\\Highscore.txt", true));
            writer.write(name + " : " + score + " score");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void displayHighScores() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Francis Kyle\\Desktop\\Highscore.txt"));
            List<String> scores = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                scores.add(line);
            }

            scores.sort(Comparator.comparingInt(s -> {
                String[] parts = s.split(":");
                if (parts.length > 1) {
                    String scoreString = parts[1].trim().split(" ")[0];
                    try {
                        return Integer.parseInt(scoreString);
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }));
            Collections.reverse(scores);


            int displayCount = Math.min(scores.size(), 10);
            for (int i = 0; i < displayCount; i++) {
                System.out.println((i + 1) + ". " + scores.get(i));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}

