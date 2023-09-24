package org.example.courseWork.security;

public class UserDto {
    private String username;
    private String password;
    private String roles;

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }

    public UserDto(String name, String password, String roles){
        this.setUsername(name);
        this.setPassword(password);
        this.setRoles(roles);
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRoles() {
        return roles;
    }
}
