package com.tekbbes.viajes.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekbbes.viajes.model.Travel;
import com.tekbbes.viajes.service.ITravelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "/**" })
public class TravelRestController {

	@Autowired
	private ITravelService travelService;

	@GetMapping("/travel")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(travelService.findAll());
	}

	@GetMapping("/travel/page/{page}")
	public Page<Travel> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return travelService.findAll(pageable);
	}

	@GetMapping("/travel-count")
	public ResponseEntity<?> findCount() {
		Map<String, Object> response = new HashMap<>();
		Long conteo = travelService.count();
		response.put("total travel = ", conteo);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/travel-count-city/{id}")
	public ResponseEntity<?> findCountCity(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Long conteo = travelService.countCity(id);
		if (conteo == 0) {
			response.put("message", "the city with id: ".concat(id.toString().concat(" no assigned travel")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("total trips by city ", conteo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/travel-count-country/{id}")
	public ResponseEntity<?> findCountCountry(@PathVariable Long id) {
		Long conteo = travelService.countCountry(id);
		Map<String, Object> response = new HashMap<>();
		if (conteo == 0) {
			response.put("message", "the country with id: ".concat(id.toString().concat(" no assigned travel")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		response.put("total trips by country ", conteo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/travel")
	public ResponseEntity<?> save(@Valid @RequestBody Travel travel, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Travel travelNew = null;
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "The field '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());

			response.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			travel.setCreatedAt(new Date());
			travelNew = travelService.save(travel);
		} catch (DataAccessException e) {
			response.put("message", "Error when inserting into the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", "The trip has been successfully created");
		response.put("travel ", travelNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/travel/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Travel travel, BindingResult result, @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		Travel travelCurrent = travelService.findByid(id);
		Travel travelUpdate = null;

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "The field '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());

			response.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (travelCurrent == null) {
			response.put("message", "Error: could not edit, the trip ID: "
					.concat(id.toString().concat("does not exist in the database")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			travelCurrent.setStartDate(travel.getStartDate());
			travelCurrent.setStrartPickupAddres(travel.getStrartPickupAddres());
			travelCurrent.setEndDate(travel.getEndDate());
			travelCurrent.setEndPickupAddres(travel.getEndPickupAddres());
			travelCurrent.setCountry(travel.getCountry());
			travelCurrent.setCity(travel.getCity());
			travelCurrent.setPassenger(travel.getPassenger());
			travelCurrent.setDriver(travel.getDriver());
			travelCurrent.setStatus(travel.getStatus());
			travelCurrent.setCheckCode(travel.getCheckCode());
			travelCurrent.setPrice(travel.getPrice());
			travelCurrent.setDriverLocation(travel.getDriverLocation());
			travelCurrent.setUpdatedAt(new Date());
			travelUpdate = travelService.save(travelCurrent);
		} catch (DataAccessException e) {
			response.put("message", "Error when updating the trip in the database");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", "The trip has been successfully updated");
		response.put("travel", travelUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
