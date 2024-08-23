package uz.ace.candidate.hub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link uz.ace.candidate.hub.domain.Candidate} entity.
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandidateDTO implements Serializable {
    @NotNull(message = "Firstname is mandatory")
    @Size(min = 3, max = 50)
    @JsonProperty("firstName")
    private String firstName;

    @NotNull(message = "Lastname is mandatory")
    @Size(min = 3, max = 50)
    @JsonProperty("lastName")
    private String lastName;

    @Size(max = 20)
    @Pattern(regexp = "^998([378]{2}|(9[013-57-9]))\\d{7}$", message = "Phone number incorrect")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @NotNull(message = "Email is mandatory")
    @Size(min = 3, max = 50)
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Email incorrect")
    @JsonProperty("email")
    private String email;

    @Size(max = 255)
    @JsonProperty("linkedinUrl")
    private String linkedinUrl;

    @Size(max = 255)
    @JsonProperty("githubUrl")
    private String githubUrl;

    @NotBlank(message = "Comment is mandatory")
    @Size(min = 1, max = 4000)
    @JsonProperty("comment")
    private String comment;
}
