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

package com.liferay.docs.amf.registration.sb.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationException;
import com.liferay.docs.amf.registration.sb.model.AmfRegistration;
import com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationImpl;
import com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationModelImpl;
import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the amf registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationPersistence
 * @see com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationUtil
 * @generated
 */
@ProviderType
public class AmfRegistrationPersistenceImpl extends BasePersistenceImpl<AmfRegistration>
	implements AmfRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AmfRegistrationUtil} to access the amf registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AmfRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AmfRegistrationPersistenceImpl() {
		setModelClass(AmfRegistration.class);
	}

	/**
	 * Caches the amf registration in the entity cache if it is enabled.
	 *
	 * @param amfRegistration the amf registration
	 */
	@Override
	public void cacheResult(AmfRegistration amfRegistration) {
		entityCache.putResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationImpl.class, amfRegistration.getPrimaryKey(),
			amfRegistration);

		amfRegistration.resetOriginalValues();
	}

	/**
	 * Caches the amf registrations in the entity cache if it is enabled.
	 *
	 * @param amfRegistrations the amf registrations
	 */
	@Override
	public void cacheResult(List<AmfRegistration> amfRegistrations) {
		for (AmfRegistration amfRegistration : amfRegistrations) {
			if (entityCache.getResult(
						AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						AmfRegistrationImpl.class,
						amfRegistration.getPrimaryKey()) == null) {
				cacheResult(amfRegistration);
			}
			else {
				amfRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all amf registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmfRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AmfRegistration amfRegistration) {
		entityCache.removeResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationImpl.class, amfRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AmfRegistration> amfRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AmfRegistration amfRegistration : amfRegistrations) {
			entityCache.removeResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				AmfRegistrationImpl.class, amfRegistration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new amf registration with the primary key. Does not add the amf registration to the database.
	 *
	 * @param dummy the primary key for the new amf registration
	 * @return the new amf registration
	 */
	@Override
	public AmfRegistration create(long dummy) {
		AmfRegistration amfRegistration = new AmfRegistrationImpl();

		amfRegistration.setNew(true);
		amfRegistration.setPrimaryKey(dummy);

		return amfRegistration;
	}

	/**
	 * Removes the amf registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dummy the primary key of the amf registration
	 * @return the amf registration that was removed
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration remove(long dummy)
		throws NoSuchAmfRegistrationException {
		return remove((Serializable)dummy);
	}

	/**
	 * Removes the amf registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf registration
	 * @return the amf registration that was removed
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration remove(Serializable primaryKey)
		throws NoSuchAmfRegistrationException {
		Session session = null;

		try {
			session = openSession();

			AmfRegistration amfRegistration = (AmfRegistration)session.get(AmfRegistrationImpl.class,
					primaryKey);

			if (amfRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAmfRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(amfRegistration);
		}
		catch (NoSuchAmfRegistrationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AmfRegistration removeImpl(AmfRegistration amfRegistration) {
		amfRegistration = toUnwrappedModel(amfRegistration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfRegistration)) {
				amfRegistration = (AmfRegistration)session.get(AmfRegistrationImpl.class,
						amfRegistration.getPrimaryKeyObj());
			}

			if (amfRegistration != null) {
				session.delete(amfRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (amfRegistration != null) {
			clearCache(amfRegistration);
		}

		return amfRegistration;
	}

	@Override
	public AmfRegistration updateImpl(AmfRegistration amfRegistration) {
		amfRegistration = toUnwrappedModel(amfRegistration);

		boolean isNew = amfRegistration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (amfRegistration.isNew()) {
				session.save(amfRegistration);

				amfRegistration.setNew(false);
			}
			else {
				amfRegistration = (AmfRegistration)session.merge(amfRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationImpl.class, amfRegistration.getPrimaryKey(),
			amfRegistration, false);

		amfRegistration.resetOriginalValues();

		return amfRegistration;
	}

	protected AmfRegistration toUnwrappedModel(AmfRegistration amfRegistration) {
		if (amfRegistration instanceof AmfRegistrationImpl) {
			return amfRegistration;
		}

		AmfRegistrationImpl amfRegistrationImpl = new AmfRegistrationImpl();

		amfRegistrationImpl.setNew(amfRegistration.isNew());
		amfRegistrationImpl.setPrimaryKey(amfRegistration.getPrimaryKey());

		amfRegistrationImpl.setDummy(amfRegistration.getDummy());

		return amfRegistrationImpl;
	}

	/**
	 * Returns the amf registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf registration
	 * @return the amf registration
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAmfRegistrationException {
		AmfRegistration amfRegistration = fetchByPrimaryKey(primaryKey);

		if (amfRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAmfRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return amfRegistration;
	}

	/**
	 * Returns the amf registration with the primary key or throws a {@link NoSuchAmfRegistrationException} if it could not be found.
	 *
	 * @param dummy the primary key of the amf registration
	 * @return the amf registration
	 * @throws NoSuchAmfRegistrationException if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration findByPrimaryKey(long dummy)
		throws NoSuchAmfRegistrationException {
		return findByPrimaryKey((Serializable)dummy);
	}

	/**
	 * Returns the amf registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf registration
	 * @return the amf registration, or <code>null</code> if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				AmfRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AmfRegistration amfRegistration = (AmfRegistration)serializable;

		if (amfRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				amfRegistration = (AmfRegistration)session.get(AmfRegistrationImpl.class,
						primaryKey);

				if (amfRegistration != null) {
					cacheResult(amfRegistration);
				}
				else {
					entityCache.putResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						AmfRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					AmfRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return amfRegistration;
	}

	/**
	 * Returns the amf registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dummy the primary key of the amf registration
	 * @return the amf registration, or <code>null</code> if a amf registration with the primary key could not be found
	 */
	@Override
	public AmfRegistration fetchByPrimaryKey(long dummy) {
		return fetchByPrimaryKey((Serializable)dummy);
	}

	@Override
	public Map<Serializable, AmfRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AmfRegistration> map = new HashMap<Serializable, AmfRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AmfRegistration amfRegistration = fetchByPrimaryKey(primaryKey);

			if (amfRegistration != null) {
				map.put(primaryKey, amfRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					AmfRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AmfRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AMFREGISTRATION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (AmfRegistration amfRegistration : (List<AmfRegistration>)q.list()) {
				map.put(amfRegistration.getPrimaryKeyObj(), amfRegistration);

				cacheResult(amfRegistration);

				uncachedPrimaryKeys.remove(amfRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AmfRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					AmfRegistrationImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the amf registrations.
	 *
	 * @return the amf registrations
	 */
	@Override
	public List<AmfRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registrations
	 * @param end the upper bound of the range of amf registrations (not inclusive)
	 * @return the range of amf registrations
	 */
	@Override
	public List<AmfRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registrations
	 * @param end the upper bound of the range of amf registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf registrations
	 */
	@Override
	public List<AmfRegistration> findAll(int start, int end,
		OrderByComparator<AmfRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amf registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registrations
	 * @param end the upper bound of the range of amf registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of amf registrations
	 */
	@Override
	public List<AmfRegistration> findAll(int start, int end,
		OrderByComparator<AmfRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AmfRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AMFREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AMFREGISTRATION;

				if (pagination) {
					sql = sql.concat(AmfRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AmfRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the amf registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AmfRegistration amfRegistration : findAll()) {
			remove(amfRegistration);
		}
	}

	/**
	 * Returns the number of amf registrations.
	 *
	 * @return the number of amf registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AMFREGISTRATION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AmfRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AmfRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AMFREGISTRATION = "SELECT amfRegistration FROM AmfRegistration amfRegistration";
	private static final String _SQL_SELECT_AMFREGISTRATION_WHERE_PKS_IN = "SELECT amfRegistration FROM AmfRegistration amfRegistration WHERE dummy IN (";
	private static final String _SQL_COUNT_AMFREGISTRATION = "SELECT COUNT(amfRegistration) FROM AmfRegistration amfRegistration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "amfRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AmfRegistration exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(AmfRegistrationPersistenceImpl.class);
}