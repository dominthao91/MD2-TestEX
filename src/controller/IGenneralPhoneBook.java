package controller;

public interface IGenneralPhoneBook <T>{
    void  showAll();
    void  addNew(T t);
    void updateByPhoneNumbers(String phoneNumbers,T t);
    void removeByPhoneNumbers(String phoneNumbers);
    int searchByPhoneNumbers(String phoneNumbers);
}
