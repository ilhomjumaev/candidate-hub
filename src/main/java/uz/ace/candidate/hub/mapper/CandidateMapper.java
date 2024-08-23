package uz.ace.candidate.hub.mapper;

import lombok.experimental.UtilityClass;
import uz.ace.candidate.hub.domain.Candidate;
import uz.ace.candidate.hub.dto.CandidateDTO;

/**
 * Mapper class for the entity {@link Candidate} and dto {@link CandidateDTO}.
 */
@UtilityClass
public class CandidateMapper {
    public CandidateDTO candidateDTO(Candidate candidate) {
        return CandidateDTO.builder()
                .firstName(candidate.getFirstName())
                .lastName(candidate.getLastName())
                .phoneNumber(candidate.getPhoneNumber())
                .email(candidate.getEmail())
                .linkedinUrl(candidate.getLinkedinUrl())
                .githubUrl(candidate.getGithubUrl())
                .comment(candidate.getComment())
                .build();
    }

    public Candidate candidate(Candidate candidate, CandidateDTO candidateDTO) {
        if (candidate == null) {
            candidate = Candidate.builder().build();

            candidate.setEmail(candidateDTO.getEmail());
        }
        candidate.setFirstName(candidateDTO.getFirstName());
        candidate.setLastName(candidateDTO.getLastName());
        candidate.setPhoneNumber(candidateDTO.getPhoneNumber());
        candidate.setLinkedinUrl(candidateDTO.getLinkedinUrl());
        candidate.setGithubUrl(candidateDTO.getGithubUrl());
        candidate.setComment(candidateDTO.getComment());

        return candidate;
    }
}
