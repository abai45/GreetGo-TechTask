package GreetGo.CRUDtelephony.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "GreetGo.CRUDtelephony.repository.mongodb")
public class MongoDBConfig {
}
