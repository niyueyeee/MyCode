package com.itheima.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author NiYueYeee
 * @create 2019-06-08 20:54
 */
@Data
@NoArgsConstructor
@ToString
public class Article {
    private Integer id;
    private String title;
    private String content;
}
