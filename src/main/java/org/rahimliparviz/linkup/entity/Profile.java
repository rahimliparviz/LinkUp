package org.rahimliparviz.linkup.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "profiles")
public class Profile {
    @Id
    private Long id;
    private String bornCountry;
    private String bornCity;
    private Date birthDate;
}
