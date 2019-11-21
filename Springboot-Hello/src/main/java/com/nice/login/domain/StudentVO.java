package com.nice.login.domain;

import lombok.Data;

import java.util.Date;
@Data
public class StudentVO {
    private String name;
    private String grade;
    private Date firstDate;
    private Date lastDate;
}
