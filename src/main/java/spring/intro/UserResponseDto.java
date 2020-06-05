package spring.intro;

import spring.intro.model.User;

public class UserResponseDto {
    private String name;
    private String email;

    public UserResponseDto(User user) {
        this.email = user.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
