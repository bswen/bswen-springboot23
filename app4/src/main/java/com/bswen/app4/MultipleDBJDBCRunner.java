package com.bswen.app4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MultipleDBJDBCRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(MultipleDBJDBCRunner.class);
    @Autowired @Qualifier("mysqlJdbcTemplate")
    JdbcTemplate mysqlJdbcTemplate;
    @Autowired @Qualifier("postgresJdbcTemplate")
    JdbcTemplate postgresJdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("Querying for users from mysql:");
        mysqlJdbcTemplate.query(
                "SELECT id, name, emailid, phoneno,location FROM usermaster", new Object[] {  },
                (rs, rowNum) -> new UserMaster(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("emailid"),
                        rs.getString("phoneno"),
                        rs.getString("location"))
        ).forEach(customer -> log.info(customer.toString()));

        log.info("Querying for users from postgresql:");
        postgresJdbcTemplate.query(
                "SELECT id, name, emailid, phoneno,location FROM usermaster", new Object[] {  },
                (rs, rowNum) -> new UserMaster(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("emailid"),
                        rs.getString("phoneno"),
                        rs.getString("location"))
        ).forEach(customer -> log.info(customer.toString()));
    }
}
