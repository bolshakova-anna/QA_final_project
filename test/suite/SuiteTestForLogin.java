package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.TestFailedLoginWithWrongPassword;
import test.TestLoginShowsCorrectName;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestFailedLoginWithWrongPassword.class,
        TestLoginShowsCorrectName.class
})
public class SuiteTestForLogin {
}


