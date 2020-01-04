package org.pioneercoders.dao.user;

import java.util.List;

import org.pioneercoders.entity.common.TechnologiesEntity;
import org.pioneercoders.entity.student.ProjectEntity;
import org.pioneercoders.entity.student.TechSkillEntity;
import org.pioneercoders.exceptions.DBException;

public interface TechSkillDao {

	public List<TechnologiesEntity> getAllTechnologies()throws DBException;
	
	public TechSkillEntity createTechSkillRecord(TechSkillEntity techSkillEntity)throws DBException;
	
	public TechSkillEntity updateTechSkillRecord(TechSkillEntity techSkillEntity)throws DBException;
	
	public List<TechSkillEntity> getTechSkillRecordsByUserId(Long userId) throws DBException;
	
	public TechSkillEntity getTechSkillRecordByUserIdAndTechId(Long userId,Long techId) throws DBException;
	
	public int deleteTechSkillByUserId(Long userId) throws DBException;
	
	public List<TechSkillEntity> saveOrUpdateTechSkill(List<TechSkillEntity> technologiesList) throws DBException;
	
}
