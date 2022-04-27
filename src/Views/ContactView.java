package Views;

import Services.Service;
import model.Contacts;
import model.Validation;

import java.util.*;

public class ContactView {
    Scanner scanner = new Scanner(System.in);
    List<Contacts> contactsList = Service.contactsList;
    Service service = new Service();

    public void showAll() {
        System.out.println(service.findAll());
        new Views.Main();
    }

    public void addContact() {
        List<Contacts> contactsList = new ArrayList<Contacts>();
        String phoneNumber;
        while (true) {
            System.out.println("Nhap so dien thoai");
            phoneNumber = scanner.nextLine();
            if (Validation.isvalid(phoneNumber, Validation.phoneNumber)) {
                break;
            } else {
                System.err.println("sai dinh dang");
                addContact();
            }
        }
        System.out.println("Nhap nhom danh ba");
        String group = scanner.nextLine();
        System.out.println("Nhap ho ten");
        String name = scanner.nextLine();
        System.out.println("Nhap gioi tinh");
        String gender = scanner.nextLine();
        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();
        System.out.println("Nhap ngay sinh");
        String dateOfBirth = scanner.nextLine();
//        System.out.println("Nhap email");
//        String email = scanner.nextLine();
        String email;
        while (true) {
            System.out.println("Nhap email");
            email = scanner.nextLine();
            if (Validation.isvalid(email,Validation.email)){
                break;
            }else {
                System.err.println("sai dinh dang");
            }
        }
        Contacts newcontacts = new Contacts(phoneNumber, group, name, gender, address, dateOfBirth, email);
        service.add(newcontacts);
        new Views.Main();
    }

    public void editContactByphoneNumber() {
        String phoneNumber;
        while (true) {
            System.out.println("Nhap so dien thoai");
            phoneNumber = scanner.nextLine();
            if (Validation.isvalid(phoneNumber, Validation.phoneNumber)) {
                break;
            } else {
                System.out.println("Nhap lai hoac thoat");
                new Views.Main();
            }
        }
        if (!service.checkPhone(phoneNumber)) {
            System.out.println("So dien thoai khong chinh xac");
            new Views.Main();
        }
        System.out.println("Nhap nhom danh ba");
        String group = scanner.nextLine();
        System.out.println("Nhap ho ten");
        String name = scanner.nextLine();
        System.out.println("Nhap gioi tinh");
        String gender = scanner.nextLine();
        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();
        System.out.println("Nhap ngay sinh");
        String dateOfBirth = scanner.nextLine();
//        System.out.println("Nhap email");
//        String email = scanner.nextLine();
        String email;
        while (true) {
            System.out.println("Nhap email");
            email = scanner.nextLine();
            if (Validation.isvalid(email,Validation.email)){
                break;
            }
        }
        service.editContact(phoneNumber, group, name, gender, address, dateOfBirth, email);
        new Views.Main();
    }

    public void delete() {
        String phoneNumber;
        while (true) {
            System.out.println("Nhap so dien thoai");
            phoneNumber = scanner.nextLine();
            if (Validation.isvalid(phoneNumber, Validation.phoneNumber)) {
                break;
            }
        }
        if (!service.checkPhone(phoneNumber)) {
            System.out.println("So dien thoai khong chinh xac");
            new Views.Main();
        }
        service.deleteByPhoneNumber(phoneNumber);
        new Views.Main();
    }

    public void search() {
        System.out.println("1.Timn kiem theo so dien thoai" +
                "\n2. Tim kiem theo ten");
        System.out.println("Nhap lua chon");
        String choose = scanner.nextLine();
        switch (choose) {
            case "1":
                String phoneNumber;
                while (true) {
                    System.out.println("Nhap so dien thoai");
                    phoneNumber = scanner.nextLine();
                    if (Validation.isvalid(phoneNumber, Validation.phoneNumber)) {
                        break;
                    }
                }
                if (!service.checkPhone(phoneNumber)) {
                    System.out.println("So dien thoai khong chinh xac");
                    new Views.Main();
                }
                service.searchByphoneNumber(phoneNumber);
                new Views.Main();
                break;
            case "2":
                String name;
                while (true) {
                    System.out.println("Nhap ten");
                    name = scanner.nextLine();
                    service.searchByName(name);
                    new Views.Main();
                    break;
                }
        }
    }
}
