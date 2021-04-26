package com.hai.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenz at 10:12 on 2021/4/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int code;
    private Object data;
    private String msg;
}
