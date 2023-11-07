package com.hostal.hostal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login-logs")
public class LoginLogController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<Map<String, Object>> getSelectedFields() {
        String sql = "SELECT username, login_time FROM login_log";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }
}
