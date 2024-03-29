package org.example.service;

import org.example.dto.TaskDTO;
import org.example.mapper.TaskMapper;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TaskService{
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository,@Qualifier("taskMapperImpl")TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }


    public Page<TaskDTO> getAllTasks(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Task> tasksPage = taskRepository.findAll(pageable);
        return tasksPage.map(taskMapper::toDTO);
    }


    public TaskDTO getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(taskMapper::toDTO).orElse(null);
    }


    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.toModel(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDTO(savedTask);
    }


    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskMapper.toModel(taskDTO);
        task.setId(id);
        Task updatedTask = taskRepository.save(task);
        return taskMapper.toDTO(updatedTask);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
