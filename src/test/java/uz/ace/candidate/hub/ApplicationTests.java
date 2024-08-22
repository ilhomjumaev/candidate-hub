package uz.ace.candidate.hub;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTests {

    @Test
    void contextLoads() {
        String message = "Message";

        assertThat(message).isNotEqualTo("No message");
    }
}
