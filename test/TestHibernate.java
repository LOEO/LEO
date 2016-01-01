import com.leo.model.*;
import com.leo.service.OrgService;
import com.leo.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by LT on 2014/12/13.
 */
public class TestHibernate {

    @Test
    public void test(){
                BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
       /* UserService userService = (UserService) beanFactory.getBean("userService");
        User user = userService.userLogin("1","1");
        OrgService orgService = (OrgService) beanFactory.getBean("orgService");
        List<Org> l = orgService.getOrgList(0);*/
        SessionFactory sessionFactory = (SessionFactory) beanFactory.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ProductType productType = new ProductType();
        productType.setName("类别2");
        ProductType productType1 = new ProductType();
        productType1.setName("类别1");

        List<ProductType> list = new ArrayList<ProductType>();
        list.add(productType);
        list.add(productType1);
        Product product = new Product();
        product.setName("123123");
        product.getProductTypes().addAll(list);
       /* Set<ProductType> productTypes = product.getProductTypes();
                productTypes.addAll(list);
        session.save(product);*/
     /*   User user = new User();
        user.setNickname("1111");
        user.setUsername("123123");
        user.setAge(123);
        user.setPassword("1231");
        //User user = (User) session.get(User.class, 1);
        Role role = (Role) session.get(Role.class, 4);
        user.getRoles().add(role);
        role.getUsers().add(user);*/
        session.save(product);
        session.getTransaction().commit();
        System.out.print(product);
    }
}
