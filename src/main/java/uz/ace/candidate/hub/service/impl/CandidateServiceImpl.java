package uz.ace.candidate.hub.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import uz.ace.candidate.hub.domain.Candidate;
import uz.ace.candidate.hub.dto.CandidateDTO;
import uz.ace.candidate.hub.mapper.CandidateMapper;
import uz.ace.candidate.hub.repository.CandidateRepository;
import uz.ace.candidate.hub.service.CandidateService;

/**
 * Service implementation for managing {@link Candidate}
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;

    /**
     * Save candidate.
     *
     * @param candidateDTO - candidateDTO for the creation/update candidate.
     * @return - candidateDTO.
     */
    @Override
    public Mono<CandidateDTO> saveCandidate(CandidateDTO candidateDTO) {
        return candidateRepository.findCandidateByEmail(candidateDTO.getEmail())
                .flatMap(candidate -> updateCandidate(candidate, candidateDTO)
                        .map(CandidateMapper::candidateDTO))
                .switchIfEmpty(
                        Mono.just(CandidateDTO.builder().build())
                                .flatMap(existCandidate -> {
                                            if (existCandidate.getEmail() == null) {
                                                return createCandidate(candidateDTO)
                                                        .map(CandidateMapper::candidateDTO);
                                            }
                                            return Mono.just(existCandidate);
                                        }
                                )
                );
    }

    /**
     * Create candidate.
     *
     * @param candidateDTO - candidateDTO.
     * @return - the persisted entity (Candidate).
     */
    private Mono<Candidate> createCandidate(CandidateDTO candidateDTO) {
        log.info("Creating candidate: {}", candidateDTO);
        return candidateRepository.save(CandidateMapper.candidate(null, candidateDTO));
    }

    /**
     * Update candidate.
     *
     * @param candidate    - an entity of Candidate.
     * @param candidateDTO - candidateDTO.
     * @return - the persisted entity (Candidate).
     */
    private Mono<Candidate> updateCandidate(Candidate candidate, CandidateDTO candidateDTO) {
        log.info("Updating candidate: {}", candidate);
        return candidateRepository.save(CandidateMapper.candidate(candidate, candidateDTO));
    }
}
