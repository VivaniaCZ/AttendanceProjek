package com.rplsnapan.e_attendance.models;

public class User {
    private String id, username, name, kelas, nis, dibuat, update;

    public User(String id, String username, String name, String kelas, String nis, String dibuat, String update) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.kelas = kelas;
        this.nis = nis;
        this.dibuat = dibuat;
        this.update = update;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getKelas() {
        return kelas;
    }

    public String getNis() {
        return nis;
    }

    public String getDibuat() {
        return dibuat;
    }

    public String getUpdate() {
        return update;
    }
}
