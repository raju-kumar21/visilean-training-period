package spring.mongo.binaryfile.gridfs.springmongodbbinary.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;


public class MongoConfig extends  AbstractMongoConfiguration{

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Override
    protected String getDatabaseName() {
        // TODO Auto-generated method stub
        return database;
    }

    

    @Override
    public Mongo mongo() throws Exception {
        // TODO Auto-generated method stub
        return new Mongo(host);
    }


   
    
}
