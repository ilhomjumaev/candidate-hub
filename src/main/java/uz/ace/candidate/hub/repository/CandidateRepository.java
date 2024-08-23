package uz.ace.candidate.hub.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import uz.ace.candidate.hub.domain.Candidate;

import java.util.UUID;

@Repository
public interface CandidateRepository extends R2dbcRepository<Candidate, UUID> {
    Mono<Candidate> findCandidateByEmail(String email);
}
