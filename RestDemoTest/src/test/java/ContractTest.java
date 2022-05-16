/*
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import au.com.dius.pact.provider.junitsupport.target.Target;
import au.com.dius.pact.provider.junitsupport.target.TestTarget;
import com.github.restdriver.clientdriver.ClientDriverRule;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import java.util.Map;

import static com.github.restdriver.clientdriver.RestClientDriver.giveEmptyResponse;
import static com.github.restdriver.clientdriver.RestClientDriver.onRequestTo;

@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("myAwesomeService") // Set up name of tested provider
@PactFolder("pacts") // Point where to find pacts (See also section Pacts source in documentation)
public class ContractTest {
    // NOTE: this is just an example of embedded service that listens to requests, you should start here real service
    @ClassRule //Rule will be applied once: before/after whole contract test suite
    public static final ClientDriverRule embeddedService = new ClientDriverRule(80);

    @BeforeClass //Method will be run once: before whole contract test suite
    public static void setUpService() {
        //Run DB, create schema
        //Run service
        //...
    }

    @Before //Method will be run before each test of interaction
    public void before() {
        // Rest data
        // Mock dependent service responses
        // ...
        embeddedService.addExpectation(
                onRequestTo("/restdemotest/setup"), giveEmptyResponse()
        );
    }

    @State({"default", "no-data"}) // Method will be run before testing interactions that require "default" or "no-data" state
    public void toDefaultState() {
        // Prepare service before interaction that require "default" state
        // ...
        System.out.println("Now service in default state");
    }

    @State("with-data") // Method will be run before testing interactions that require "with-data" state
    public void toStateWithData(Map data) {
        // Prepare service before interaction that require "with-data" state. The provider state data will be passed
        // in the data parameter
        // ...
        System.out.println("Now service in state using data " + data);
    }

    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(80); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)
}*/
