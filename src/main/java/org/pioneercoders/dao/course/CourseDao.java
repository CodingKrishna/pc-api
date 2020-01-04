package org.pioneercoders.dao.course;

import java.util.List;

import org.pioneercoders.entity.course.CourseEntity;
import org.pioneercoders.exceptions.DBException;

public interface CourseDao {
	
	public List<CourseEntity> getAllCourses(boolean featuredCourses) throws DBException;
	
	public CourseEntity getCourseInfo(Long courseId) throws DBException;

}
