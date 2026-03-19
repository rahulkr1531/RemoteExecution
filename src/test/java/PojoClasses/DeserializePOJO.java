package PojoClasses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeserializePOJO {
    private int id;
    private String title;
    private String body;
    private int userId;
}