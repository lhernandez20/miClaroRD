package miClaroTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ logout.class, noUsernameAndPassword.class, succefullLogin.class, validateLoginFailedMessage.class,
		wrongUsernameAndPassword.class })
public class AllTests {

}
