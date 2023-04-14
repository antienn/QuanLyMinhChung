package QuanLyMinhChung.User;

public abstract class User {

    private static int count;
    private String id;
    private String name;
    private String pass;


    {
        this.id = String.format("User%05d",++count);
    }
    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
    public boolean isUser(String name, String pass) {
        return this.name.equals(name) && this.pass.equals(pass);
    }
    public void display(){
        System.out.printf("%-10s | %-20s | %-20s", this.id, this.name, this.getClass().getSimpleName());
    }



    public static User createUser(String name,String pass,String role){
        if(role.equals("GiangVien")){
            return new GiangVien(name,pass);
        }
        if(role.equals("TruongPhong")){
            return new TruongPhong(name,pass);
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
