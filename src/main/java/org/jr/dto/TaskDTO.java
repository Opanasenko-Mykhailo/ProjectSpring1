package org.jr.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jr.model.enums.Status;

@Data
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String description;
    private Status status;
}
