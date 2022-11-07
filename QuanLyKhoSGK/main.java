package QuanLyKhoSGK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    static List<NhapKho> listNK = new ArrayList<>();
    static List<NhanVien> listNV = new ArrayList<>();
    static List<NhaCungCap> listNCC = new ArrayList<>();
    static List<LoaiSach> listLS = new ArrayList<>();
    static List<SGK> listSGK = new ArrayList<>();
    static List<Kho> listK = new ArrayList<>();
    static List<XuatKho> listXK = new ArrayList<>();
    /*
     * =============================================================================
     * =============================================================================
     * =============================================================================
     * =============================================================================
     * =============================================================================
     * =============================================================================
     */

    public static void main(String[] args) {
        int luaChon = 0;
        do {
            System.out.println("\n========================Menu=========================");
            System.out.print("""
                    \t\t1: Hien thi.
                    \t\t2: Nhap kho.
                    \t\t3: Nhan vien.
                    \t\t4: Nha cung cap.
                    \t\t5: Loai sach.
                    \t\t6: SGK.
                    \t\t7: Kho.
                    \t\t8: Xuat kho.
                    \t\t9: Save to file.
                    \t\t10: Xoa noi dung da save.
                    \t\t11: Tim kiem.
                    \t\t12: Remove.
                    \t\t13: Sap xep tang dan.

                    """);
            System.out.print("Vui long chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            if (luaChon == 1) {
                for (NhanVien a : listNV) {
                    System.out.println(a.toString());
                }
                System.out.println("----------------------------------------------");
                for (NhapKho a : listNK) {
                    System.out.println(a.toString());
                }
                System.out.println("----------------------------------------------");
                for (NhaCungCap a : listNCC) {
                    System.out.println(a.toString());
                }
                System.out.println("----------------------------------------------");
                for (LoaiSach a : listLS) {
                    System.out.println(a.toString());
                }
                System.out.println("----------------------------------------------");
                for (SGK a : listSGK) {
                    System.out.println(a.toString());
                }
                System.out.println("----------------------------------------------");
                for (Kho a : listK) {
                    System.out.println(a.toString());
                }
                System.out.println("----------------------------------------------");
                for (XuatKho a : listXK) {
                    System.out.println(a.toString());
                }
            } else if (luaChon == 2) {
                NhapKho nk = new NhapKho();
                System.out.println("----------------------------------------------");
                nk.nhapKho();
                listNK.add(nk);
                for (NhapKho a : listNK) {
                    System.out.println(a.toString());
                }
            } else if (luaChon == 3) {
                NhanVien nv = new NhanVien();
                System.out.println("-----------------------");
                nv.nhapNV();
                listNV.add(nv);
                for (NhanVien a : listNV) {
                    System.out.println(a.toString());
                }
            } else if (luaChon == 4) {
                NhaCungCap ncc = new NhaCungCap();
                System.out.println("-----------------------");
                ncc.nhapncc();
                listNCC.add(ncc);
                for (NhaCungCap a : listNCC) {
                    System.out.println(a.toString());
                }
            } else if (luaChon == 5) {
                LoaiSach ls = new LoaiSach();
                System.out.println("-----------------------");
                ls.nhapLs();
                listLS.add(ls);
                for (LoaiSach a : listLS) {
                    System.out.println(a.toString());
                }
            } else if (luaChon == 6) {
                SGK sgk = new SGK();
                System.out.println("-----------------------");
                sgk.nhapsgk();
                listSGK.add(sgk);
                for (SGK a : listSGK) {
                    System.out.println(a.toString());
                }
            } else if (luaChon == 7) {
                Kho k = new Kho();
                System.out.println("-----------------------");
                k.nhapk();
                listK.add(k);
                for (Kho a : listK) {
                    System.out.println(a.toString());
                }
            } else if (luaChon == 8) {
                {
                    XuatKho xk = new XuatKho();
                    System.out.println("-----------------------");
                    xk.nhapxk();
                    listXK.add(xk);
                    for (XuatKho a : listXK) {
                        System.out.println(a.toString());
                    }
                }
            } else if (luaChon == 9) {
                NhapKho nk = new NhapKho();
                NhanVien nv = new NhanVien();
                NhaCungCap ncc = new NhaCungCap();
                LoaiSach ls = new LoaiSach();
                SGK sgk = new SGK();
                Kho k = new Kho();
                XuatKho xk = new XuatKho();
                nk.WriterToFile(listNK);
                nv.WriterToFile(listNV);
                ls.WriterToFile(listLS);
                sgk.WriterToFile(listSGK);
                k.WriterToFile(listK);
                xk.WriterToFile(listXK);
                ncc.WriterToFile(listNCC);

            } else if (luaChon == 10) {
                try {
                    FileWriter fw = new FileWriter("C:\\lap trinh jv\\File\\text\\QLSGK.txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.close();
                } catch (Exception e) {
                }
            } else if (luaChon == 11) {

                int x = 0;
                System.out.println("  | Nhap de tim kiem theo danh sach |  ");
                System.out.print("""
                        1. Tim SGK theo ma
                        2. Tim NCC theo ma
                        --------------------
                        Moi ban nhap:
                        """);
                x = sc.nextInt();
                sc.nextLine();
                if (x == 1) {
                    System.out.print("Nhap Ma SGK can tim: ");
                    String n = sc.nextLine();
                    for (SGK a : listSGK) {
                        if (a.getMaSGK().indexOf(n) >= 0) {
                            System.out.print(a);
                        }
                    }
                }
                if (x == 2) {
                    System.out.print("Nhap ma NCC can tim: ");
                    String n = sc.nextLine();
                    for (NhaCungCap a : listNCC) {
                        if (a.getMaNCC().indexOf(n) >= 0) {
                            System.out.print(a);
                        }
                    }
                }

            } else if (luaChon == 12) {
                int x = 0;
                System.out.println("Nhap de xoa theo danh sach");
                System.out.print("""
                        1. Xoa SGK theo ten ma:
                        2. Xoa Kho theo ma
                        3. Xoa nhan vien
                        4. Xoa phieu nhap kho
                        --------------------
                        Moi ban nhap:
                        """);
                x = sc.nextInt();
                sc.nextLine();
                if (x == 1) {
                    System.out.print("Nhap Ma SGK can xoa: ");
                    String n = sc.nextLine();
                    for (SGK a : listSGK) {
                        // int n==a.getLop()
                        if (a.getMaSGK().indexOf(n) >= 0) {
                            listSGK.remove(a);
                            System.out.print("Xoa thanh cong");
                        }
                    }
                }
                if (x == 2) {
                    System.out.print("Nhap Ma kho can xoa: ");
                    String n = sc.nextLine();
                    for (Kho a : listK) {
                        if (a.getMaKho().indexOf(n) >= 0) {
                            listK.remove(a);
                            System.out.print("Xoa thanh cong");
                        }
                    }
                }
                if (x == 3) {
                    System.out.print("Nhap nhan vien kho can xoa: ");
                    String n = sc.nextLine();
                    for (NhanVien a : listNV) {
                        if (a.getMaNV().indexOf(n) >= 0) {
                            listNV.remove(a);
                            System.out.print("Xoa thanh cong");
                        }
                    }
                }
                if (x == 4) {
                    System.out.print("Nhap phieu nhap kho can xoa: ");
                    String n = sc.nextLine();
                    for (NhapKho a : listNK) {
                        if (a.getPhieuNhap().indexOf(n) >= 0) {
                            listNK.remove(a);
                            System.out.print("Xoa thanh cong");
                        }
                    }
                }

            } else if (luaChon == 13) {
                int x = 0;
                System.out.print("""
                        Nhap de xap xep theo danh sach:
                        1. Xap xep SGK theo lop
                        """);
                x = sc.nextInt();
                sc.nextLine();
                if (x == 1)// xap xep theo kieu int
                {
                    Collections.sort(listSGK, new Comparator<SGK>() {
                        public int compare(SGK o1, SGK o2) {
                            if (o1.getLop() > o2.getLop()) {
                                return 1;
                            } else if (o1.getLop() < o2.getLop()) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    });
                    for (SGK a : listSGK) {
                        System.out.println(a.toString());
                    }
                }
                if (x == 2) // xap xep theo chuoi ky tu su dung implements Comparable
                {
                    Collections.sort(listNCC);
                    for (NhaCungCap a : listNCC) {
                        System.out.println(a.toString());
                    }
                }
            }
        } while (luaChon != 0);
    }
}
