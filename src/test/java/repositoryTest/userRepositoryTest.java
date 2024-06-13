package repositoryTest;
import StudetnskaPlatforma.Moodle.Entity.Users;
import StudetnskaPlatforma.Moodle.MoodleApplication;
import StudetnskaPlatforma.Moodle.Repository.userRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = MoodleApplication.class)
public class userRepositoryTest {

    @Autowired
    private userRepository userRepository;

    @Test
    @Transactional
    @Rollback
    public void testFindUserByUsername() {
        String username = "te";
        Optional<Users> user = userRepository.findUserByUsername(username);
        assertTrue(user.isPresent(), "User should be present");
        assertEquals(username, user.get().getName(), "Username should match");
    }

    @Test
    @Transactional
    @Rollback
    public void testSaveUser() {
        String username = "newuser";
        String password = "password";
        String email = "newuser@example.com";
        userRepository.saveUser(username, password, email);

        Optional<Users> user = userRepository.findUserByUsername(username);
        assertTrue(user.isPresent(), "User should be present after saving");
        assertEquals(username, user.get().getName(), "Username should match");
        assertEquals(email, user.get().getEmail(), "Email should match");
    }
}
