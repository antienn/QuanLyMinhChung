package QuanLyMinhChung.admin;

import QuanLyMinhChung.User.User;

public class Admin {
    private String name;
    private String pass;

    public Admin(){
        this.name = "admin";
        this.pass = "999999";
    }
    public String isAdmin(String name , String pass){
        if(this.name.equals(name) && this.pass.equals(pass)){
            return this.getClass().getSimpleName();
        }
        return null;
    }

}
