package coursedemo.controller;

import coursedemo.model.Course;
import coursedemo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> addCourse(@RequestBody Course course) {

        if (course.getTitle() == null || course.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().body("Title cannot be empty");
        }

        return new ResponseEntity<Object>(service.addCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCourse(@PathVariable int id) {

        return service.getCourseById(id)
                .map(course -> ResponseEntity.ok((Object) course))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Course not found"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable int id,
                                               @RequestBody Course course) {

        return service.updateCourse(id, course)
                .map(updated -> ResponseEntity.ok((Object) updated))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Course not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable int id) {

        if (service.deleteCourse(id)) {
            return ResponseEntity.ok("Course deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchByTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}