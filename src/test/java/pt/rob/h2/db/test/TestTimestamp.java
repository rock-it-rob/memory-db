package pt.rob.h2.db.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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

  /**
   * Inserts using a <code>java.sql.Date</code>.
   *
   * @throws SQLException
   */
  @Test
  public void testInsertAsDate() throws SQLException
  {
    try (
      Connection con = this.dataSource.getConnection();
      PreparedStatement st = con.prepareStatement("insert into test.dates values(?)");
    )
    {
      java.sql.Date date = new java.sql.Date(TestTimestamp.DATE.getTime());
      st.setDate(1, date);
      st.execute();
      con.commit();
    }
  }

  /**
   * Inserts using a <code>Timestamp</code>.
   *
   * @throws SQLException
   */
  @Test
  public void testInsertAsTimestamp() throws SQLException
  {
    try (
      Connection con = this.dataSource.getConnection();
      PreparedStatement st = con.prepareStatement("insert into test.dates values(?)");
    )
    {
      Timestamp timestamp = new Timestamp(TestTimestamp.DATE.getTime());
      st.setTimestamp(1, timestamp);
      st.execute();
      con.commit();
    }
  }

  /**
   * Tests insert using a <code>String</code>.
   *
   * @throws SQLException
   */
  @Test
  public void testInsertAsString() throws SQLException
  {
    try (
      Connection con = this.dataSource.getConnection();
      PreparedStatement st = con.prepareStatement("insert into test.dates values(?)");
    )
    {
      String stamp = TestTimestamp.FORMAT.format(TestTimestamp.DATE);
      st.setString(1, stamp);
      st.execute();
      con.commit();
    }
  }
}
