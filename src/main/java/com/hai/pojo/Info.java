package com.hai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenz at 11:21 on 2021/4/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    private Long id;
    private String nickname;
    private String location;
    private String description;
}
