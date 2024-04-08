package org.jr.controller;

import lombok.RequiredArgsConstructor;
import org.jr.dto.TaskDTO;
import org.jr.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String getAllTasks(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Model model
    ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<TaskDTO> page = taskService.getAllTasks(pageable);
        model.addAttribute("page", page);
        return "task-list";
    }

    @GetMapping("/search")
    public ResponseEntity<TaskDTO> searchTaskById(@RequestParam Long id) {
        TaskDTO task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }


    @PostMapping
    public String createTask(@ModelAttribute TaskDTO taskDTO) {
        taskService.createTask(taskDTO);
        return "redirect:/";
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(
            @PathVariable Long id,
            @RequestBody TaskDTO taskDTO
    ) {
        taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

}