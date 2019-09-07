import com.config.DaoConfig;
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
        Bean.getAll();


    }
}
