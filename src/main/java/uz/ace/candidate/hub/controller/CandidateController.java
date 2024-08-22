package uz.ace.candidate.hub.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import uz.ace.candidate.hub.dto.CandidateDTO;
import uz.ace.candidate.hub.service.CandidateService;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("/candidates")
    public Mono<CandidateDTO> saveCandidate(@RequestBody CandidateDTO candidateDTO) {
        log.info("REST request to Create/Update candidate({})", candidateDTO);
        return candidateService.saveCandidate(candidateDTO);
    }
}
