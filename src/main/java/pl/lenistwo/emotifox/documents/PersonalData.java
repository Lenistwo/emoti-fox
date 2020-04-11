package pl.lenistwo.emotifox.documents;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class PersonalData {
    private int age;
    private LocalDate bornYear;
    private String imgUrl;
}
