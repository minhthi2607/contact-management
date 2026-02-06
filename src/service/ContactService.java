package service;

import model.Contact;
import utils.FileUtils;
import utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {
    List<Contact> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String PATH = "data/contacts.csv";

    public void show() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if ((i + 1) % 5 == 0) {
                System.out.println("Enter để xem tiếp ");
                scanner.nextLine();
            }
        }
    }

    public void add() {
        System.out.print("Số điện thoại: ");
        String phone = scanner.nextLine();
        if (!ValidateUtils.isPhone(phone)) {
            System.out.println("Sai định dạng số điện thoại");
            return;
        }

        System.out.print("Nhóm: ");
        String group = scanner.nextLine();

        System.out.print("Họ tên: ");
        String name = scanner.nextLine();

        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Ngày sinh: ");
        String birthday = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (!ValidateUtils.isEmail(email)) {
            System.out.println("Sai email");
            return;
        }

        list.add(new Contact(phone, group, name, gender, address, birthday, email));
        System.out.println("Thêm thành công");
    }

    public Contact find(String phone) {
        for (Contact c : list) {
            if (c.getPhone().equals(phone)) return c;
        }
        return null;
    }

    public void update() {
        System.out.print("Nhập số điện thoại : ");
        String phone = scanner.nextLine();
        Contact c = find(phone);
        if (c == null) {
            System.out.println("Không tìm thấy");
            return;
        }
        System.out.print("Nhóm: ");
        c.setGroup(scanner.nextLine());

        System.out.print("Tên: ");
        c.setName(scanner.nextLine());

        System.out.print("Giới tính: ");
        c.setGender(scanner.nextLine());

        System.out.print("Địa chỉ: ");
        c.setAddress(scanner.nextLine());

        System.out.print("Ngày sinh: ");
        c.setBirthday(scanner.nextLine());

        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (ValidateUtils.isEmail(email)) c.setEmail(email);

        System.out.println("Cập nhật xong");
    }

    public void delete() {
        System.out.print("Nhập số điện thoại : ");
        String phone = scanner.nextLine();
        Contact c = find(phone);
        if (c == null) {
            System.out.println("Không tìm thấy");
            return;
        }
        System.out.print("Nhấn Y để xoá: ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            list.remove(c);
        }
    }

    public void search() {
        System.out.print("Nhập từ khoá: ");
        String key = scanner.nextLine();
        for (Contact c : list) {
            if (c.toString().contains(key)) {
                System.out.println(c);
            }
        }
    }

    public void readCSV() {
        list.clear();
        List<String> lines = FileUtils.readFile(PATH);

        for (String line : lines) {
            Contact c = Contact.fromCSV(line);
            list.add(c);
        }

    }


    public void saveCSV() {

        List<String> data = new ArrayList<>();
        for (Contact c : list) {
            String line = c.toCSV();

            data.add(line);
        }
        FileUtils.writeFile(PATH, data);
    }


}
