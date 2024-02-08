package org.example;

import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider("myAwesomeService")
@PactFolder("pacts")
class MainTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

    @BeforeEach
    void beforeEach(PactVerificationContext context) {
        LOGGER.info("beforeEach called: " + context);
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void testTemplate(PactVerificationContext context) {
        LOGGER.info("testTemplate called: " + context);

        context.verifyInteraction();
    }
}
