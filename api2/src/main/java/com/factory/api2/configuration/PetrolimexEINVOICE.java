package com.factory.api2.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction. annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
    entityManagerFactoryRef = "einvoiceEntityManagerFactory",
    transactionManagerRef = "einvoiceTransactionManager",
    basePackages = {"com.factory.api2.repositories.einvoice"}
)
public class PetrolimexEINVOICE {
    @Bean(name = "einvoiceDataSource")
    public DataSource einvoiceDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/petrolimex_einvoice")
                .username("root")
                .password("0907718993")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean(name = "einvoiceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean einvoiceEntityManagerFactory (
        EntityManagerFactoryBuilder builder,
        @Qualifier("einvoiceDataSource") DataSource dataSource) 
    {
        return builder
                .dataSource(dataSource)
                .packages("com.factory.api2.ms.models.einvoice")
                .persistenceUnit("einvoice")
                .build();
    }

    @Bean(name = "einvoiceTransactionManager")
    public PlatformTransactionManager einvoiceTransactionManager(
        @Qualifier("einvoiceEntityManagerFactory") EntityManagerFactory entityManagerFactory) 
    {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
