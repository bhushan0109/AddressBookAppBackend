package com.finovate.controller;

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
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	//curl localhost:8080/addressbook/get -w "\n"
	@GetMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("bhushan", "patil"));
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	//curl localhost:8080/addressbook/get/1 -w "\n"
	@GetMapping("/get/{bookId}")
	public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("bookId") int bookId) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("bhushan", "patil"));
		ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}
	
	//curl -X POST -H "Content-Type: application/json" -d '{"firstName": "Lisa","lastName":"patil"}' "http://localhost:8080/addressbook/create" -w "\n"
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Address Book Contact Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	//curl -X PUT -H "Content-Type: application/json" -d '{"firstName": "BHUSHAN","lastName":"RAHI"}' "http://localhost:8080/addressbook/update" -w "\n"

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Address Book Contact Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	//curl -X DELETE -H "Content-Type: application/json" localhost:8080/addressbook/delete/1 -w "\n"
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("bookId") int bookId) {
		ResponseDTO respDTO = new ResponseDTO("Deleted Address Book Contact Successfully", "Deleted Id: " + bookId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}