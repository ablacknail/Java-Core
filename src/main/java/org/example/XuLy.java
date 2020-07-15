package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {
    static ArrayList<HocVien> dsHocVien = new ArrayList<HocVien>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            XuLy a = new XuLy();
            System.out.println("Vui long chon mot chuc nang:\n" +
                    "1. Hien thi tat ca cac hoc vien trong danh sach \n" +
                    "2. Them moi mot hoc vien trong danh sach\n" +
                    "3. Cap nhat thong tin cua mot hoc vien trong danh sach\n" +
                    "4. Xoa mot hoc vien ra khoi danh sach\n" +
                    "5. Thoat chuong trinh\n" +
                    "Vui long nhap 1 hoac 2 hoac 3 hoac 4 hoac 5 de thuc hien chuc nang");

            String inputFuntion = sc.nextLine();
            if (inputFuntion.equals("1")) {
                //Goi den ham hien thi hoc vien trong danh sach
                a.hienThiDanhSachHocVien();
            } else if (inputFuntion.equals("2")) {
                //Them moi mot hoc vien trong danh sach
                a.themMoiHocVien();
            } else if (inputFuntion.equals("3")) {
                //Cap nhat thong tin cua mot hoc vien trong danh sach
                a.capNhatHocVien();
            } else if (inputFuntion.equals("4")) {
                // Xoa mot hoc vien ra khoi danh sach
                a.xoaHocVien();
            } else if (inputFuntion.equals("5")) {
                System.exit(1);
            } else {
                System.out.println("Chuc nang khong hop le!!!");
            }

        }

    }

    private void hienThiDanhSachHocVien() {
        for (HocVien h : dsHocVien
        ) {
              System.out.println("\t" + h.getMaHocVien() + "\t\t|" + h.getTenHocVien() + "\t\t|" + h.getDiem());
//            System.out.format("%10s |" , h.getMaHocVien());
//
//            System.out.format("%10s |" , h.getTenHocVien());
//            System.out.format("%10f |" , h.getDiem()+"\n");

        }
    }

    public void themMoiHocVien() {
        App a = new App();
        while (true) {
            HocVien h = new HocVien();

            System.out.println("Vui long nhap ma hoc vien: ");
            h.setMaHocVien(sc.nextLine());
            System.out.println("Vui long nhap ten hoc vien: ");
            h.setTenHocVien(sc.nextLine());
            System.out.println("Vui long nhap diem hoc vien: ");
            h.setDiem(sc.nextFloat());
            sc.nextLine();

            dsHocVien.add(h);
            System.out.println("Ban co muon them mot hoc vien moi! Yes/No?");
            String continueFlag = sc.nextLine();
            if (continueFlag.equals("Yes")) {
                continue;
            } else if (continueFlag.equals("No")) {
                break;
            }
        }
    }

    public void capNhatHocVien() {
        System.out.println("Nhap ma hoc vien ban muon cap nhat:");
        String maHocVienNhapVao = sc.nextLine();
        int countHV = 0;
        for (int i = 0; i < dsHocVien.size(); i++) {
            if (dsHocVien.get(i).getMaHocVien().equals(maHocVienNhapVao)) {
                System.out.println("Nhap ten: "); dsHocVien.get(i).setTenHocVien(sc.nextLine());
                System.out.println("Nhap diem: "); dsHocVien.get(i).setDiem(sc.nextFloat());
                sc.nextLine();
                break;
            }else {
                countHV++;
            }
        }
        if (countHV == dsHocVien.size()){
            System.out.println("Ma hoc vien khong ton tai!");
        }
    }

    public void xoaHocVien() {
        System.out.println("Nhap ma hoc vien ban muon xoa:");
        String maHocVienNhapVao = sc.nextLine();
        int countHV = 0;
        for (int i = 0; i < dsHocVien.size(); i++) {
            if (dsHocVien.get(i).getMaHocVien().equals(maHocVienNhapVao)) {
                dsHocVien.remove(i);
                break;
            }else {
                countHV++;
            }
        }
        if (countHV == dsHocVien.size()){
            System.out.println("Ma hoc vien khong ton tai!");
        }
    }
}
//public void edit(int id) {
//        boolean isExisted = false;
//        int size = studentList.size();
//        for (int i = 0; i < size; i++) {
//            if (studentList.get(i).getId() == id) {
//                isExisted = true;
//                studentList.get(i).setName(inputName());
//                studentList.get(i).setAge(inputAge());
//                studentList.get(i).setAddress(inputAddress());
//                studentList.get(i).setGpa(inputGpa());
//                break;
//            }
//        }
//        if (!isExisted) {
//            System.out.printf("id = %d not existed.\n", id);
//        } else {
//            studentDao.write(studentList);
//        }
//    }