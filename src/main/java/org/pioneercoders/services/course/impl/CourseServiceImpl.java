package org.pioneercoders.services.course.impl;

import java.io.IOException;
import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.pioneercoders.dao.course.BatchTimingsDao;
import org.pioneercoders.dao.course.CourseDao;
import org.pioneercoders.dao.user.PurchasedCoursesDao;
import org.pioneercoders.dto.course.BatchTimingDto;
import org.pioneercoders.dto.course.CourseDto;
import org.pioneercoders.dto.student.PurchasedCourseDto;
import org.pioneercoders.entity.course.BatchTimingsEntity;
import org.pioneercoders.entity.course.CourseEntity;
import org.pioneercoders.entity.student.PurchasedCourseEntity;
import org.pioneercoders.exceptions.DBException;
import org.pioneercoders.exceptions.ServiceException;
import org.pioneercoders.services.course.CourseService;
import org.pioneercoders.utils.AppConfig;
import org.pioneercoders.utils.CollectionMapper;
import org.pioneercoders.utils.Constants;
import org.pioneercoders.utils.FileReadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CourseServiceImpl implements CourseService {

	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired(required = true)
	CourseDao courseDao;
	
	@Autowired(required = true)
	BatchTimingsDao batchTimingsDao;
	
	@Autowired(required = true)
	PurchasedCoursesDao purchasedCourseDao;
	
	@Autowired
	AppConfig appConfig;

	@Override
	public List<CourseDto> getAllCourses(boolean featuredCourses) throws ServiceException {
		log.info("Entered into getAllCourses -->: ");
		List<CourseEntity> list;

		try {
			list = courseDao.getAllCourses(featuredCourses);
			List<CourseDto> courseList = CollectionMapper.getMappingList(list.iterator(), CourseDto.class);
			log.info("Returning courseList -->: ");
			return courseList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing CourseList data");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public CourseDto getCourseInfo(Long courseId) throws ServiceException {
		try {
			CourseEntity entity = courseDao.getCourseInfo(courseId);
			CourseDto courseDto = DozerBeanMapperSingletonWrapper.getInstance().map(entity, CourseDto.class);
			
			try {
				courseDto.setDescTemplate(FileReadUtil.getFileContent( appConfig.getCoursesDirectory() + "\\" + courseDto.getDescPath(), "course"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				courseDto.setDescTemplate(Constants.NO_COURSE_DESCRIPTION);
			}
			
			return courseDto;
		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public List<BatchTimingDto> getBatchTimingDetailsByCourseId(Long courseId) throws ServiceException {
		log.info("Entered into getAllBatchDetails -->: ");
		List<BatchTimingsEntity> list;

		try {
			list = batchTimingsDao.getAllBatchDetailsByCourseId(courseId);
			List<BatchTimingDto> courseList = CollectionMapper.getMappingList(list.iterator(), BatchTimingDto.class);
			log.info("Returning BatchDetailsList data -->: ");
			return courseList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllBatchDetail method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public PurchasedCourseDto createPurchasedCourseRecord(PurchasedCourseDto purchaseCourseDto) throws ServiceException {
		PurchasedCourseDto finalPurchasedDto=null;
		try {
			purchaseCourseDto.setPurchasedOn(Constants.CREATED_ON());
			PurchasedCourseEntity purchasedCourseEntity = DozerBeanMapperSingletonWrapper.getInstance().map(purchaseCourseDto, PurchasedCourseEntity.class);
			finalPurchasedDto = DozerBeanMapperSingletonWrapper.getInstance().map(purchasedCourseDao.createPurchasedCourseRecord(purchasedCourseEntity),PurchasedCourseDto.class);

		} catch (DBException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return finalPurchasedDto;
	}

	@Override
	public List<PurchasedCourseDto> getPurchasedCoursesByUserId(Long userId)
			throws ServiceException {
		log.info("Entered into getPurchasedCoursesByUserId -->: ");
		List<PurchasedCourseEntity> list;

		try {
			list = purchasedCourseDao.getPurchasedCoursesByUserId(userId);
			List<PurchasedCourseDto> courseList = CollectionMapper.getMappingList(list.iterator(), PurchasedCourseDto.class);
			log.info("Returning PurchasedCourseList data -->: ");
			return courseList;
		} catch (DBException e) {
			if (log.isErrorEnabled()) {
				log.error("Exception occured while executing getAllPurchasedCourseList method");
				log.error(e.getMessage());
			}
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	
}