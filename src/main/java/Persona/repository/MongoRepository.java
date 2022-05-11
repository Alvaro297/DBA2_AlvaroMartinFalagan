package Persona.repository;

import Persona.PersonaClass.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoRepository implements PersonaRepository{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Persona savePersona(Persona persona){
        mongoTemplate.save(persona);
        return persona;
    }

    @Override
    public List<Persona> getAll(){
        return mongoTemplate.findAll(Persona.class);
    }

    @Override
    public Persona findOneById(String id) {
        return mongoTemplate.findById(id, Persona.class);
    }

    @Override
    public void deleteById(String id) {

        Persona personToRemove = mongoTemplate.findById(id, Persona.class);
        if(personToRemove != null){
            mongoTemplate.remove(personToRemove);
        }
    }

    @Override
    public void updatePersona(Persona person, String id) {
        Persona p = mongoTemplate.findById(id,Persona.class);

        p = person;

        mongoTemplate.save(p);

    }
}
