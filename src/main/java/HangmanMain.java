import com.lochana.hangman.game.Game;
import com.lochana.hangman.game.GameFactory;
import com.lochana.hangman.game.GameType;
import com.lochana.hangman.game.WordGame;

public class HangmanMain {
    public static void main(String[] args) {
        Game newgame = GameFactory.play(GameType.WORDGAME);
        newgame.run();
    }
}
