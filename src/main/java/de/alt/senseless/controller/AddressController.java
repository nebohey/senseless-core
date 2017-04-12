package de.alt.senseless.controller;


import de.alt.senseless.model.entities.Address;
import de.alt.senseless.model.repos.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/address/{name}")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    Address readAddress(@PathVariable String name) {
        return this.addressRepository.findByName(name);
    }


    @RequestMapping(method = RequestMethod.POST)
    Address writeAddress(@PathVariable String name, @RequestParam String ip) {

        Address address = addressRepository.findByName(name);

        if (address != null) {
            address.setLastUpdate(new Date());
            address.setIp(ip);
        } else {
            address = new Address(name, ip);
        }

        return addressRepository.save(address);
    }

}
