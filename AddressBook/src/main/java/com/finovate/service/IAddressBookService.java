package com.finovate.service;

import java.util.List;

import com.finovat.model.AddressBookData;
import com.finovate.dto.AddressBookDTO;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookById(int contId);

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO);

	void deleteAddressBookData(int contId);

}