package repositoryTest;


import StudetnskaPlatforma.Moodle.Entity.Enrolled;
import StudetnskaPlatforma.Moodle.MoodleApplication;
import StudetnskaPlatforma.Moodle.Repository.enrolledRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = MoodleApplication.class)
@Transactional
@Rollback
public class EnrolledRepositoryTest {

    @Autowired
    private enrolledRepository repo;

    @Test
    public void testEnrollUserToCourse() {
        String username = "ivona";
        Long courseId = 7L;

        repo.enrollUserToCourse(username, courseId);

        // Add verification logic here
        // For example, you might need to query the database to verify the enrollment was successful.
        // Since the Enrolled entity and its relation to user_courses is not detailed, you need to adapt this as per your schema.
    }
}

