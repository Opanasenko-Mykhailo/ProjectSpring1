package org.jr.mapper;

import org.jr.dto.TaskDTO;
import org.jr.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO toDTO(Task task);

    Task toModel(TaskDTO taskDTO);
}
