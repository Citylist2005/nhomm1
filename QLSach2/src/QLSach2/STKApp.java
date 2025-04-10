package QLSach2;

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

class STK extends Book {
    private float thue;

    public void input(Scanner sc) {
        super.input(sc);
        System.out.print("Nhập thuế: ");
        thue = sc.nextFloat();
    }

    public void output() {
        super.output();
        System.out.println("Thuế: " + thue);
        System.out.println("Thành tiền: " + thanhTien());
    }

    public float thanhTien() {
        return soLuong * donGia + thue;
    }
}

public class STKApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng STK: ");
        int n = sc.nextInt();
        STK[] ds = new STK[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin STK thứ " + (i + 1));
            ds[i] = new STK();
            ds[i].input(sc);
        }

        System.out.println("===== DANH SÁCH STK =====");
        for (int i = 0; i < n; i++) {
            System.out.println("STK thứ " + (i + 1));
            ds[i].output();
        }

        sc.close();
    }
}

