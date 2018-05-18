/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.amf.registration.sb.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog;
import com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalService;
import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationAuditLogPersistence;
import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationFinder;
import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the amf registration audit log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.docs.amf.registration.sb.service.impl.AmfRegistrationAuditLogLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.amf.registration.sb.service.impl.AmfRegistrationAuditLogLocalServiceImpl
 * @see com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class AmfRegistrationAuditLogLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AmfRegistrationAuditLogLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.docs.amf.registration.sb.service.AmfRegistrationAuditLogLocalServiceUtil} to access the amf registration audit log local service.
	 */

	/**
	 * Adds the amf registration audit log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfRegistrationAuditLog the amf registration audit log
	 * @return the amf registration audit log that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AmfRegistrationAuditLog addAmfRegistrationAuditLog(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		amfRegistrationAuditLog.setNew(true);

		return amfRegistrationAuditLogPersistence.update(amfRegistrationAuditLog);
	}

	/**
	 * Creates a new amf registration audit log with the primary key. Does not add the amf registration audit log to the database.
	 *
	 * @param id the primary key for the new amf registration audit log
	 * @return the new amf registration audit log
	 */
	@Override
	public AmfRegistrationAuditLog createAmfRegistrationAuditLog(long id) {
		return amfRegistrationAuditLogPersistence.create(id);
	}

	/**
	 * Deletes the amf registration audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the amf registration audit log
	 * @return the amf registration audit log that was removed
	 * @throws PortalException if a amf registration audit log with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AmfRegistrationAuditLog deleteAmfRegistrationAuditLog(long id)
		throws PortalException {
		return amfRegistrationAuditLogPersistence.remove(id);
	}

	/**
	 * Deletes the amf registration audit log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfRegistrationAuditLog the amf registration audit log
	 * @return the amf registration audit log that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AmfRegistrationAuditLog deleteAmfRegistrationAuditLog(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		return amfRegistrationAuditLogPersistence.remove(amfRegistrationAuditLog);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AmfRegistrationAuditLog.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return amfRegistrationAuditLogPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return amfRegistrationAuditLogPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return amfRegistrationAuditLogPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return amfRegistrationAuditLogPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return amfRegistrationAuditLogPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AmfRegistrationAuditLog fetchAmfRegistrationAuditLog(long id) {
		return amfRegistrationAuditLogPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the amf registration audit log with the primary key.
	 *
	 * @param id the primary key of the amf registration audit log
	 * @return the amf registration audit log
	 * @throws PortalException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog getAmfRegistrationAuditLog(long id)
		throws PortalException {
		return amfRegistrationAuditLogPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(amfRegistrationAuditLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AmfRegistrationAuditLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(amfRegistrationAuditLogLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AmfRegistrationAuditLog.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(amfRegistrationAuditLogLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AmfRegistrationAuditLog.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return amfRegistrationAuditLogLocalService.deleteAmfRegistrationAuditLog((AmfRegistrationAuditLog)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return amfRegistrationAuditLogPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the amf registration audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> getAmfRegistrationAuditLogs(
		int start, int end) {
		return amfRegistrationAuditLogPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of amf registration audit logs.
	 *
	 * @return the number of amf registration audit logs
	 */
	@Override
	public int getAmfRegistrationAuditLogsCount() {
		return amfRegistrationAuditLogPersistence.countAll();
	}

	/**
	 * Updates the amf registration audit log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param amfRegistrationAuditLog the amf registration audit log
	 * @return the amf registration audit log that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AmfRegistrationAuditLog updateAmfRegistrationAuditLog(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		return amfRegistrationAuditLogPersistence.update(amfRegistrationAuditLog);
	}

	/**
	 * Returns the amf registration local service.
	 *
	 * @return the amf registration local service
	 */
	public com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalService getAmfRegistrationLocalService() {
		return amfRegistrationLocalService;
	}

	/**
	 * Sets the amf registration local service.
	 *
	 * @param amfRegistrationLocalService the amf registration local service
	 */
	public void setAmfRegistrationLocalService(
		com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalService amfRegistrationLocalService) {
		this.amfRegistrationLocalService = amfRegistrationLocalService;
	}

	/**
	 * Returns the amf registration persistence.
	 *
	 * @return the amf registration persistence
	 */
	public AmfRegistrationPersistence getAmfRegistrationPersistence() {
		return amfRegistrationPersistence;
	}

	/**
	 * Sets the amf registration persistence.
	 *
	 * @param amfRegistrationPersistence the amf registration persistence
	 */
	public void setAmfRegistrationPersistence(
		AmfRegistrationPersistence amfRegistrationPersistence) {
		this.amfRegistrationPersistence = amfRegistrationPersistence;
	}

	/**
	 * Returns the amf registration finder.
	 *
	 * @return the amf registration finder
	 */
	public AmfRegistrationFinder getAmfRegistrationFinder() {
		return amfRegistrationFinder;
	}

	/**
	 * Sets the amf registration finder.
	 *
	 * @param amfRegistrationFinder the amf registration finder
	 */
	public void setAmfRegistrationFinder(
		AmfRegistrationFinder amfRegistrationFinder) {
		this.amfRegistrationFinder = amfRegistrationFinder;
	}

	/**
	 * Returns the amf registration audit log local service.
	 *
	 * @return the amf registration audit log local service
	 */
	public AmfRegistrationAuditLogLocalService getAmfRegistrationAuditLogLocalService() {
		return amfRegistrationAuditLogLocalService;
	}

	/**
	 * Sets the amf registration audit log local service.
	 *
	 * @param amfRegistrationAuditLogLocalService the amf registration audit log local service
	 */
	public void setAmfRegistrationAuditLogLocalService(
		AmfRegistrationAuditLogLocalService amfRegistrationAuditLogLocalService) {
		this.amfRegistrationAuditLogLocalService = amfRegistrationAuditLogLocalService;
	}

	/**
	 * Returns the amf registration audit log persistence.
	 *
	 * @return the amf registration audit log persistence
	 */
	public AmfRegistrationAuditLogPersistence getAmfRegistrationAuditLogPersistence() {
		return amfRegistrationAuditLogPersistence;
	}

	/**
	 * Sets the amf registration audit log persistence.
	 *
	 * @param amfRegistrationAuditLogPersistence the amf registration audit log persistence
	 */
	public void setAmfRegistrationAuditLogPersistence(
		AmfRegistrationAuditLogPersistence amfRegistrationAuditLogPersistence) {
		this.amfRegistrationAuditLogPersistence = amfRegistrationAuditLogPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog",
			amfRegistrationAuditLogLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AmfRegistrationAuditLogLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AmfRegistrationAuditLog.class;
	}

	protected String getModelClassName() {
		return AmfRegistrationAuditLog.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = amfRegistrationAuditLogPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalService.class)
	protected com.liferay.docs.amf.registration.sb.service.AmfRegistrationLocalService amfRegistrationLocalService;
	@BeanReference(type = AmfRegistrationPersistence.class)
	protected AmfRegistrationPersistence amfRegistrationPersistence;
	@BeanReference(type = AmfRegistrationFinder.class)
	protected AmfRegistrationFinder amfRegistrationFinder;
	@BeanReference(type = AmfRegistrationAuditLogLocalService.class)
	protected AmfRegistrationAuditLogLocalService amfRegistrationAuditLogLocalService;
	@BeanReference(type = AmfRegistrationAuditLogPersistence.class)
	protected AmfRegistrationAuditLogPersistence amfRegistrationAuditLogPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}