package org.pioneercoders.dao.evaluation.objectivetest;

import java.util.List;

import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveTestTotalResultEntity;
import org.pioneercoders.exceptions.DBException;

public interface ObjectiveTestTotalResultDao {
	
	public ObjectiveTestTotalResultEntity insertObjTestTotalResult(ObjectiveTestTotalResultEntity objectiveTestTotalResultEntity) throws DBException;
	
	public List<ObjectiveTestTotalResultEntity> getAllObjTestData() throws DBException;
	
	public List<ObjectiveTestTotalResultEntity> getAllObjTestInfoByProfileId(Long id)throws DBException;
	
}
