package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.Teacher;
import com.lagou.domain.CourseVO;

import java.util.List;

public interface CourseMapper {

    /*
        多条件课程列表查询
     */

    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*
        新增课程信息
     */
    public void saveCourse(Course course);

    /*
        新增讲师信息
     */
    public void saveTeacher(Teacher theacher);

    /*
        回显课程信息（根据id查询对应的课程信息及关联的教师信息）
     */
    public CourseVO findCourseById(Integer id);

    /*
        更新课程信息
     */
    public void updateCourse(Course course);

    /*
        更新讲师信息
     */
    public void updateTeacher(Teacher theacher);

    /*
        课程状态管理
     */
    public void updateCourseStatus(Course course);





}
