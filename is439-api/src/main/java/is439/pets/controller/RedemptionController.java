package is439.pets.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import is439.pets.model.Redemption;
import is439.pets.repositories.RedemptionRepository;

@CrossOrigin(origins = "*", maxAge= 3600)
@RestController
@RequestMapping("/") // any request to the host starting with pets will redirect here
public class RedemptionController {
    @Autowired // creates an instance
    private RedemptionRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Redemption> getAllPets() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Redemption getPetById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody  Redemption redemption) {
        redemption.set_id(id);
        repository.save(redemption);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Redemption createPet(@Valid @RequestBody Redemption redemption) {
        redemption.set_id(ObjectId.get());
        repository.save(redemption);
        return redemption;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }

}