package org.jr.service;

import lombok.RequiredArgsConstructor;
import org.jr.dto.TaskDTO;
import org.jr.mapper.TaskMapper;
import org.jr.model.Task;
import org.jr.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService{
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public Page<TaskDTO> getAllTasks(Pageable pageable) {
        Page<Task> tasksPage = taskRepository.findAll(pageable);
        return tasksPage.map(taskMapper::toDTO);
    }
    public TaskDTO getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(taskMapper::toDTO).orElse(new TaskDTO());
    }
    public void createTask(TaskDTO taskDTO) {
        Task task = taskMapper.toModel(taskDTO);
        Task savedTask = taskRepository.save(task);
        taskMapper.toDTO(savedTask);
    }
    public void updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskMapper.toModel(taskDTO);
        task.setId(id);
        Task updatedTask = taskRepository.save(task);
        taskMapper.toDTO(updatedTask);
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
