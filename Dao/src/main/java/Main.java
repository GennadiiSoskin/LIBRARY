import com.config.DaoConfig;
import com.entity.Book;
import com.repository.BookJpaRepository;
import com.repository.UserJpaRepository;
import com.repository.impl.BookRepositoryImpl;
import lombok.Data;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;


@Component
@Data
public class Main {

    public static void main(String[] args) {


        AbstractApplicationContext AAC = new AnnotationConfigApplicationContext(DaoConfig.class);
        BookJpaRepository bean = AAC.getBean(BookJpaRepository.class);


        System.out.println(bean.findById((long) 10));
    }
}
