package org.pioneercoders.dao.admin;

import java.util.List;

import org.pioneercoders.entity.admin.ExpendatureEntity;
import org.pioneercoders.exceptions.DBException;

public interface ExpendatureDao {

	public ExpendatureEntity saveExpendature(ExpendatureEntity expendatureEntity)throws DBException;
	
	public List<ExpendatureEntity> getExpendatureList() throws DBException;
	
	public List<ExpendatureEntity> getTotalExpeListByDate(String startDate,String endDate)throws DBException;
}
