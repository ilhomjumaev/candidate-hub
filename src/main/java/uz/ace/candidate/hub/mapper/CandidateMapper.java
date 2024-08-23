package uz.ace.candidate.hub.mapper;

import lombok.experimental.UtilityClass;
import uz.ace.candidate.hub.domain.Candidate;
import uz.ace.candidate.hub.dto.CandidateDTO;

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

            candidate.setEmail(candidateDTO.email());
        }
        candidate.setFirstName(candidateDTO.firstName());
        candidate.setLastName(candidateDTO.lastName());
        candidate.setPhoneNumber(candidateDTO.phoneNumber());
        candidate.setLinkedinUrl(candidateDTO.linkedinUrl());
        candidate.setGithubUrl(candidateDTO.githubUrl());
        candidate.setComment(candidateDTO.comment());

        return candidate;
    }
}
