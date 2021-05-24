package com.juno.competitionmanagementsystemserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@MapperScan("com.juno.competitionmanagementsystemserver.mapper")
public class CompetitionManagementSystemServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetitionManagementSystemServerApplication.class, args);
    }

}
