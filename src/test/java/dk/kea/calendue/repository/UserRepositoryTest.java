package dk.kea.calendue.repository;

import dk.kea.calendue.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @BeforeAll
    void setUp()
    {
    }

    @BeforeEach
    void setUpEach()
    {}

    @Test
    void testCheckLoginWithValidCredentials() {

        //arrange
        String username = "user";
        String password = "user";

        //act
        boolean result = userRepository.checkLogin(username, password);

        //assert
        assertEquals(true, result);
    }

    //void testCheckLoginWithInvalidCredentials() {}
}