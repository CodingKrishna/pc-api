package org.pioneercoders.dao.user;

import java.util.List;

import org.pioneercoders.entity.student.PurchasedCourseEntity;
import org.pioneercoders.exceptions.DBException;

public interface PurchasedCoursesDao {
	
	public PurchasedCourseEntity createPurchasedCourseRecord(PurchasedCourseEntity purchasedCoursesEntity) throws DBException;

	public List<PurchasedCourseEntity> getPurchasedCoursesByUserId(Long userId) throws DBException;
}
