package com.factory.api2.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
    entityManagerFactoryRef = "ssoEntityManagerFactory",
    transactionManagerRef = "ssoTransactionManager",
    basePackages = {"com.factory.api2.repositories.sso"}
)
public class PetrolimexSSO {
    @Primary
    @Bean(name = "ssoDataSource")
    public DataSource ssoDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/petrolimex_sso")
                .username("root")
                .password("0907718993")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Primary
    @Bean(name = "ssoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ssoEntityManagerFactory (
        EntityManagerFactoryBuilder builder,
        @Qualifier("ssoDataSource") DataSource dataSource) 
    {
        return builder
                .dataSource(dataSource)
                .packages("com.factory.api2.models.sso")
                .persistenceUnit("sso")
                .build();
    }

    @Primary
    @Bean(name = "ssoTransactionManager")
    public PlatformTransactionManager ssoTransactionManager(
        @Qualifier("ssoEntityManagerFactory") EntityManagerFactory entityManagerFactory) 
    {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
