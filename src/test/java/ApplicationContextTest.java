import org.example.connector.annotation.AnnotationHSQLConnector;
import org.example.connector.java.JavaHSQLConnector;
import org.example.connector.java.javaconf.ApplicationConfiguration;
import org.example.connector.programmatic.ProgrammaticHSQLConnector;
import org.example.connector.xml.XmlHSQLConnector;
import org.hsqldb.jdbc.JDBCDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApplicationContextTest {

    @Test
    void shouldCreateXmlConnector() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        final XmlHSQLConnector bean = context.getBean(XmlHSQLConnector.class);
        final DataSource dataSource = bean.getDataSource();

        assertNotNull(bean);
        assertNotNull(dataSource);
    }

    @Test
    void shouldCreateAnnotationConnector() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example.connector.annotation");
        final AnnotationHSQLConnector bean = context.getBean(AnnotationHSQLConnector.class);
        final DataSource dataSource = bean.getDataSource();

        assertNotNull(bean);
        assertNotNull(dataSource);

    }

    @Test
    void shouldCreateJavaConnector() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        final JavaHSQLConnector bean = context.getBean(JavaHSQLConnector.class);
        final DataSource dataSource = bean.getDataSource();

        assertNotNull(bean);
        assertNotNull(dataSource);
    }

    @Test
    void shouldCreateProgramConnector() {
        final GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(PropertySourcesPlaceholderConfigurer.class, () -> {
            final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
            configurer.setLocations(new ClassPathResource("db.properties"));
            return configurer;
        });
        context.registerBean(ProgrammaticHSQLConnector.class);
        context.registerBean("dataSource", JDBCDataSource.class,
                beanDefiniton -> beanDefiniton.getPropertyValues()
                        .add("database", "${url}")
                        .add("user", "${login}")
                        .add("password", "${password}")
        );
        context.refresh();

        final ProgrammaticHSQLConnector bean = context.getBean(ProgrammaticHSQLConnector.class);
        final DataSource dataSource = bean.getDataSource();

        assertNotNull(bean);
        assertNotNull(dataSource);
    }
}
