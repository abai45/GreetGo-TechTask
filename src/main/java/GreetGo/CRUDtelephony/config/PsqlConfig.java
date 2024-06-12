package GreetGo.CRUDtelephony.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "GreetGo.CRUDtelephony.repository.psql")
public class PsqlConfig {
}
