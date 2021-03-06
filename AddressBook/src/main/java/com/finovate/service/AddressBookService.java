package com.finovate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.finovat.model.AddressBookData;
import com.finovate.dto.AddressBookDTO;
import com.finovate.exception.AddressBookException;

@Service
public class AddressBookService implements IAddressBookService {

	private List<AddressBookData> addressBookList = new ArrayList<AddressBookData>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}

	@Override
	public AddressBookData getAddressBookById(int contId) {
		return addressBookList.stream().filter(bookData -> bookData.getAddressBookId() == contId).findFirst()
				.orElseThrow(() -> new AddressBookException("Addressbook entry Not found"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData bookData = null;
		bookData=new AddressBookData(addressBookList.size()+1,addressBookDTO);
		addressBookList.add(bookData);
		return bookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int contId, AddressBookDTO addressBookDTO) {
		AddressBookData bookData = this.getAddressBookById(contId);
		bookData.setFirstName(addressBookDTO.firstName);
		bookData.setLastName(addressBookDTO.lastName);
		addressBookList.set(contId - 1, bookData);
		return bookData;
	}

	@Override
	public void deleteAddressBookData(int contId) {
		addressBookList.remove(contId - 1);
	}

}