package pl.lenistwo.emotifox.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Address {
    @Id
    private String id;
    private String city;
    private String street;
    private String zipCode;
}
