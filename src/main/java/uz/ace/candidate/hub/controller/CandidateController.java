package uz.ace.candidate.hub.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import uz.ace.candidate.hub.dto.CandidateDTO;
import uz.ace.candidate.hub.service.CandidateService;

/**
 * Rest controller for managing {@link uz.ace.candidate.hub.domain.Candidate}
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CandidateController {
    private final CandidateService candidateService;

    /**
     * Save candidate (Create or update a (new/existing) candidate).
     *
     * @param candidateDTO - the candidateDTO to create/update.
     * @return - returns response with status 200 and with body candidateDTO.
     */
    @PostMapping("/candidates")
    public Mono<CandidateDTO> saveCandidate(@RequestBody @Valid CandidateDTO candidateDTO) {
        log.debug("REST request to Create/Update candidate({})", candidateDTO);
        return candidateService.saveCandidate(candidateDTO);
    }
}
