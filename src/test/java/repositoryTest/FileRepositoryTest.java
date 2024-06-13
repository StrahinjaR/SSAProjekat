package repositoryTest;
import StudetnskaPlatforma.Moodle.MoodleApplication;
import StudetnskaPlatforma.Moodle.Repository.fileRepository;
import StudetnskaPlatforma.Moodle.Entity.File;
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
public class FileRepositoryTest {

    @Autowired
    private fileRepository repo;

    @Test
    public void testSaveFile() {
        String fileName = "testFile.txt";
        byte[] data = "Test data".getBytes();
        Long courseId = 4L;
        String courseName = "Baze podataka";

        repo.saveFile(fileName, data, courseId, courseName);

        List<File> files = repo.coursefiles(courseName);
        boolean fileExists = files.stream()
                .anyMatch(file -> file.getFileName().equals(fileName) && file.getCourse_id().equals(courseId));

        assertThat(fileExists).isTrue();
    }



    @Test
    public void testCourseFiles() {
        String courseName = "Test Course";

        List<File> files = repo.coursefiles(courseName);

        assertThat(files).isNotNull();
        // Add more assertions based on your requirements
    }
}

