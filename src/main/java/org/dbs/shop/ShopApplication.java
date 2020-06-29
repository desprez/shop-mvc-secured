package org.dbs.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "org.dbs.shop")
@EnableJpaRepositories
public class ShopApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ShopApplication.class);

	public static void main(final String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		LOG.info("Application is running!");
	}
}
