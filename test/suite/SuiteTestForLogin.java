package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.TestFailedLoginWithWrongPassword;
import test.TestLoginShowsCorrectName;

//пример использования тест сьютов из junit'a, был в презентации
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestFailedLoginWithWrongPassword.class,
        TestLoginShowsCorrectName.class
})
public class SuiteTestForLogin {
}


