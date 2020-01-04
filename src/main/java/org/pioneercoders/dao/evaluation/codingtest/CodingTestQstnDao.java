package org.pioneercoders.dao.evaluation.codingtest;

import java.util.List;

import org.pioneercoders.entity.evaluation.codingtest.CodingTestQstnEntity;
import org.pioneercoders.entity.evaluation.codingtest.CodingTestResultEntity;
import org.pioneercoders.exceptions.DBException;

public interface CodingTestQstnDao {
	
	public List<CodingTestQstnEntity> getAllQuestions() throws DBException;
	
	public CodingTestQstnEntity saveQuestion(CodingTestQstnEntity codingTestQstnEntity) throws DBException;
	
	public CodingTestQstnEntity getCodingQstnById(Long id) throws DBException;
	
	public CodingTestResultEntity saveCodingTestResult(CodingTestResultEntity codingTestResultEntity) throws DBException;
	
	public List<CodingTestResultEntity> getCodingTestResultListByUserId(Long userId) throws DBException;
	
	public CodingTestResultEntity checkRecordExistOrNotWithQuesIdandUserId(Long questionId,Long userId) throws DBException;
	
}
