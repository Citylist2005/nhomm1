package QLSach;

import java.util.Scanner;

class Book {
    protected String maSach;
    protected float donGia;
    protected float soLuong;
    protected String nhaXB;

    public void input(Scanner sc) {
        sc.nextLine(); // Clear buffer
        System.out.print("Nhập mã sách: ");
        maSach = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        donGia = sc.nextFloat();
        System.out.print("Nhập số lượng: ");
        soLuong = sc.nextFloat();
        sc.nextLine();
        System.out.print("Nhập nhà xuất bản: ");
        nhaXB = sc.nextLine();
    }

    public void output() {
        System.out.println("Mã sách: " + maSach);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Nhà xuất bản: " + nhaXB);
    }
}

class SGK extends Book {
    private String tinhTrang;

    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhập tình trạng sách (new/old): ");
        tinhTrang = sc.nextLine();
    }

    public void output() {
        super.output();
        System.out.println("Tình trạng: " + tinhTrang);
        System.out.println("Thành tiền: " + thanhTien());
    }

    public float thanhTien() {
        if (tinhTrang.equalsIgnoreCase("new")) {
            return soLuong * donGia;
        } else if (tinhTrang.equalsIgnoreCase("old")) {
            return soLuong * donGia * 0.5f;
        }
        return 0;
    }
}

public class SGKApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng SGK: ");
        int n = sc.nextInt();
        SGK[] ds = new SGK[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin SGK thứ " + (i + 1));
            ds[i] = new SGK();
            ds[i].input(sc);
        }

        System.out.println("===== DANH SÁCH SGK =====");
        for (int i = 0; i < n; i++) {
            System.out.println("SGK thứ " + (i + 1));
            ds[i].output();
        }

        sc.close();
    }
}
