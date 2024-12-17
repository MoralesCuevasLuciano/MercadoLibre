package models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AdminList<A extends Persona> {
    List<Admin> adminsList;
    public AdminList() {
        adminsList = new ArrayList<>();
    }

    public List<Admin> getAdminsList() {
        return adminsList;
    }
    public void setAdminsList(List<Admin> adminsList) {
        this.adminsList = adminsList;
    }
    public void addAdmin(Admin admin) {
        adminsList.add(admin);
    }
    public void removeAdmin(Admin admin) {
        adminsList.remove(admin);
    }

    public int size(){
        return adminsList.size();
    }

    public void show(){
        for (Admin admin : adminsList) {
            System.out.println(admin);
        }
    }
}
