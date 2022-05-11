package Persona.PersonaClass;

import Persona.dto.PersonaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Date;

@Document(collection = "person")

@Data
@NoArgsConstructor
public class Persona {

    @Id
    @MongoId
    private String personId;

    private String user;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date createDate;
    private String imagenUrl;
    private Date terminationDate;

    public Persona(PersonaInputDTO personaInputDTO) {
        setPersonId(personaInputDTO.getPersonId());
        setActive(personaInputDTO.getActive());
        setCity(personaInputDTO.getCity());
        setCompanyEmail(personaInputDTO.getCompanyEmail());
        setImagenUrl(personaInputDTO.getImagenUrl());
        setName(personaInputDTO.getName());
        setSurname(personaInputDTO.getSurname());
        setPassword(personaInputDTO.getPassword());
        setPersonalEmail(personaInputDTO.getPersonalEmail());
        setUser(personaInputDTO.getUser());
        setTerminationDate((Date) personaInputDTO.getTerminationDate());
    }

}