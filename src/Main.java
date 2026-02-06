import service.ContactService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactService service = new ContactService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----- ");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    service.show();
                    break;
                case 2:
                    service.add();
                    break;
                case 3:
                    service.update();
                    break;
                case 4:
                    service.delete();
                    break;
                case 5:
                    service.search();
                    break;
                case 6:
                    service.readCSV();
                    service.show();
                    break;
                case 7:
                    service.saveCSV();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
}