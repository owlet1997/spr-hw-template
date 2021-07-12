import org.example.connector.annotation.AnnotationHSQLConnector;
import org.example.connector.java.JavaHSQLConnector;
import org.example.connector.programmatic.ProgrammaticHSQLConnector;
import org.example.connector.xml.XmlHSQLConnector;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.example.config.javaconf.ApplicationConfiguration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationContextTest {
  private final String login = "sa";
  private final String password = "";

  @Test
  void shouldCreateXmlConnector() {
    final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    final XmlHSQLConnector bean = context.getBean(XmlHSQLConnector.class);
    assertEquals(login, bean.getLogin());
    assertEquals(password, bean.getPassword());
  }

  @Test
  void shouldCreateAnnotationConnector(){
    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
    final AnnotationHSQLConnector bean = context.getBean(AnnotationHSQLConnector.class);
    assertEquals(login, bean.getLogin());
    assertEquals(password, bean.getPassword());

  }

  @Test
  void shouldCreateJavaConnector() {
    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    final JavaHSQLConnector bean = context.getBean(JavaHSQLConnector.class);
    assertEquals(login, bean.getLogin());
    assertEquals(password, bean.getPassword());
  }

  @Test
  void shouldCreateProgramConnector(){
    final GenericApplicationContext context = new GenericApplicationContext();
    context.registerBean(PropertySourcesPlaceholderConfigurer.class, () -> {
      final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
      configurer.setLocations(new ClassPathResource("db.properties"));
      return configurer;
    });
    context.registerBean(ProgrammaticHSQLConnector.class, "${login}", "${password}");
    context.refresh();

    final ProgrammaticHSQLConnector bean = context.getBean(ProgrammaticHSQLConnector.class);
    assertEquals(login, bean.getLogin());
    assertEquals(password, bean.getPassword());
  }
}
