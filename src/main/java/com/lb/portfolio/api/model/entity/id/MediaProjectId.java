package com.lb.portfolio.api.model.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MediaProjectId implements Serializable {

    @Column(name = "project_id", nullable = false)
    private Integer projectId;
    @Column(name = "media_id", nullable = false)
    private Integer mediaId;
    // project - media
}
