package com.epam;

import com.epam.services.UserProps;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
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
    public Broadcast<UserProps> userPropsBroadcast(JavaSparkContext sc, UserProps userProps) {
        return sc.broadcast(userProps);
    }


    @Bean
    public JavaSparkContext javaSparkContext(SparkContext sparkContext) {
        return new JavaSparkContext(sparkContext);
    }


    @Bean
    public SparkContext sc() {
        return new SparkContext(new SparkConf().setMaster("local[*]").setAppName("music"));
    }

    public static void main(String[] args) {

        SpringApplication.run(MainApp.class);
    }
}
















