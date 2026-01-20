package other.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    void setup() {
        userManager = new UserManager();
    }

    @Test
    void should_AddUser() {
        // given
        User user = new User("testuser", "password123");

        // when
        userManager.addUser(user);

        // then
        assertEquals(1, userManager.getUserCount());
        assertEquals(user, userManager.getUser("testuser").get());
    }

    @Test
    void should_GetUser_When_UserPresent() {
        // given
        User user = new User("testuser", "password123");
        userManager.addUser(user);

        // when
        Optional<User> retrievedUser = userManager.getUser("testuser");

        // then
        assertTrue(retrievedUser.isPresent());
        assertEquals(user, retrievedUser.get());

        BigDecimal a = BigDecimal.ONE;
        System.out.println(a.toString());
    }

    @Test
    void should_GetUser_When_UserNotPresent() {
        // given - empty

        // when
        Optional<User> retrievedUser = userManager.getUser("testuser2");

        // then
        assertFalse(retrievedUser.isPresent());
    }

    @Test
    void should_VerifyUsernameTaken_When_usernameNonexistent() {
        // given - empty

        // when
        boolean isNonexistentUserTaken = userManager.isUsernameTaken("nonexistentUser");

        // then
        assertFalse(isNonexistentUserTaken);
    }

    @Test
    void should_VerifyUsernameTaken_When_usernameTaken() {
        // given
        User user = new User("testuser", "password123");
        userManager.addUser(user);

        // when
        boolean isTestuserTaken = userManager.isUsernameTaken("testuser");

        // then
        assertTrue(isTestuserTaken);
    }

    @Test
    void should_DeleteUser_when_UserPresent() {
        // given
        User user = new User("testuser", "password123");
        userManager.addUser(user);

        // when
        userManager.deleteUser("testuser");

        // then
        assertTrue(userManager.getUser("testuser").isEmpty());
        assertEquals(0, userManager.getUserCount());
    }
}
