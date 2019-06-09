package com.itheima.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author NiYueYeee
 * @create 2019-06-08 21:31
 */
@Data
@ToString
@NoArgsConstructor
@Document(indexName = "blog5",type = "article")
public class Article {
    @Id
    @Field(index = true,store = true)
    private Integer id;
    @Field(index = true,store = true,analyzer = "ik_smart",searchAnalyzer ="ik_smart" ,type = FieldType.text)
    private String title;
    @Field(index = true,store = true,analyzer = "ik_smart",searchAnalyzer ="ik_smart" ,type = FieldType.text)
    private String content;
}
