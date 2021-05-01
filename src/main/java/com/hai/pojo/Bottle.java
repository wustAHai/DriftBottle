package com.hai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by chenz at 12:57 on 2021/4/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bottle {
    private Long id;
    private Long sendId;
    private Long getId;
    private int status;
    private String msg;
    private Date time;
}
