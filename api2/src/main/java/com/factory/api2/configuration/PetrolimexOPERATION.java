package com.factory.api2.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
    entityManagerFactoryRef = "operationEntityManagerFactory",
    transactionManagerRef = "operationTransactionManager",
    basePackages = {"com.factory.api2.repositories.operation"}
)
public class PetrolimexOPERATION {

    @Bean(name = "operationDataSource")
    public DataSource operationDataSource(@Value("${operation.year}") String year) {
        String jdbcUrl = String.format("jdbc:mysql://localhost:3306/petrolimex_operation%s", year);
        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username("root")
                .password("0907718993")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean(name = "operationEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean operationEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("operationDataSource") DataSource dataSource) 
    {
        return builder.dataSource(dataSource)
                    .packages("com.factory.api2.mvvm.models.operation")
                    .persistenceUnit("operation")
                    .build();
    }

    @Bean(name = "operationTransactionManager")
    public PlatformTransactionManager operationTransactionManager(
        @Qualifier("operationEntityManagerFactory") EntityManagerFactory entityManagerFactory ) 
    {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
