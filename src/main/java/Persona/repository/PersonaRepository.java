package Persona.repository;

import Persona.PersonaClass.Persona;

import java.util.List;

public interface PersonaRepository {
    Persona savePersona(Persona persona);
    List<Persona> getAll();
    Persona findOneById(String id);

    void deleteById(String id);

    void updatePersona(Persona persona, String id);
}
