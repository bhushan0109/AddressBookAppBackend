package com.finovate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finovat.model.AddressBookData;
import com.finovate.dto.AddressBookDTO;
import com.finovate.dto.ResponseDTO;
import com.finovate.service.IAddressBookService;
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	//curl localhost:8080/addressbook/get -w "\n"
	@GetMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addressBookData = addressBookService.getAddressBookData();
		ResponseDTO responseDTO = new ResponseDTO("Successfull got the data", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	//curl localhost:8080/addressbook/get/1 -w "\n"
	@GetMapping("/get/{contId}")
	public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable("contId") int contId) {
		AddressBookData addressBookData = addressBookService.getAddressBookById(contId);
		ResponseDTO responseDTO = new ResponseDTO("Successfully got the data ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	//curl -X POST -H "Content-Type: application/json" -d '{"firstName": "Lisa","lastName":"patil"}' "http://localhost:8080/addressbook/create" -w "\n"
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Successfully created the data ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
     //curl -X PUT -H "Content-Type: application/json" -d '{"firstName": "BHUSHAN","lastName":"RAHI"}' "http://localhost:8080/addressbook/update" -w "\n"
	@PutMapping("/update/{contId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@Valid @PathVariable("contId") int contId,
			@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = addressBookService.updateAddressBookData(contId, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated address book of Id : ", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	// curl -X DELETE -H "Content-Type: application/json" localhost:8080/addressbook/delete/1 -w "\n"
	@DeleteMapping("/delete/{contId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contId") int contId) {
		addressBookService.deleteAddressBookData(contId);
		ResponseDTO responseDTO = new ResponseDTO("Deleted successfully the contact ", contId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}