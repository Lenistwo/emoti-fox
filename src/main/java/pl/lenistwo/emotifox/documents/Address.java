package pl.lenistwo.emotifox.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Address {
    private String city;
    private String street;
    private String zipCode;
}
