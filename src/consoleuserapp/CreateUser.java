package consoleuserapp;

import java.util.Arrays;

public class CreateUser {
    
    private String first_name;
    private String last_name;
    private String email;
    private String[] role;
    private long[] mob_tel;
    
    public CreateUser(String first_name, String last_name, String email, String[] role, long[] mob_tel){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.role = role;
        this.mob_tel = mob_tel;
    }
    
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }
    
    public String getFirstName(){
        return first_name;
    }
    
    public void setLastName(String last_name){
        this.last_name = last_name;
    }
    
    public String getLastName(){
        return last_name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setRole(String[] role){
        this.role = role;
    }
    
    public String[] getRole(){
        return role;
    }
    
    public void setMobTel(long[] mob_tel){
        this.mob_tel = mob_tel;
    }
    
    public long[] getMobTel(){
        return mob_tel;
    }
    
    public String userInfo(){
        String info = "Имя - " + this.first_name + " | Фамилия - " + this.last_name + " | Почта - " + 
                this.email + " | Роль - " + Arrays.toString(this.role) + " | Ном. тел. - " + Arrays.toString(this.mob_tel);
        return info;
    }
    
}
