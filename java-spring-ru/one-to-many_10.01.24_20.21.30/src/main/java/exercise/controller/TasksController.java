package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository repository;
    @Autowired
    private  TaskMapper taskMapper;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDTO> index() {
        var result = repository.findAll().stream().map(t -> taskMapper.map(t)).toList();
        return result;
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO show(@PathVariable Long id) {
        var maybeTask = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Tasks with id %s not found", id)));
        return taskMapper.map(maybeTask);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody TaskCreateDTO taskCreateDTO) {
        var task = taskMapper.map(taskCreateDTO);
        repository.save(task);
        return taskMapper.map(task);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO update(@RequestBody @Valid TaskUpdateDTO taskUpdateDTO, @PathVariable Long id) {
        var maybeTask = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Tasks with id %s not found", id)));
        var user = userRepository.findById(taskUpdateDTO.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        taskMapper.update(taskUpdateDTO, maybeTask);
        maybeTask.setAssignee(user);
        repository.save(maybeTask);
        return  taskMapper.map(maybeTask);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        var maybeTask = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Tasks with id %s not found", id)));
        repository.delete(maybeTask);
    }
    // END
}
