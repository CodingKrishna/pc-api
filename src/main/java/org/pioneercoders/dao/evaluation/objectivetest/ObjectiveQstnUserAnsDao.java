package org.pioneercoders.dao.evaluation.objectivetest;

import java.util.List;

import org.pioneercoders.entity.evaluation.objectivetest.ObjectiveQstnUserAnsEntity;
import org.pioneercoders.exceptions.DBException;

public interface ObjectiveQstnUserAnsDao {
	
	public ObjectiveQstnUserAnsEntity insertObjQstnUserAnsRecord(ObjectiveQstnUserAnsEntity ObjectiveQstnUserAnsEntity) throws DBException;
	
	public List<ObjectiveQstnUserAnsEntity> getAllObjQstnUserAnsRecordsList() throws DBException;

	public List<ObjectiveQstnUserAnsEntity> getObjQstnUserAnsRecordByPersonalInfoId(Long personalInfoId)  throws DBException;
	
	public void flushSession();
}
