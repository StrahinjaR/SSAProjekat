package repositoryTest;
import StudetnskaPlatforma.Moodle.Entity.Posts;
import StudetnskaPlatforma.Moodle.MoodleApplication;
import StudetnskaPlatforma.Moodle.Repository.postsRepository;
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
public class PostsRepositoryTest {

    @Autowired
    private postsRepository repo;

    @Test
    public void testFindLastFourPosts() {
        List<Posts> posts = repo.findLastFourPosts();
        assertThat(posts).isNotNull();
        assertThat(posts.size()).isLessThanOrEqualTo(4);
    }

    @Test
    public void testSavePost() {
        String title = "New Post";
        String tekst = "This is a new post";
        String url = "http://example.com";

        repo.savePost(title, tekst, url);

        List<Posts> posts = repo.findAll();
        boolean postExists = posts.stream()
                .anyMatch(post -> post.getTitle().equals(title) && post.getTekst().equals(tekst) && post.getUrl().equals(url));

        assertThat(postExists).isTrue();
    }
}

