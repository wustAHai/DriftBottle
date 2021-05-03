package com.hai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by chenz at 14:47 on 2021/5/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    private Long id;
    private Long bottleId;
    private Long replyId;
    private Long fromId;
    private Long toId;
    private String msg;
    private int status;
    private Date time;
}
