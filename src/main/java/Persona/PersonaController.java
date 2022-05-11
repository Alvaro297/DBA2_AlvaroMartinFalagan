package Persona;

import Persona.PersonaClass.Persona;
import Persona.dto.PersonaInputDTO;
import Persona.dto.PersonaOutputDTO;
import Persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("mongo")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/addperson")
    public String addPerson(@RequestBody PersonaInputDTO personaInputDTO) throws Exception{
        Persona person = new Persona(personaInputDTO);
        personaRepository.savePersona(person);
        return "Persona creada correctamente";
    }

    @GetMapping("/getall")
    public ResponseEntity getPeople() throws Exception{

        return ResponseEntity.ok(personaRepository.getAll());

    }

    @GetMapping("/get/{id}")
    public ResponseEntity getPersonById(@PathVariable String id) throws Exception{
        Persona p = personaRepository.findOneById(id);
        PersonaOutputDTO person = new PersonaOutputDTO(p);
        return ResponseEntity.ok().body(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonById(@PathVariable String id, @RequestBody PersonaInputDTO personaInputDTO){
        Persona p = new Persona(personaInputDTO);
        personaRepository.updatePersona(p,id);
        return ResponseEntity.ok().body("Actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        personaRepository.deleteById(id);
        return ResponseEntity.ok().body("Eliminado correctamente");
    }

}