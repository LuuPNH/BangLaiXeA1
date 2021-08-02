package com.example.finaldoan.Models;

public class Question {
    private int ID;
    private String cau_hoi,
            phan_loai,
            so_cau_tra_loi,
            cau_A,
            cau_B,
            cau_C,
            cau_D,
            dap_an_1,
            dap_an_2;
    private int image;

    public Question() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCau_hoi() {
        return cau_hoi;
    }

    public void setCau_hoi(String cau_hoi) {
        this.cau_hoi = cau_hoi;
    }

    public String getPhan_loai() {
        return phan_loai;
    }

    public void setPhan_loai(String phan_loai) {
        this.phan_loai = phan_loai;
    }

    public String getSo_cau_tra_loi() {
        return so_cau_tra_loi;
    }

    public void setSo_cau_tra_loi(String so_cau_tra_loi) {
        this.so_cau_tra_loi = so_cau_tra_loi;
    }

    public String getCau_A() { return cau_A; }

    public void setCau_A(String cau_A) {
        this.cau_A = cau_A;
    }

    public String getCau_B() { return cau_B; }

    public void setCau_B(String cau_B) {
        this.cau_B = cau_B;
    }

    public String getCau_C() { return cau_C; }

    public void setCau_C(String cau_C) { this.cau_C = cau_C; }

    public String getCau_D() { return cau_D; }

    public void setCau_D(String cau_D) { this.cau_D = cau_D; }

    public String getDap_an_1() { return dap_an_1; }

    public void setDap_an_1(String dap_an_1) { this.dap_an_1 = dap_an_1; }

    public String getDap_an_2() { return dap_an_2; }

    public void setDap_an_2(String dap_an_2) { this.dap_an_2 = dap_an_2; }

    public int getImage() { return image; }

    public void setImage(int image) { this.image = image; }

    public Question(int ID, String cau_hoi, String phan_loai, String so_cau_tra_loi, String cau_A, String cau_B, String cau_C, String cau_D, String dap_an_1, String dap_an_2) {
        this.ID = ID;
        this.cau_hoi = cau_hoi;
        this.phan_loai = phan_loai;
        this.so_cau_tra_loi = so_cau_tra_loi;
        this.cau_A = cau_A;
        this.cau_B = cau_B;
        this.cau_C = cau_C;
        this.cau_D = cau_D;
        this.dap_an_1 = dap_an_1;
        this.dap_an_2 = dap_an_2;
        this.image = 0;
    }

    public Question(int ID, String cau_hoi, String phan_loai, String so_cau_tra_loi, String cau_A, String cau_B, String cau_C, String cau_D, String dap_an_1, String dap_an_2, int image) {
        this.ID = ID;
        this.cau_hoi = cau_hoi;
        this.phan_loai = phan_loai;
        this.so_cau_tra_loi = so_cau_tra_loi;
        this.cau_A = cau_A;
        this.cau_B = cau_B;
        this.cau_C = cau_C;
        this.cau_D = cau_D;
        this.dap_an_1 = dap_an_1;
        this.dap_an_2 = dap_an_2;
        this.image = image;
    }
}
