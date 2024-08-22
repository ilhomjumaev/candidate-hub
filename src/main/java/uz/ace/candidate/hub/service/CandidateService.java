package uz.ace.candidate.hub.service;

import reactor.core.publisher.Mono;
import uz.ace.candidate.hub.dto.CandidateDTO;

public interface CandidateService {
    Mono<CandidateDTO> saveCandidate(CandidateDTO candidateDTO);
}
