package pt.rob.h2.db.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rob Benton
 */
public class TestTimestamp
{
  private static final Date DATE = new Date();
  private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.000000");

  private static AnnotationConfigApplicationContext context;
  private static DataSource dataSource;

  @BeforeAll
  protected void beforeAll()
  {
    TestTimestamp.context = new AnnotationConfigApplicationContext(pt.rob.h2.db.spring.DbConfig.class);
    TestTimestamp.dataSource = TestTimestamp.context.getBean(DataSource.class);
  }

  @AfterAll
  protected void afterAll()
  {
    TestTimestamp.context.close();
  }

  @Test
  public void testInsertAsDate()
  {
  }

  @Test
  public void testInsertAsTimestamp()
  {}

  @Test
  public void testInsertAsString()
  {}
}
