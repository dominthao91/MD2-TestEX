package view;

import controller.PhoneBookManager;
import model.PhoneBook;
import strorage.ReadWriteFilePhoneBook;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PhoneBookMenu {
    PhoneBookManager phoneBookManager = new PhoneBookManager();
    ReadWriteFilePhoneBook readWriteFilePhoneBook = new ReadWriteFilePhoneBook();

    public void runPhoneBook() {
        int choice = -1;
        do {
            System.out.println("Menu");
            System.out.println("1. Hiển thị danh sách ");
            System.out.println("2. Thêm mới danh sách");
            System.out.println("3. Cập nhật danh sách");
            System.out.println("4. Xóa danh sách");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc file");
            System.out.println("7. Ghi file");
            System.out.println("0. Quay lại");
            System.out.println("Nhập lựa chọn của bạn");
            Scanner scanner = new Scanner(System.in);
            choice =scanner.nextInt();
            switch (choice){
                case 1:{
                    showall();
                    break;
                }
                case 2:{
                    addNewPhoneBook();
                    break;
                }
                case 3:{
                  updatePhoneBook();
                    break;
                }
                case 4:{
                    deletePhoneNunbe();
                    break;
                }
                case 5:{
                    search();
                    break;
                }
                case 6:{
                    readFile();
                }
                case 7: {
                    writeFile();
                    break;
                }
                case 0:{
                    System.exit(0);
                }
            }

        } while (choice != 0);

    }

    private void readFile() {

        try{
            phoneBookManager.setPhoneBookList(readWriteFilePhoneBook.readList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFile() {
        System.out.println("7. Ghi file");
        try {
            readWriteFilePhoneBook.writeList(phoneBookManager.getPhoneBookList());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void search() {
        System.out.println("5. Tìm kiếm");
        System.out.println("Nhập SDT");
        Scanner scanner =new Scanner(System.in);
        String phoneNumber =scanner.nextLine();
        phoneBookManager.findByIdentityToPhoneBook(phoneNumber);
    }

    private void deletePhoneNunbe() {
        System.out.println("Xóa danh sách");
        System.out.println("Nhập SDT");
        Scanner scanner =new Scanner(System.in);
        String phoneNumber =scanner.nextLine();
        phoneBookManager.removeByPhoneNumbers(phoneNumber);
    }

    private void updatePhoneBook() {
        System.out.println("3. Cập nhật danh sách");
        System.out.println("Nhập SDT");
        Scanner scanner =new Scanner(System.in);
        String phoneNumber =scanner.nextLine();
        phoneBookManager.updateByPhoneNumbers(phoneNumber,inputPhoneBook());
    }

    private void addNewPhoneBook() {
        System.out.println("2. Thêm mới danh sách");
        phoneBookManager.addNew(inputPhoneBook());

    }

    private PhoneBook inputPhoneBook() {
        System.out.println("Thêm danh sách");
        System.out.println("Nhập sô điện thoại");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập nhóm");
        Scanner scanner1 = new Scanner(System.in);
        String group =scanner1.nextLine();
        System.out.println("Nhập họ và tên");
        Scanner scanner2 = new Scanner(System.in);
        String fullName =scanner2.nextLine();
        System.out.println("Nhập giới tính");
        Scanner scanner3 = new Scanner(System.in);
        String sex = scanner3.nextLine();
        System.out.println("Nhập địa chỉ");
        Scanner scanner4 = new Scanner(System.in);
        String address =scanner4.nextLine();
        System.out.println("Nhập ngày  tháng năm sinh");
        Scanner scanner5 = new Scanner(System.in);
        String dateOfBirth=scanner5.nextLine();
        System.out.println("Nhập email");
        Scanner scanner6 = new Scanner(System.in);
        String email = scanner6.nextLine();
        return new PhoneBook(phoneNumber,group,fullName,sex,address,dateOfBirth,email);
    }

    private void showall() {
        System.out.println("1. Hiển thị danh sách ");
        phoneBookManager.showAll();
    }
}
