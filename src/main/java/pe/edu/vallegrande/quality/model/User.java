package pe.edu.vallegrande.quality.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public String id;

    private String name;

    private String email;

    private Integer age;
}
