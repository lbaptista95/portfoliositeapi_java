package com.lb.portfolio.api.model.entity;

import com.lb.portfolio.api.model.entity.id.MediaProjectId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "media_project")
public class MediaProject implements Serializable {

    @EmbeddedId
    private MediaProjectId id;
}
