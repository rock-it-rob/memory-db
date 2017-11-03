package pt.rob.h2.db.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * DbConfig is a spring configuration class.
 *
 * @author Rob Benton
 */
@Configuration
public class DbConfig
{
  private static final String DBNAME = "memDb;mode=db2";

  @Bean
  public DataSource db2Mode()
  {
    return new EmbeddedDatabaseBuilder().setName(DBNAME).setType(EmbeddedDatabaseType.H2).addDefaultScripts().build();
  }
}
