package api.data;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String login;
    private String name;
    private String phone;
    private Role role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStringRole() {

        if (this.role == Role.USER) {
            return "Пользователь";
        } else {
            return "Администратор";
        }
    }
}
