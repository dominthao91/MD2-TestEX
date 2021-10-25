package controller;

import model.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookManager implements IGenneralPhoneBook<PhoneBook> {
    private List<PhoneBook> phoneBookList = new ArrayList<>();

    public PhoneBookManager() {
    }

    public PhoneBookManager(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }

    public void setPhoneBookList(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    @Override
    public void showAll() {
        for (PhoneBook phone : phoneBookList
        ) {
            System.out.println(phone);
        }
    }

    @Override
    public void addNew(PhoneBook phoneBook) {
        phoneBookList.add(phoneBook);
    }

    @Override
    public void updateByPhoneNumbers(String phoneNumbers, PhoneBook phoneBook) {
        int index = searchByPhoneNumbers(phoneNumbers);
        if (index != -1) {
            phoneBookList.set(index, phoneBook);
        } else {
            System.out.println("Không tìm thấy SDT này >>.");
        }
    }

    @Override
    public void removeByPhoneNumbers(String phoneNumbers) {
        int index = searchByPhoneNumbers(phoneNumbers);
        if (index != -1) {
            phoneBookList.remove(index);
        } else {
            System.err.println("Không tìm thấy SDT này >>.");
        }
    }

    @Override
    public int searchByPhoneNumbers(String phoneNumbers) {
        int index = -1;
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getPhoneNumbers().equals(phoneNumbers)) {
                index = i;
            }
        }
        return index;
    }

    public PhoneBook findByIdentityToPhoneBook(String phoneNumber) {
        PhoneBook phoneBook = null;
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getPhoneNumbers().equals(phoneNumber)) {
                phoneBook = phoneBookList.get(i);
                break;
            }
        }
        return phoneBook;
    }
}
