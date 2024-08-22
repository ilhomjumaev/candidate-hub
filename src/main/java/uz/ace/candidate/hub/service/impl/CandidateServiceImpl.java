package uz.ace.candidate.hub.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import uz.ace.candidate.hub.dto.CandidateDTO;
import uz.ace.candidate.hub.service.CandidateService;

@Slf4j
@RequiredArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService {
    @Override
    public Mono<CandidateDTO> saveCandidate(CandidateDTO candidateDTO) {

        return Mono.empty();
    }
}
