package org.example.mapper;

import org.example.dto.TaskDTO;
import org.example.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO toDTO(Task task);

    Task toModel(TaskDTO taskDTO);
}
