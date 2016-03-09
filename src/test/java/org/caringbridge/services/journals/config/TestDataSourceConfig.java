package org.caringbridge.services.journals.config;


import java.util.Date;

import org.caringbridge.common.services.config.MongoDataSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

/**
 * Configuration class to enable the source of the data for our application during
 * the integration tests. An embedded mongo will be used.
 * (MongoDB will be used for this app).
 *
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@Configuration
@Profile("integration-test")
public class TestDataSourceConfig extends MongoDataSourceConfig {

    
    private static final Logger LOG = LoggerFactory.getLogger(TestDataSourceConfig.class);
    
    public static final String INTEGRATION_TEST_MONGODB_HOST = "localhost";
    
    public static final int INTEGRATION_TEST_MONGODB_PORT = 12345;
    
    public static final String INTEGRATION_TEST_MONGODB_DATABASE = "test";
    
    @Override
    public MongoDbFactory mongoDbFactory() throws Exception {
        
//	MongodForTestsFactory factory = MongodForTestsFactory.with(Version.Main.V3_1);
//	MongoClient client = factory.newMongo();
//	DB db = client.getDB("test");
//	DBCollection col = db.createCollection(getDatabaseName(), new BasicDBObject());
        LOG.info("Starting embedded mongo for testin in port {}", INTEGRATION_TEST_MONGODB_PORT);
        MongodStarter starter = MongodStarter.getDefaultInstance();

        IMongodConfig mongodConfig = new MongodConfigBuilder()
            .version(Version.Main.PRODUCTION)
            .net(new Net(INTEGRATION_TEST_MONGODB_PORT, 
                    Network.localhostIsIPv6()))
            .build();

        MongodExecutable mongodExecutable = null;
        //try {
            mongodExecutable = starter.prepare(mongodConfig);
            mongodExecutable.start();

            MongoClient mongo = new MongoClient(INTEGRATION_TEST_MONGODB_HOST, INTEGRATION_TEST_MONGODB_PORT);
            DB db = mongo.getDB(INTEGRATION_TEST_MONGODB_DATABASE);
            DBCollection col = db.createCollection("testCol", new BasicDBObject());
            col.save(new BasicDBObject("testDoc", new Date()));

            System.out.println("messages collection was created in test database" + col);
            
            return new SimpleMongoDbFactory(mongo, getDatabaseName());
            
//        } finally {
//            if (mongodExecutable != null)
//                mongodExecutable.stop();
//        }
        

    }


    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public Mongo mongo() throws Exception {
       return null;
    }

}
