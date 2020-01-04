package org.pioneercoders.dao.course;

import java.util.List;

import org.pioneercoders.entity.course.BatchTimingsEntity;
import org.pioneercoders.exceptions.DBException;

public interface BatchTimingsDao {
	
	public List<BatchTimingsEntity> getAllBatchDetailsByCourseId(Long courseId) throws DBException;

}
