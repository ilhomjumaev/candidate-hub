package uz.ace.candidate.hub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.io.Serializable;
import java.time.Instant;

@Data
public class AbstractAuditing implements Serializable {
    @Version
    private Long version;
    @CreatedDate
    private Instant createdAt = Instant.now();
    @LastModifiedDate
    private Instant modifiedAt = Instant.now();
    @JsonIgnore
    private boolean deleted = false;
}
