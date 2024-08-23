package uz.ace.candidate.hub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record CandidateDTO(@JsonProperty("firstName") String firstName,
                           @JsonProperty("lastName") String lastName,
                           @JsonProperty("phoneNumber") String phoneNumber,
                           @JsonProperty("email") String email,
                           @JsonProperty("linkedinUrl") String linkedinUrl,
                           @JsonProperty("githubUrl") String githubUrl,
                           @JsonProperty("comment") String comment) implements Serializable {
}
