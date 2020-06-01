package sw2.lab5.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;
    @Column(nullable = false)
    private String role_name;




    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
