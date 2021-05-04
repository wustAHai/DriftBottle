package com.hai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenz at 19:01 on 2021/5/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Info info;
    private Bottle bottle;
    private Reply reply;
}
