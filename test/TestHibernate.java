import com.leo.dao.UserDao;
import com.leo.dao.daoimp.UserDaoImp;
import com.leo.model.User;
import com.leo.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

/**
 * Created by LT on 2014/12/13.
 */
public class TestHibernate {

    @Test
    public void test(){
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
        UserService userService = (UserService) beanFactory.getBean("userServiceImp");
        User user = new User();
        user.setUsername("LEO");
        user.setPassword("7731481");
        user.setAge(26);
        user.setBirthday(new Date(1988,4,22));
        userService.addUser(user);

    }
}
