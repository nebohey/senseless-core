package de.alt.senseless.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.alt.senseless.model.entities.Address;
import de.alt.senseless.model.repos.AddressRepository;

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

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteAddress(@PathVariable String name) {

		Address address = addressRepository.findByName(name);

		if (address != null) {
			addressRepository.delete(address.getId());
		}

	}

}
