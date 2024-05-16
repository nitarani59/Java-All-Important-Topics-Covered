import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExceptionHandsOn {
    public static void main(String[] args) throws IOException {
            List<Player> players = getPlayers();
            System.out.println(players.get(0).getName());
            players.get(1).setName("name: aarohi");
            System.out.println(players.get(1).getName());
            System.out.println(players.get(2).getName());
            System.out.println(players.get(3).getName());
    }

    public static List<Player> getPlayers() throws IOException {
        Path path = Paths.get("gson_user1.json");
        List<String> players = Files.readAllLines(path);

        return players.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setName(String name) {
        this.name = name;
    }
}
