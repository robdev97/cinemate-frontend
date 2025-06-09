    package com.cinemate.frontend.client;


    import com.cinemate.frontend.domain.UserDto;
    import org.springframework.stereotype.Component;

    import java.util.ArrayList;
    import java.util.List;

    @Component
    public class UserClient {

        public List<UserDto> fetchUsers() {
            List<UserDto> users = new ArrayList<>();

            users.add(new UserDto(1L, "robert", "Pass1", "robert@example.com", "Robert Lit"));
            users.add(new UserDto(2L, "Anita", "Pass2", "anita@example.com", "Anita Ani"));
            users.add(new UserDto(3L, "Kacpet", "Pass3", "kacper@example.com", "Kacper Kapo"));

            return users;
        }
    }
