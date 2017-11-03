package pt.rob.h2.db.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rob Benton
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTimestamp
{
  private static final Date DATE = new Date();
  private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.000000");

  private AnnotationConfigApplicationContext context;
  private DataSource dataSource;

  @BeforeAll
  private void beforeAll()
  {
    this.context = new AnnotationConfigApplicationContext(pt.rob.h2.db.spring.DbConfig.class);
    this.dataSource = this.context.getBean(DataSource.class);
  }

  @AfterAll
  private void afterAll()
  {
    this.context.close();
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
