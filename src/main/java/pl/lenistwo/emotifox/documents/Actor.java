package pl.lenistwo.emotifox.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Collection0")
public class Person {
    @Id
    private String id;
    private String name;
    private String surname;
    private Address address;
    private PersonalData personalData;
}
