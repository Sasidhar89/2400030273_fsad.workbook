package coursedemo.service;

import coursedemo.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>();

    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courseList;
    }

    public Optional<Course> getCourseById(int id) {
        return courseList.stream()
                .filter(c -> c.getCourseId() == id)
                .findFirst();
    }

    public Optional<Course> updateCourse(int id, Course updatedCourse) {
        for (Course c : courseList) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    public boolean deleteCourse(int id) {
        return courseList.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }
        return result;
    }
}