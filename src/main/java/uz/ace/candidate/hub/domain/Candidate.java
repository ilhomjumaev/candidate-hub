package uz.ace.candidate.hub.domain;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

/**
 * An Entity of Candidate.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate")
public class Candidate extends AbstractAuditing implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Candidate ID.
     */
    @Id
    private UUID id;

    /**
     * Candidate firstname.
     */
    @NotNull(message = "Firstname must not be Null")
    private String firstName;
    /**
     * Candidate lastname.
     */
    @NotNull(message = "Lastname must not be Null")
    private String lastName;
    /**
     * Candidate phone number.
     */
    private String phoneNumber;
    /**
     * Candidate email.
     */
    @NotNull(message = "Email must not be Null")
    private String email;
    /**
     * LinkedIn profile URL if existed.
     */
    private String linkedinUrl;
    /**
     * GitHub profile URL if existed.
     */
    private String githubUrl;
    /**
     * Free text comment.
     */
    @NotNull(message = "Comment must not be Null or Empty")
    private String comment;
}
