package org.pioneercoders.dao.common;

import org.pioneercoders.entity.common.SubscribeEntity;
import org.pioneercoders.exceptions.DBException;

public interface SubscriberDao {
	public SubscribeEntity createSubscribeRecord(SubscribeEntity SubscribeEntity) throws DBException;
}
