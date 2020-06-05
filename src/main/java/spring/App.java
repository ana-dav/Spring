package spring;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.model.User;
import spring.service.interfaces.UserService;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("email@gmail.com", "123", "salt".getBytes()));
        userService.add(new User("fffl@gmail.com", "123423", "salt".getBytes()));
        userService.add(new User("sss@gmail.com", "12444443", "salt".getBytes()));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
