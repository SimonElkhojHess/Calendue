package dk.kea.calendue.repository;

import dk.kea.calendue.model.User;
import dk.kea.calendue.utility.DateCalculator;
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
    {}

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

   @Test
    void testCheckLoginWithInvalidCredentials()
    {
        //arrange
        String username = "user";
        String password = "WrongPassword";

        //act
        boolean result = userRepository.checkLogin(username, password);

        //assert
        assertEquals(false, result);
    }

    //Tests calculation tool
    @Test
    void testDateDifferenceCalculator() {
        //arrange
        String date1 = "16/05/2023";
        String date2 = "31/05/2023";

        //act
        int result = DateCalculator.returnDateDifference(date1, date2);

        //assert
        assertEquals(15, result);
    }

    //Tests exception handling of DateTimeParseException
    //Should catch, and return 0.
    @Test
    void testDateCalculatorErrorHandling()
    {
        //arrange
        String date1 = "16-05-2023";
        String date2 = "31-05-2023";

        //act
        int result = DateCalculator.returnDateDifference(date1, date2);

        //assert
        assertEquals(0, result);
    }
}