package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        List<Course> list = courseMapper.findCourseByCondition(courseVO);

        return list;
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        //封装课程信息
        Course course = new Course();

        BeanUtils.copyProperties(course,courseVO);

        //补全课程信息
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);

        //保存课程
        courseMapper.saveCourse(course);

        //获取新插入数据id值
        int id = course.getId();

        //封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);

        //补全讲师信息
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);
        teacher.setCourseId(id);

        //保存讲师信息
        courseMapper.saveTeacher(teacher);


    }

    @Override
    public CourseVO findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        //封装课程信息
        Course course = new Course();

        BeanUtils.copyProperties(course,courseVO);

        //补全课程信息
        Date date = new Date();
        course.setUpdateTime(date);

        //保存课程
        courseMapper.updateCourse(course);

        //获取新插入数据id值
        int id = course.getId();

        //封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);

        //补全讲师信息
        teacher.setUpdateTime(date);
        teacher.setCourseId(id);

        //保存讲师信息
        courseMapper.updateTeacher(teacher);

    }

    @Override
    public void updateCourseStatus(int courseId, int status) {

        //1.封装数据
        Course course = new Course();
        course.setId(courseId);
        course.setStatus(status);
        course.setUpdateTime(new Date());

        //2.调用mapper
        courseMapper.updateCourseStatus(course);

    }
}
