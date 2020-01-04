package org.pioneercoders.dao.common;

import java.util.List;

import org.pioneercoders.entity.common.InstructorEntity;
import org.pioneercoders.exceptions.DBException;

public interface InstructorDao {
	
	public InstructorEntity createInstructorInfo(InstructorEntity instructorEntity) throws DBException;
	
	public List<InstructorEntity> getInstructorsList()throws DBException;

}
