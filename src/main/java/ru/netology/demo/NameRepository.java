package ru.netology.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;


import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class NameRepository {

    private static final String productByName = read("select_by_alexey.sql");


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public NameRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public  String getProductByName(String name) {
        SqlParameterSource param = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForObject(productByName, param,
                String.class);
//                (rs, rowNum) -> (rs.getString("product_name")));
    }


    public static String read(String scriptName) {
        try (InputStream is = new ClassPathResource(scriptName).getInputStream()) {
            return String.join("\n", readLines(is));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> readLines(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        return reader.lines().collect(Collectors.toList());
    }


}

//    public List<String> getProductName(String name){
//       return namedParameterJdbcTemplate.queryForList(productByName,
//        new MapSqlParameterSource("name", name), String.class);
//    }
