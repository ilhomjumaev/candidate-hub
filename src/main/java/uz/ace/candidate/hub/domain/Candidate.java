package uz.ace.candidate.hub.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate")
public class Candidate extends AbstractAuditing implements Serializable {
    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String linkedinUrl;
    private String githubUrl;
    private String comment;
}
