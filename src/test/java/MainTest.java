import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws FileNotFoundException {
        Main.readUsers("test.txt");
    }

    @Test
    void processUsersTest() {
        List<User> users = List.of(
                new User("Scufita", "Rosie", LocalDate.of(1994, 4, 6)),
                new User("Motanul", "Incaltat", LocalDate.of(1994, 1, 6)),
                new User("Ursuletul", "Bruno", LocalDate.of(2001, 1, 18))
        );

        List<User> usersExpected = List.of(
                new User("Ursuletul", "Bruno", LocalDate.of(2001, 1, 18)),
                new User("Motanul", "Incaltat", LocalDate.of(1994, 1, 6))
        );

        List<User> usersProcessed = Main.processUsers(1, users);

        assertEquals(usersExpected, usersProcessed);
    }
}