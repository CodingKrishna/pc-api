package org.pioneercoders.services.course;

import java.util.List;

import org.pioneercoders.dto.course.BatchTimingDto;
import org.pioneercoders.dto.course.CourseDto;
import org.pioneercoders.dto.student.PurchasedCourseDto;
import org.pioneercoders.exceptions.ServiceException;

public interface CourseService {
	
	public List<CourseDto> getAllCourses(boolean featuredCourses) throws ServiceException;

	public CourseDto getCourseInfo(Long courseId) throws ServiceException;
	
	public List<BatchTimingDto> getBatchTimingDetailsByCourseId(Long courseId)throws ServiceException;
	
	public PurchasedCourseDto createPurchasedCourseRecord(PurchasedCourseDto purchaseCourseDto) throws ServiceException;
	
	public List<PurchasedCourseDto> getPurchasedCoursesByUserId(Long userId)throws ServiceException;
	
}
