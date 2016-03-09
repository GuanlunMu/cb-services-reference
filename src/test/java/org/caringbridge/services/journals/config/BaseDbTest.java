package org.caringbridge.services.journals.config;


import static com.lordofthejars.nosqlunit.mongodb.MongoDbConfigurationBuilder.mongoDb;

import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.test.context.ActiveProfiles;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;

/**
 * Base test class that will prepare the seed data located in data_seed.json
 * file before any test are ran. Very useful when interacting with a database
 * and repositories in the unit tests.
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@UsingDataSet(locations="/data_seed.json")
@ActiveProfiles("integration-test")
public abstract class BaseDbTest {

        @Rule
        public MongoDbRule mongoRule = new MongoDbRule(mongoDb()
            .host(TestDataSourceConfig.INTEGRATION_TEST_MONGODB_HOST)
            .databaseName(TestDataSourceConfig.INTEGRATION_TEST_MONGODB_DATABASE)
            .port(TestDataSourceConfig.INTEGRATION_TEST_MONGODB_PORT)
            .build());
        
        @Autowired
        MongoDbFactory factory;
        
        
}
