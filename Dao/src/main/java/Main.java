import com.config.DaoConfig;
import com.entity.User;
import com.repository.BookRepository;
import lombok.Data;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Data
public class Main {

    public static void main(String[] args) {


        AbstractApplicationContext AAC = new AnnotationConfigApplicationContext(DaoConfig.class);
        BookRepository Bean = (BookRepository) AAC.getBean(BookRepository.class);
        Bean.getAllBookByGenre(1);
        final User user = new User();
        user.setName("name");
        user.setPassword("name");
        System.out.println(user.getId());
        System.out.println(user);

    }
}
