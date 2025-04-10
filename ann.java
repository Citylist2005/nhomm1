package Tonghop;

import java.util.*;

class Book {
    protected String maSach;
    protected float donGia;
    protected float soLuong;
    protected String nhaXB;

    public Book() {}

    public Book(String maSach, float donGia, float soLuong, String nhaXB) {
        this.maSach = maSach;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXB = nhaXB;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
        System.out.print("Nhap don gia: ");
        this.donGia = sc.nextFloat();
        System.out.print("Nhap so luong: ");
        this.soLuong = sc.nextFloat();
        sc.nextLine(); // Consume newline
        System.out.print("Nhap Nha xuat ban: ");
        this.nhaXB = sc.nextLine();
    }

    public void output() {
        System.out.println("Ma sach: " + this.maSach);
        System.out.println("Don gia: " + this.donGia);
        System.out.println("So luong: " + this.soLuong);
        System.out.println("Nha xuat ban: " + this.nhaXB);
    }
}

class Comic extends Book {
    private String theLoai;

    public Comic() {}

    public Comic(String maSach, float donGia, float soLuong, String nhaXB, String theLoai) {
        super(maSach, donGia, soLuong, nhaXB);
        this.theLoai = theLoai;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap the loai cua sach: ");
        this.theLoai = sc.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("The loai cua sach: " + this.theLoai);
        System.out.println("Thanh tien: " + this.thanhTien());
    }

    public float thanhTien() {
        return this.soLuong * this.donGia;
    }
}

class SGK extends Book {
    private String tinhTrang;

    public SGK() {}

    public SGK(String maSach, float donGia, float soLuong, String nhaXB, String tinhTrang) {
        super(maSach, donGia, soLuong, nhaXB);
        this.tinhTrang = tinhTrang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tinh trang cua sach: ");
        this.tinhTrang = sc.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Tinh trang cua sach: " + this.tinhTrang);
        System.out.println("Thanh tien: " + this.thanhTien());
    }

    public float thanhTien() {
        if (this.tinhTrang.equals("new")) {
            return this.soLuong * this.donGia;
        } else if (this.tinhTrang.equals("old")) {
            return this.soLuong * this.donGia * 0.5f;
        } else {
            return 0;
        }
    }
}

class STK extends Book {
    private float thue;

    public STK() {}

    public STK(String maSach, float donGia, float soLuong, String nhaXB, float thue) {
        super(maSach, donGia, soLuong, nhaXB);
        this.thue = thue;
    }

    public float getThue() {
        return thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap thue: ");
        this.thue = sc.nextFloat();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Thue: " + this.thue);
        System.out.println("Thanh tien: " + this.thanhTien());
    }

    public float thanhTien() {
        return this.soLuong * this.donGia + this.thue;
    }
}

class BookManager {
    private ArrayList<SGK> dsSGK = new ArrayList<>();
    private ArrayList<STK> dsSTK = new ArrayList<>();
    private ArrayList<Comic> dsComic = new ArrayList<>();

    public void nhapDS() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===Lua chon loai sach===");
            System.out.println("1. Sach giao khoa");
            System.out.println("2. Sach tham khao");
            System.out.println("3. Sach truyen");
            System.out.println("0. Thoat");
            System.out.print("Nhap loai sach: ");
            int loaiSach = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (loaiSach == 1) {
                SGK sgk = new SGK();
                sgk.input();
                dsSGK.add(sgk);
            } else if (loaiSach == 2) {
                STK stk = new STK();
                stk.input();
                dsSTK.add(stk);
            } else if (loaiSach == 3) {
                Comic comic = new Comic();
                comic.input();
                dsComic.add(comic);
            } else if (loaiSach == 0) {
                break;
            } else {
                System.out.println("Lua chon khong dung!");
            }
        }
    }

    public void xuatDS() {
        int index = 1;
        for (SGK sgk : dsSGK) {
            System.out.println("==Thong tin sach thu " + index + ":");
            sgk.output();
            index++;
        }
        for (STK stk : dsSTK) {
            System.out.println("==Thong tin sach thu " + index + ":");
            stk.output();
            index++;
        }
        for (Comic comic : dsComic) {
            System.out.println("==Thong tin sach thu " + index + ":");
            comic.output();
            index++;
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===MENU===");
            System.out.println("1. Nhap DS");
            System.out.println("2. Xuat DS");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            int luaChon = sc.nextInt();
            if (luaChon == 1) {
                nhapDS();
            } else if (luaChon == 2) {
                xuatDS();
            } else if (luaChon == 0) {
                break;
            } else {
                System.out.println("Lua chon khong dung!");
            }
        }
    }
}

public class ann {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.menu();
    }
}
