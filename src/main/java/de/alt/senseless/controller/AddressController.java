package de.alt.senseless.controller;


import de.alt.senseless.model.entities.Address;
import de.alt.senseless.model.repos.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address/{name}")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Address readBookmarks(@PathVariable String name) {
            return this.addressRepository.findByName(name);
    }


}
