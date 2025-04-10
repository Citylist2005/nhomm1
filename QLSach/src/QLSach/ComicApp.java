package QLSach;

import java.util.Scanner;

class Book {
    protected String maSach;
    protected float donGia;
    protected float soLuong;
    protected String nhaXB;

    public void input(Scanner sc) {
        sc.nextLine();
        System.out.print("Nhập mã sách: ");
        maSach = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        donGia = sc.nextFloat();
        System.out.print("Nhập số lượng: ");
        soLuong = sc.nextFloat();
        sc.nextLine();
        System.out.print("Nhập nhà xuất bản:  ");
        nhaXB = sc.nextLine();
    }

    public void output() {
        System.out.println("Mã sách : " + maSach);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Nhà xuất bản: " + nhaXB);
    }
}

class Comic extends Book {
    private String theLoai;

    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhập thể loại: ");
        theLoai = sc.nextLine();
    }

    public void output() {
        super.output();
        System.out.println("Thể loại: " + theLoai);
        System.out.println("Thành tiền: " + thanhTien());
    }

    public float thanhTien() {
        return donGia * soLuong;
    }
}

public class ComicApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sách truyện: ");
        int n = sc.nextInt();
        Comic[] ds = new Comic[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách truyện thứ " + (i + 1));
            ds[i] = new Comic();
            ds[i].input(sc);
        }

        System.out.println("===== DANH SÁCH SÁCH TRUYỆN =====");
        for (int i = 0; i < n; i++) {
            System.out.println("Sách truyện thứ " + (i + 1));
            ds[i].output();
        }

        sc.close();
    }
}