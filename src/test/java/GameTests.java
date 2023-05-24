import org.example.Game;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.NotRegisteredException;

public class GameTests {
    Game game = new Game();
    Player player1 = new Player(1, "Саша", 100);
    Player player2 = new Player(2, "Петя", 150);
    Player player3 = new Player(3, "Вася", 200);
    Player player4 = new Player(4, "Иполит", 250);
    Player player5 = new Player(5, "Боря", 250);

    @BeforeEach
    public void setUp() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    void testFirstPlayerIsStronger() {
        int actual = game.round("Вася", "Саша");
        Assertions.assertEquals(1, actual);
    }

    @Test
    void testSecondPlayerIsStronger() {
        int actual = game.round("Петя", "Иполит");
        Assertions.assertEquals(2, actual);
    }

    @Test
    void testPlayersAreEqual() {
        int actual = game.round("Боря", "Иполит");
        Assertions.assertEquals(0, actual);
    }

    @Test
    void testNotRegisteredExceptionOne() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Гриша", "Саша");
        });
    }

    @Test
    void testNotRegisteredExceptionSecond() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Гриша");
        });
    }
}