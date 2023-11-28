package cmd_version;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String ques;
    private String trueans;
    private static ArrayList<Game> g = new ArrayList<Game>();

    public static Game game;

    static {
        try {
            game = new Game();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Game() throws IOException {
        readDataForGame();
    }

    public Game(String ques, String trueans) {
        this.ques = ques;
        this.trueans = trueans;
    }

    public void readDataForGame() throws IOException {
        File f = new File("src/main/java/cmd_version/wordd.txt");
        FileReader fr = new FileReader(f, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break;
            String[] w = line.split("\t");
            ques = w[1].trim();
            trueans = w[0].trim();
            Game game = new Game(ques, trueans);
            g.add(game);
        }
        fr.close();
        br.close();
    }

    public int randomQues() {
        Random r = new Random();
        return r.nextInt(g.size());
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        String option = "n";
        do {
            int r = randomQues();
            System.out.print(g.get(r).ques + " in English is: ");
            String ans = sc.next();
            if (ans.equals(g.get(r).trueans)) {
                System.out.println("Correct\nDo you want to continue? (y/n)");
            } else {
                System.out.println("Incorrect\nTrue answer is: " + g.get(r).trueans + "\nDo you want to continue? (y/n)");
            }
            option = sc.next();

        } while (!option.equalsIgnoreCase("n"));

    }
}
