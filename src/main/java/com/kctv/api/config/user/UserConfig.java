/*

package com.kctv.api.config.user;


import com.kctv.api.model.userv2.entity.User;
import com.kctv.api.repository.userv2.UserByEmailRepository;
import com.kctv.api.repository.userv2.UserLoginRepository;
import com.kctv.api.repository.userv2.UserNewRepository;
import com.kctv.api.repository.userv2.UserNewRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.mapping.CassandraPersistentEntity;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.cassandra.repository.support.MappingCassandraEntityInformation;

import java.util.UUID;

@Configuration
public class UserConfig {


    @Bean
    public UserNewRepository userNewRepository(
        final CassandraTemplate cassandraTemplate,
        final UserByEmailRepository userByEmailRepository,
        final UserLoginRepository userLoginRepository){
    final CassandraPersistentEntity<?> entity =
            cassandraTemplate.getConverter().getMappingContext().getRequiredPersistentEntity(User.class);
    final CassandraEntityInformation<User,UUID> metadata =
            new MappingCassandraEntityInformation<>(
                    (CassandraPersistentEntity<User>) entity, cassandraTemplate.getConverter()
            );
    return new UserNewRepositoryImpl(
            metadata, cassandraTemplate, userByEmailRepository, userLoginRepository) {
        @Override

        public User findByUserId(UUID uuid) {
            return findById(uuid).get();
        }
    };

    }

}
*/
