package com.epam;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Evgeny Borisov
 */
@SpringBootApplication
@PropertySource("user.properties")
public class MainApp {



    @Bean
    public SparkContext sc() {
        return new SparkContext(new SparkConf().setMaster("local[*]").setAppName("music"));
    }

    public static void main(String[] args) {

        SpringApplication.run(MainApp.class);
    }
}
