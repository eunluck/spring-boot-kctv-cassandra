/*
package com.kctv.api.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

*/
/*
  spring.data.cassandra.keyspace-name=kctv
  spring.data.cassandra.contact-points=127.0.0.1
  spring.data.cassandra.port=9042
  spring.data.cassandra.schema-action=create_if_not_exists
  *//*


  @Value("${spring.data.cassandra.contact-points}")
  private String contactPoints;

  @Value("${spring.data.cassandra.port}")
  private int port;

  @Value("${spring.data.cassandra.keyspace-name}")
  private String keySpace;



  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return port;
  }


  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.CREATE_IF_NOT_EXISTS;
  }

  @Override
  protected String getKeyspaceName() {
    return keySpace;
  }
}
*/
