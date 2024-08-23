package uz.ace.candidate.hub.service;

import reactor.core.publisher.Mono;
import uz.ace.candidate.hub.dto.CandidateDTO;

/**
 * Service for managing {@link uz.ace.candidate.hub.domain.Candidate}
 */
public interface CandidateService {
    /**
     * Save candidate.
     *
     * @param candidateDTO - candidateDTO for the creation/update candidate.
     * @return - candidateDTO - the persisted.
     */
    Mono<CandidateDTO> saveCandidate(CandidateDTO candidateDTO);
}
