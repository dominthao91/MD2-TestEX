package strorage;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFilePhoneBook {
    private static ReadWriteFilePhoneBook readWriteFilePhoneBook;

    public ReadWriteFilePhoneBook() {
    }
    public void writeList(List<PhoneBook> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("list.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<PhoneBook> readList() {
        List<PhoneBook> billList = new ArrayList<>();
        File file = new File("list.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            billList = (List<PhoneBook>) ois.readObject();
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return billList;
    }
}
