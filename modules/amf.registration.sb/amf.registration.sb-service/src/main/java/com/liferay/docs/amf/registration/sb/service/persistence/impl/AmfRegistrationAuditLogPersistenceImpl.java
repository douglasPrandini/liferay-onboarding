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

import com.liferay.docs.amf.registration.sb.exception.NoSuchAmfRegistrationAuditLogException;
import com.liferay.docs.amf.registration.sb.model.AmfRegistrationAuditLog;
import com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogImpl;
import com.liferay.docs.amf.registration.sb.model.impl.AmfRegistrationAuditLogModelImpl;
import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationAuditLogPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the amf registration audit log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationAuditLogPersistence
 * @see com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationAuditLogUtil
 * @generated
 */
@ProviderType
public class AmfRegistrationAuditLogPersistenceImpl extends BasePersistenceImpl<AmfRegistrationAuditLog>
	implements AmfRegistrationAuditLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AmfRegistrationAuditLogUtil} to access the amf registration audit log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AmfRegistrationAuditLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuser_id",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuser_id",
			new String[] { Long.class.getName() },
			AmfRegistrationAuditLogModelImpl.USER_ID_COLUMN_BITMASK |
			AmfRegistrationAuditLogModelImpl.ACTION_TIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_ID = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuser_id",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the amf registration audit logs where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByuser_id(long user_id) {
		return findByuser_id(user_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registration audit logs where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByuser_id(long user_id, int start,
		int end) {
		return findByuser_id(user_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByuser_id(long user_id, int start,
		int end, OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return findByuser_id(user_id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByuser_id(long user_id, int start,
		int end, OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID;
			finderArgs = new Object[] { user_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID;
			finderArgs = new Object[] { user_id, start, end, orderByComparator };
		}

		List<AmfRegistrationAuditLog> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistrationAuditLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfRegistrationAuditLog amfRegistrationAuditLog : list) {
					if ((user_id != amfRegistrationAuditLog.getUser_id())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

				if (!pagination) {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
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
	 * Returns the first amf registration audit log in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByuser_id_First(long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByuser_id_First(user_id,
				orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the first amf registration audit log in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByuser_id_First(long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		List<AmfRegistrationAuditLog> list = findByuser_id(user_id, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByuser_id_Last(long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByuser_id_Last(user_id,
				orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByuser_id_Last(long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		int count = countByuser_id(user_id);

		if (count == 0) {
			return null;
		}

		List<AmfRegistrationAuditLog> list = findByuser_id(user_id, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where user_id = &#63;.
	 *
	 * @param id the primary key of the current amf registration audit log
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog[] findByuser_id_PrevAndNext(long id,
		long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AmfRegistrationAuditLog[] array = new AmfRegistrationAuditLogImpl[3];

			array[0] = getByuser_id_PrevAndNext(session,
					amfRegistrationAuditLog, user_id, orderByComparator, true);

			array[1] = amfRegistrationAuditLog;

			array[2] = getByuser_id_PrevAndNext(session,
					amfRegistrationAuditLog, user_id, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfRegistrationAuditLog getByuser_id_PrevAndNext(
		Session session, AmfRegistrationAuditLog amfRegistrationAuditLog,
		long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

		query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(user_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfRegistrationAuditLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AmfRegistrationAuditLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf registration audit logs where user_id = &#63; from the database.
	 *
	 * @param user_id the user_id
	 */
	@Override
	public void removeByuser_id(long user_id) {
		for (AmfRegistrationAuditLog amfRegistrationAuditLog : findByuser_id(
				user_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(amfRegistrationAuditLog);
		}
	}

	/**
	 * Returns the number of amf registration audit logs where user_id = &#63;.
	 *
	 * @param user_id the user_id
	 * @return the number of matching amf registration audit logs
	 */
	@Override
	public int countByuser_id(long user_id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_ID;

		Object[] finderArgs = new Object[] { user_id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFREGISTRATIONAUDITLOG_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(user_id);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USER_ID_USER_ID_2 = "amfRegistrationAuditLog.user_id = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCREEN_NAME =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByscreen_name",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREEN_NAME =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByscreen_name",
			new String[] { String.class.getName() },
			AmfRegistrationAuditLogModelImpl.SCREEN_NAME_COLUMN_BITMASK |
			AmfRegistrationAuditLogModelImpl.ACTION_TIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCREEN_NAME = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByscreen_name",
			new String[] { String.class.getName() });

	/**
	 * Returns all the amf registration audit logs where screen_name = &#63;.
	 *
	 * @param screen_name the screen_name
	 * @return the matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByscreen_name(String screen_name) {
		return findByscreen_name(screen_name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registration audit logs where screen_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screen_name the screen_name
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByscreen_name(String screen_name,
		int start, int end) {
		return findByscreen_name(screen_name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where screen_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screen_name the screen_name
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByscreen_name(String screen_name,
		int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return findByscreen_name(screen_name, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where screen_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param screen_name the screen_name
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByscreen_name(String screen_name,
		int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREEN_NAME;
			finderArgs = new Object[] { screen_name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCREEN_NAME;
			finderArgs = new Object[] { screen_name, start, end, orderByComparator };
		}

		List<AmfRegistrationAuditLog> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistrationAuditLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfRegistrationAuditLog amfRegistrationAuditLog : list) {
					if (!Objects.equals(screen_name,
								amfRegistrationAuditLog.getScreen_name())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

			boolean bindScreen_name = false;

			if (screen_name == null) {
				query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_1);
			}
			else if (screen_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_3);
			}
			else {
				bindScreen_name = true;

				query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreen_name) {
					qPos.add(screen_name);
				}

				if (!pagination) {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
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
	 * Returns the first amf registration audit log in the ordered set where screen_name = &#63;.
	 *
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByscreen_name_First(String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByscreen_name_First(screen_name,
				orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screen_name=");
		msg.append(screen_name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the first amf registration audit log in the ordered set where screen_name = &#63;.
	 *
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByscreen_name_First(
		String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		List<AmfRegistrationAuditLog> list = findByscreen_name(screen_name, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where screen_name = &#63;.
	 *
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByscreen_name_Last(String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByscreen_name_Last(screen_name,
				orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("screen_name=");
		msg.append(screen_name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where screen_name = &#63;.
	 *
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByscreen_name_Last(String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		int count = countByscreen_name(screen_name);

		if (count == 0) {
			return null;
		}

		List<AmfRegistrationAuditLog> list = findByscreen_name(screen_name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where screen_name = &#63;.
	 *
	 * @param id the primary key of the current amf registration audit log
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog[] findByscreen_name_PrevAndNext(long id,
		String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AmfRegistrationAuditLog[] array = new AmfRegistrationAuditLogImpl[3];

			array[0] = getByscreen_name_PrevAndNext(session,
					amfRegistrationAuditLog, screen_name, orderByComparator,
					true);

			array[1] = amfRegistrationAuditLog;

			array[2] = getByscreen_name_PrevAndNext(session,
					amfRegistrationAuditLog, screen_name, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfRegistrationAuditLog getByscreen_name_PrevAndNext(
		Session session, AmfRegistrationAuditLog amfRegistrationAuditLog,
		String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

		boolean bindScreen_name = false;

		if (screen_name == null) {
			query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_1);
		}
		else if (screen_name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_3);
		}
		else {
			bindScreen_name = true;

			query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScreen_name) {
			qPos.add(screen_name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfRegistrationAuditLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AmfRegistrationAuditLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf registration audit logs where screen_name = &#63; from the database.
	 *
	 * @param screen_name the screen_name
	 */
	@Override
	public void removeByscreen_name(String screen_name) {
		for (AmfRegistrationAuditLog amfRegistrationAuditLog : findByscreen_name(
				screen_name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(amfRegistrationAuditLog);
		}
	}

	/**
	 * Returns the number of amf registration audit logs where screen_name = &#63;.
	 *
	 * @param screen_name the screen_name
	 * @return the number of matching amf registration audit logs
	 */
	@Override
	public int countByscreen_name(String screen_name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCREEN_NAME;

		Object[] finderArgs = new Object[] { screen_name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFREGISTRATIONAUDITLOG_WHERE);

			boolean bindScreen_name = false;

			if (screen_name == null) {
				query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_1);
			}
			else if (screen_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_3);
			}
			else {
				bindScreen_name = true;

				query.append(_FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreen_name) {
					qPos.add(screen_name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_1 = "amfRegistrationAuditLog.screen_name IS NULL";
	private static final String _FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_2 = "amfRegistrationAuditLog.screen_name = ?";
	private static final String _FINDER_COLUMN_SCREEN_NAME_SCREEN_NAME_3 = "(amfRegistrationAuditLog.screen_name IS NULL OR amfRegistrationAuditLog.screen_name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENT_TYPE =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByevent_type",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT_TYPE =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByevent_type",
			new String[] { String.class.getName() },
			AmfRegistrationAuditLogModelImpl.EVENT_TYPE_COLUMN_BITMASK |
			AmfRegistrationAuditLogModelImpl.ACTION_TIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENT_TYPE = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByevent_type",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENT_TYPE =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByevent_type",
			new String[] { String.class.getName() });

	/**
	 * Returns all the amf registration audit logs where event_type = &#63;.
	 *
	 * @param event_type the event_type
	 * @return the matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByevent_type(String event_type) {
		return findByevent_type(event_type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registration audit logs where event_type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByevent_type(String event_type,
		int start, int end) {
		return findByevent_type(event_type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByevent_type(String event_type,
		int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return findByevent_type(event_type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByevent_type(String event_type,
		int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT_TYPE;
			finderArgs = new Object[] { event_type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENT_TYPE;
			finderArgs = new Object[] { event_type, start, end, orderByComparator };
		}

		List<AmfRegistrationAuditLog> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistrationAuditLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfRegistrationAuditLog amfRegistrationAuditLog : list) {
					if (!Objects.equals(event_type,
								amfRegistrationAuditLog.getEvent_type())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

			boolean bindEvent_type = false;

			if (event_type == null) {
				query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_1);
			}
			else if (event_type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_3);
			}
			else {
				bindEvent_type = true;

				query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEvent_type) {
					qPos.add(event_type);
				}

				if (!pagination) {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
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
	 * Returns the first amf registration audit log in the ordered set where event_type = &#63;.
	 *
	 * @param event_type the event_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByevent_type_First(String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByevent_type_First(event_type,
				orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("event_type=");
		msg.append(event_type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the first amf registration audit log in the ordered set where event_type = &#63;.
	 *
	 * @param event_type the event_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByevent_type_First(String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		List<AmfRegistrationAuditLog> list = findByevent_type(event_type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where event_type = &#63;.
	 *
	 * @param event_type the event_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByevent_type_Last(String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByevent_type_Last(event_type,
				orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("event_type=");
		msg.append(event_type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where event_type = &#63;.
	 *
	 * @param event_type the event_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByevent_type_Last(String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		int count = countByevent_type(event_type);

		if (count == 0) {
			return null;
		}

		List<AmfRegistrationAuditLog> list = findByevent_type(event_type,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where event_type = &#63;.
	 *
	 * @param id the primary key of the current amf registration audit log
	 * @param event_type the event_type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog[] findByevent_type_PrevAndNext(long id,
		String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AmfRegistrationAuditLog[] array = new AmfRegistrationAuditLogImpl[3];

			array[0] = getByevent_type_PrevAndNext(session,
					amfRegistrationAuditLog, event_type, orderByComparator, true);

			array[1] = amfRegistrationAuditLog;

			array[2] = getByevent_type_PrevAndNext(session,
					amfRegistrationAuditLog, event_type, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfRegistrationAuditLog getByevent_type_PrevAndNext(
		Session session, AmfRegistrationAuditLog amfRegistrationAuditLog,
		String event_type,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

		boolean bindEvent_type = false;

		if (event_type == null) {
			query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_1);
		}
		else if (event_type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_3);
		}
		else {
			bindEvent_type = true;

			query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEvent_type) {
			qPos.add(event_type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfRegistrationAuditLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AmfRegistrationAuditLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the amf registration audit logs where event_type = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_types the event_types
	 * @return the matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByevent_type(String[] event_types) {
		return findByevent_type(event_types, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registration audit logs where event_type = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_types the event_types
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByevent_type(
		String[] event_types, int start, int end) {
		return findByevent_type(event_types, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_types the event_types
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByevent_type(
		String[] event_types, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return findByevent_type(event_types, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByevent_type(
		String[] event_types, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		if (event_types == null) {
			event_types = new String[0];
		}
		else if (event_types.length > 1) {
			event_types = ArrayUtil.distinct(event_types,
					NULL_SAFE_STRING_COMPARATOR);

			Arrays.sort(event_types, NULL_SAFE_STRING_COMPARATOR);
		}

		if (event_types.length == 1) {
			return findByevent_type(event_types[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(event_types) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(event_types),
					
					start, end, orderByComparator
				};
		}

		List<AmfRegistrationAuditLog> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistrationAuditLog>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENT_TYPE,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfRegistrationAuditLog amfRegistrationAuditLog : list) {
					if (!ArrayUtil.contains(event_types,
								amfRegistrationAuditLog.getEvent_type())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

			if (event_types.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < event_types.length; i++) {
					String event_type = event_types[i];

					if (event_type == null) {
						query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_1);
					}
					else if (event_type.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_3);
					}
					else {
						query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_2);
					}

					if ((i + 1) < event_types.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				for (String event_type : event_types) {
					if ((event_type != null) && !event_type.isEmpty()) {
						qPos.add(event_type);
					}
				}

				if (!pagination) {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENT_TYPE,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENT_TYPE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the amf registration audit logs where event_type = &#63; from the database.
	 *
	 * @param event_type the event_type
	 */
	@Override
	public void removeByevent_type(String event_type) {
		for (AmfRegistrationAuditLog amfRegistrationAuditLog : findByevent_type(
				event_type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(amfRegistrationAuditLog);
		}
	}

	/**
	 * Returns the number of amf registration audit logs where event_type = &#63;.
	 *
	 * @param event_type the event_type
	 * @return the number of matching amf registration audit logs
	 */
	@Override
	public int countByevent_type(String event_type) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENT_TYPE;

		Object[] finderArgs = new Object[] { event_type };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFREGISTRATIONAUDITLOG_WHERE);

			boolean bindEvent_type = false;

			if (event_type == null) {
				query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_1);
			}
			else if (event_type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_3);
			}
			else {
				bindEvent_type = true;

				query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEvent_type) {
					qPos.add(event_type);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of amf registration audit logs where event_type = any &#63;.
	 *
	 * @param event_types the event_types
	 * @return the number of matching amf registration audit logs
	 */
	@Override
	public int countByevent_type(String[] event_types) {
		if (event_types == null) {
			event_types = new String[0];
		}
		else if (event_types.length > 1) {
			event_types = ArrayUtil.distinct(event_types,
					NULL_SAFE_STRING_COMPARATOR);

			Arrays.sort(event_types, NULL_SAFE_STRING_COMPARATOR);
		}

		Object[] finderArgs = new Object[] { StringUtil.merge(event_types) };

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENT_TYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_AMFREGISTRATIONAUDITLOG_WHERE);

			if (event_types.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < event_types.length; i++) {
					String event_type = event_types[i];

					if (event_type == null) {
						query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_1);
					}
					else if (event_type.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_3);
					}
					else {
						query.append(_FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_2);
					}

					if ((i + 1) < event_types.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				for (String event_type : event_types) {
					if ((event_type != null) && !event_type.isEmpty()) {
						qPos.add(event_type);
					}
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENT_TYPE,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENT_TYPE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_1 = "amfRegistrationAuditLog.event_type IS NULL";
	private static final String _FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_2 = "amfRegistrationAuditLog.event_type = ?";
	private static final String _FINDER_COLUMN_EVENT_TYPE_EVENT_TYPE_3 = "(amfRegistrationAuditLog.event_type IS NULL OR amfRegistrationAuditLog.event_type = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPEANDUSERNAME =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEventTypeAndUserName",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERNAME =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEventTypeAndUserName",
			new String[] { String.class.getName(), String.class.getName() },
			AmfRegistrationAuditLogModelImpl.EVENT_TYPE_COLUMN_BITMASK |
			AmfRegistrationAuditLogModelImpl.SCREEN_NAME_COLUMN_BITMASK |
			AmfRegistrationAuditLogModelImpl.ACTION_TIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERNAME = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEventTypeAndUserName",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @return the matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		String event_type, String screen_name) {
		return findByEventTypeAndUserName(event_type, screen_name,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		String event_type, String screen_name, int start, int end) {
		return findByEventTypeAndUserName(event_type, screen_name, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		String event_type, String screen_name, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return findByEventTypeAndUserName(event_type, screen_name, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserName(
		String event_type, String screen_name, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERNAME;
			finderArgs = new Object[] { event_type, screen_name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPEANDUSERNAME;
			finderArgs = new Object[] {
					event_type, screen_name,
					
					start, end, orderByComparator
				};
		}

		List<AmfRegistrationAuditLog> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistrationAuditLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfRegistrationAuditLog amfRegistrationAuditLog : list) {
					if (!Objects.equals(event_type,
								amfRegistrationAuditLog.getEvent_type()) ||
							!Objects.equals(screen_name,
								amfRegistrationAuditLog.getScreen_name())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

			boolean bindEvent_type = false;

			if (event_type == null) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_1);
			}
			else if (event_type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_3);
			}
			else {
				bindEvent_type = true;

				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_2);
			}

			boolean bindScreen_name = false;

			if (screen_name == null) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_1);
			}
			else if (screen_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_3);
			}
			else {
				bindScreen_name = true;

				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEvent_type) {
					qPos.add(event_type);
				}

				if (bindScreen_name) {
					qPos.add(screen_name);
				}

				if (!pagination) {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
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
	 * Returns the first amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByEventTypeAndUserName_First(
		String event_type, String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByEventTypeAndUserName_First(event_type,
				screen_name, orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("event_type=");
		msg.append(event_type);

		msg.append(", screen_name=");
		msg.append(screen_name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the first amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByEventTypeAndUserName_First(
		String event_type, String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		List<AmfRegistrationAuditLog> list = findByEventTypeAndUserName(event_type,
				screen_name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByEventTypeAndUserName_Last(
		String event_type, String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByEventTypeAndUserName_Last(event_type,
				screen_name, orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("event_type=");
		msg.append(event_type);

		msg.append(", screen_name=");
		msg.append(screen_name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByEventTypeAndUserName_Last(
		String event_type, String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		int count = countByEventTypeAndUserName(event_type, screen_name);

		if (count == 0) {
			return null;
		}

		List<AmfRegistrationAuditLog> list = findByEventTypeAndUserName(event_type,
				screen_name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where event_type = &#63; and screen_name = &#63;.
	 *
	 * @param id the primary key of the current amf registration audit log
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog[] findByEventTypeAndUserName_PrevAndNext(
		long id, String event_type, String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AmfRegistrationAuditLog[] array = new AmfRegistrationAuditLogImpl[3];

			array[0] = getByEventTypeAndUserName_PrevAndNext(session,
					amfRegistrationAuditLog, event_type, screen_name,
					orderByComparator, true);

			array[1] = amfRegistrationAuditLog;

			array[2] = getByEventTypeAndUserName_PrevAndNext(session,
					amfRegistrationAuditLog, event_type, screen_name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfRegistrationAuditLog getByEventTypeAndUserName_PrevAndNext(
		Session session, AmfRegistrationAuditLog amfRegistrationAuditLog,
		String event_type, String screen_name,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

		boolean bindEvent_type = false;

		if (event_type == null) {
			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_1);
		}
		else if (event_type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_3);
		}
		else {
			bindEvent_type = true;

			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_2);
		}

		boolean bindScreen_name = false;

		if (screen_name == null) {
			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_1);
		}
		else if (screen_name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_3);
		}
		else {
			bindScreen_name = true;

			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEvent_type) {
			qPos.add(event_type);
		}

		if (bindScreen_name) {
			qPos.add(screen_name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfRegistrationAuditLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AmfRegistrationAuditLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf registration audit logs where event_type = &#63; and screen_name = &#63; from the database.
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 */
	@Override
	public void removeByEventTypeAndUserName(String event_type,
		String screen_name) {
		for (AmfRegistrationAuditLog amfRegistrationAuditLog : findByEventTypeAndUserName(
				event_type, screen_name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(amfRegistrationAuditLog);
		}
	}

	/**
	 * Returns the number of amf registration audit logs where event_type = &#63; and screen_name = &#63;.
	 *
	 * @param event_type the event_type
	 * @param screen_name the screen_name
	 * @return the number of matching amf registration audit logs
	 */
	@Override
	public int countByEventTypeAndUserName(String event_type, String screen_name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERNAME;

		Object[] finderArgs = new Object[] { event_type, screen_name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AMFREGISTRATIONAUDITLOG_WHERE);

			boolean bindEvent_type = false;

			if (event_type == null) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_1);
			}
			else if (event_type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_3);
			}
			else {
				bindEvent_type = true;

				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_2);
			}

			boolean bindScreen_name = false;

			if (screen_name == null) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_1);
			}
			else if (screen_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_3);
			}
			else {
				bindScreen_name = true;

				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEvent_type) {
					qPos.add(event_type);
				}

				if (bindScreen_name) {
					qPos.add(screen_name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_1 =
		"amfRegistrationAuditLog.event_type IS NULL AND ";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_2 =
		"amfRegistrationAuditLog.event_type = ? AND ";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERNAME_EVENT_TYPE_3 =
		"(amfRegistrationAuditLog.event_type IS NULL OR amfRegistrationAuditLog.event_type = '') AND ";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_1 =
		"amfRegistrationAuditLog.screen_name IS NULL";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_2 =
		"amfRegistrationAuditLog.screen_name = ?";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERNAME_SCREEN_NAME_3 =
		"(amfRegistrationAuditLog.screen_name IS NULL OR amfRegistrationAuditLog.screen_name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPEANDUSERID =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventTypeAndUserId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERID =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEventTypeAndUserId",
			new String[] { String.class.getName(), Long.class.getName() },
			AmfRegistrationAuditLogModelImpl.EVENT_TYPE_COLUMN_BITMASK |
			AmfRegistrationAuditLogModelImpl.USER_ID_COLUMN_BITMASK |
			AmfRegistrationAuditLogModelImpl.ACTION_TIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERID = new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEventTypeAndUserId",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENTTYPEANDUSERID =
		new FinderPath(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByEventTypeAndUserId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @return the matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		String event_type, long user_id) {
		return findByEventTypeAndUserId(event_type, user_id, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		String event_type, long user_id, int start, int end) {
		return findByEventTypeAndUserId(event_type, user_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		String event_type, long user_id, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return findByEventTypeAndUserId(event_type, user_id, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = &#63; and user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		String event_type, long user_id, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERID;
			finderArgs = new Object[] { event_type, user_id };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPEANDUSERID;
			finderArgs = new Object[] {
					event_type, user_id,
					
					start, end, orderByComparator
				};
		}

		List<AmfRegistrationAuditLog> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistrationAuditLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfRegistrationAuditLog amfRegistrationAuditLog : list) {
					if (!Objects.equals(event_type,
								amfRegistrationAuditLog.getEvent_type()) ||
							(user_id != amfRegistrationAuditLog.getUser_id())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

			boolean bindEvent_type = false;

			if (event_type == null) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_1);
			}
			else if (event_type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_3);
			}
			else {
				bindEvent_type = true;

				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_2);
			}

			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEvent_type) {
					qPos.add(event_type);
				}

				qPos.add(user_id);

				if (!pagination) {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
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
	 * Returns the first amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByEventTypeAndUserId_First(
		String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByEventTypeAndUserId_First(event_type,
				user_id, orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("event_type=");
		msg.append(event_type);

		msg.append(", user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the first amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByEventTypeAndUserId_First(
		String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		List<AmfRegistrationAuditLog> list = findByEventTypeAndUserId(event_type,
				user_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByEventTypeAndUserId_Last(
		String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByEventTypeAndUserId_Last(event_type,
				user_id, orderByComparator);

		if (amfRegistrationAuditLog != null) {
			return amfRegistrationAuditLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("event_type=");
		msg.append(event_type);

		msg.append(", user_id=");
		msg.append(user_id);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAmfRegistrationAuditLogException(msg.toString());
	}

	/**
	 * Returns the last amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf registration audit log, or <code>null</code> if a matching amf registration audit log could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByEventTypeAndUserId_Last(
		String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		int count = countByEventTypeAndUserId(event_type, user_id);

		if (count == 0) {
			return null;
		}

		List<AmfRegistrationAuditLog> list = findByEventTypeAndUserId(event_type,
				user_id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf registration audit logs before and after the current amf registration audit log in the ordered set where event_type = &#63; and user_id = &#63;.
	 *
	 * @param id the primary key of the current amf registration audit log
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog[] findByEventTypeAndUserId_PrevAndNext(
		long id, String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			AmfRegistrationAuditLog[] array = new AmfRegistrationAuditLogImpl[3];

			array[0] = getByEventTypeAndUserId_PrevAndNext(session,
					amfRegistrationAuditLog, event_type, user_id,
					orderByComparator, true);

			array[1] = amfRegistrationAuditLog;

			array[2] = getByEventTypeAndUserId_PrevAndNext(session,
					amfRegistrationAuditLog, event_type, user_id,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfRegistrationAuditLog getByEventTypeAndUserId_PrevAndNext(
		Session session, AmfRegistrationAuditLog amfRegistrationAuditLog,
		String event_type, long user_id,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

		boolean bindEvent_type = false;

		if (event_type == null) {
			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_1);
		}
		else if (event_type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_3);
		}
		else {
			bindEvent_type = true;

			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_2);
		}

		query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_USER_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEvent_type) {
			qPos.add(event_type);
		}

		qPos.add(user_id);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfRegistrationAuditLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AmfRegistrationAuditLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_types the event_types
	 * @param user_id the user_id
	 * @return the matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		String[] event_types, long user_id) {
		return findByEventTypeAndUserId(event_types, user_id,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_types the event_types
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		String[] event_types, long user_id, int start, int end) {
		return findByEventTypeAndUserId(event_types, user_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_types the event_types
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		String[] event_types, long user_id, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return findByEventTypeAndUserId(event_types, user_id, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs where event_type = &#63; and user_id = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findByEventTypeAndUserId(
		String[] event_types, long user_id, int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
		boolean retrieveFromCache) {
		if (event_types == null) {
			event_types = new String[0];
		}
		else if (event_types.length > 1) {
			event_types = ArrayUtil.distinct(event_types,
					NULL_SAFE_STRING_COMPARATOR);

			Arrays.sort(event_types, NULL_SAFE_STRING_COMPARATOR);
		}

		if (event_types.length == 1) {
			return findByEventTypeAndUserId(event_types[0], user_id, start,
				end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(event_types), user_id };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(event_types), user_id,
					
					start, end, orderByComparator
				};
		}

		List<AmfRegistrationAuditLog> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistrationAuditLog>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPEANDUSERID,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfRegistrationAuditLog amfRegistrationAuditLog : list) {
					if (!ArrayUtil.contains(event_types,
								amfRegistrationAuditLog.getEvent_type()) ||
							(user_id != amfRegistrationAuditLog.getUser_id())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE);

			if (event_types.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < event_types.length; i++) {
					String event_type = event_types[i];

					if (event_type == null) {
						query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_4);
					}
					else if (event_type.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_6);
					}
					else {
						query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_5);
					}

					if ((i + 1) < event_types.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_USER_ID_2);

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				for (String event_type : event_types) {
					if ((event_type != null) && !event_type.isEmpty()) {
						qPos.add(event_type);
					}
				}

				qPos.add(user_id);

				if (!pagination) {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPEANDUSERID,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPEANDUSERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the amf registration audit logs where event_type = &#63; and user_id = &#63; from the database.
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 */
	@Override
	public void removeByEventTypeAndUserId(String event_type, long user_id) {
		for (AmfRegistrationAuditLog amfRegistrationAuditLog : findByEventTypeAndUserId(
				event_type, user_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(amfRegistrationAuditLog);
		}
	}

	/**
	 * Returns the number of amf registration audit logs where event_type = &#63; and user_id = &#63;.
	 *
	 * @param event_type the event_type
	 * @param user_id the user_id
	 * @return the number of matching amf registration audit logs
	 */
	@Override
	public int countByEventTypeAndUserId(String event_type, long user_id) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERID;

		Object[] finderArgs = new Object[] { event_type, user_id };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AMFREGISTRATIONAUDITLOG_WHERE);

			boolean bindEvent_type = false;

			if (event_type == null) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_1);
			}
			else if (event_type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_3);
			}
			else {
				bindEvent_type = true;

				query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_2);
			}

			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEvent_type) {
					qPos.add(event_type);
				}

				qPos.add(user_id);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of amf registration audit logs where event_type = any &#63; and user_id = &#63;.
	 *
	 * @param event_types the event_types
	 * @param user_id the user_id
	 * @return the number of matching amf registration audit logs
	 */
	@Override
	public int countByEventTypeAndUserId(String[] event_types, long user_id) {
		if (event_types == null) {
			event_types = new String[0];
		}
		else if (event_types.length > 1) {
			event_types = ArrayUtil.distinct(event_types,
					NULL_SAFE_STRING_COMPARATOR);

			Arrays.sort(event_types, NULL_SAFE_STRING_COMPARATOR);
		}

		Object[] finderArgs = new Object[] {
				StringUtil.merge(event_types), user_id
			};

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENTTYPEANDUSERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_AMFREGISTRATIONAUDITLOG_WHERE);

			if (event_types.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < event_types.length; i++) {
					String event_type = event_types[i];

					if (event_type == null) {
						query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_4);
					}
					else if (event_type.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_6);
					}
					else {
						query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_5);
					}

					if ((i + 1) < event_types.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_EVENTTYPEANDUSERID_USER_ID_2);

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				for (String event_type : event_types) {
					if ((event_type != null) && !event_type.isEmpty()) {
						qPos.add(event_type);
					}
				}

				qPos.add(user_id);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENTTYPEANDUSERID,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENTTYPEANDUSERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_1 = "amfRegistrationAuditLog.event_type IS NULL AND ";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_2 = "amfRegistrationAuditLog.event_type = ? AND ";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_3 = "(amfRegistrationAuditLog.event_type IS NULL OR amfRegistrationAuditLog.event_type = '') AND ";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_4 = "(" +
		removeConjunction(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_1) +
		")";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_2) +
		")";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_6 = "(" +
		removeConjunction(_FINDER_COLUMN_EVENTTYPEANDUSERID_EVENT_TYPE_3) +
		")";
	private static final String _FINDER_COLUMN_EVENTTYPEANDUSERID_USER_ID_2 = "amfRegistrationAuditLog.user_id = ?";

	public AmfRegistrationAuditLogPersistenceImpl() {
		setModelClass(AmfRegistrationAuditLog.class);
	}

	/**
	 * Caches the amf registration audit log in the entity cache if it is enabled.
	 *
	 * @param amfRegistrationAuditLog the amf registration audit log
	 */
	@Override
	public void cacheResult(AmfRegistrationAuditLog amfRegistrationAuditLog) {
		entityCache.putResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			amfRegistrationAuditLog.getPrimaryKey(), amfRegistrationAuditLog);

		amfRegistrationAuditLog.resetOriginalValues();
	}

	/**
	 * Caches the amf registration audit logs in the entity cache if it is enabled.
	 *
	 * @param amfRegistrationAuditLogs the amf registration audit logs
	 */
	@Override
	public void cacheResult(
		List<AmfRegistrationAuditLog> amfRegistrationAuditLogs) {
		for (AmfRegistrationAuditLog amfRegistrationAuditLog : amfRegistrationAuditLogs) {
			if (entityCache.getResult(
						AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
						AmfRegistrationAuditLogImpl.class,
						amfRegistrationAuditLog.getPrimaryKey()) == null) {
				cacheResult(amfRegistrationAuditLog);
			}
			else {
				amfRegistrationAuditLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all amf registration audit logs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmfRegistrationAuditLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf registration audit log.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AmfRegistrationAuditLog amfRegistrationAuditLog) {
		entityCache.removeResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			amfRegistrationAuditLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<AmfRegistrationAuditLog> amfRegistrationAuditLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AmfRegistrationAuditLog amfRegistrationAuditLog : amfRegistrationAuditLogs) {
			entityCache.removeResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
				AmfRegistrationAuditLogImpl.class,
				amfRegistrationAuditLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new amf registration audit log with the primary key. Does not add the amf registration audit log to the database.
	 *
	 * @param id the primary key for the new amf registration audit log
	 * @return the new amf registration audit log
	 */
	@Override
	public AmfRegistrationAuditLog create(long id) {
		AmfRegistrationAuditLog amfRegistrationAuditLog = new AmfRegistrationAuditLogImpl();

		amfRegistrationAuditLog.setNew(true);
		amfRegistrationAuditLog.setPrimaryKey(id);

		return amfRegistrationAuditLog;
	}

	/**
	 * Removes the amf registration audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the amf registration audit log
	 * @return the amf registration audit log that was removed
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog remove(long id)
		throws NoSuchAmfRegistrationAuditLogException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the amf registration audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf registration audit log
	 * @return the amf registration audit log that was removed
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog remove(Serializable primaryKey)
		throws NoSuchAmfRegistrationAuditLogException {
		Session session = null;

		try {
			session = openSession();

			AmfRegistrationAuditLog amfRegistrationAuditLog = (AmfRegistrationAuditLog)session.get(AmfRegistrationAuditLogImpl.class,
					primaryKey);

			if (amfRegistrationAuditLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAmfRegistrationAuditLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(amfRegistrationAuditLog);
		}
		catch (NoSuchAmfRegistrationAuditLogException nsee) {
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
	protected AmfRegistrationAuditLog removeImpl(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		amfRegistrationAuditLog = toUnwrappedModel(amfRegistrationAuditLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfRegistrationAuditLog)) {
				amfRegistrationAuditLog = (AmfRegistrationAuditLog)session.get(AmfRegistrationAuditLogImpl.class,
						amfRegistrationAuditLog.getPrimaryKeyObj());
			}

			if (amfRegistrationAuditLog != null) {
				session.delete(amfRegistrationAuditLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (amfRegistrationAuditLog != null) {
			clearCache(amfRegistrationAuditLog);
		}

		return amfRegistrationAuditLog;
	}

	@Override
	public AmfRegistrationAuditLog updateImpl(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		amfRegistrationAuditLog = toUnwrappedModel(amfRegistrationAuditLog);

		boolean isNew = amfRegistrationAuditLog.isNew();

		AmfRegistrationAuditLogModelImpl amfRegistrationAuditLogModelImpl = (AmfRegistrationAuditLogModelImpl)amfRegistrationAuditLog;

		Session session = null;

		try {
			session = openSession();

			if (amfRegistrationAuditLog.isNew()) {
				session.save(amfRegistrationAuditLog);

				amfRegistrationAuditLog.setNew(false);
			}
			else {
				amfRegistrationAuditLog = (AmfRegistrationAuditLog)session.merge(amfRegistrationAuditLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AmfRegistrationAuditLogModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					amfRegistrationAuditLogModelImpl.getUser_id()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
				args);

			args = new Object[] {
					amfRegistrationAuditLogModelImpl.getScreen_name()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREEN_NAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREEN_NAME,
				args);

			args = new Object[] { amfRegistrationAuditLogModelImpl.getEvent_type() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENT_TYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT_TYPE,
				args);

			args = new Object[] {
					amfRegistrationAuditLogModelImpl.getEvent_type(),
					amfRegistrationAuditLogModelImpl.getScreen_name()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERNAME,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERNAME,
				args);

			args = new Object[] {
					amfRegistrationAuditLogModelImpl.getEvent_type(),
					amfRegistrationAuditLogModelImpl.getUser_id()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((amfRegistrationAuditLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						amfRegistrationAuditLogModelImpl.getOriginalUser_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);

				args = new Object[] {
						amfRegistrationAuditLogModelImpl.getUser_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);
			}

			if ((amfRegistrationAuditLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREEN_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						amfRegistrationAuditLogModelImpl.getOriginalScreen_name()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREEN_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREEN_NAME,
					args);

				args = new Object[] {
						amfRegistrationAuditLogModelImpl.getScreen_name()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SCREEN_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCREEN_NAME,
					args);
			}

			if ((amfRegistrationAuditLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						amfRegistrationAuditLogModelImpl.getOriginalEvent_type()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENT_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT_TYPE,
					args);

				args = new Object[] {
						amfRegistrationAuditLogModelImpl.getEvent_type()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENT_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENT_TYPE,
					args);
			}

			if ((amfRegistrationAuditLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						amfRegistrationAuditLogModelImpl.getOriginalEvent_type(),
						amfRegistrationAuditLogModelImpl.getOriginalScreen_name()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERNAME,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERNAME,
					args);

				args = new Object[] {
						amfRegistrationAuditLogModelImpl.getEvent_type(),
						amfRegistrationAuditLogModelImpl.getScreen_name()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERNAME,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERNAME,
					args);
			}

			if ((amfRegistrationAuditLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						amfRegistrationAuditLogModelImpl.getOriginalEvent_type(),
						amfRegistrationAuditLogModelImpl.getOriginalUser_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERID,
					args);

				args = new Object[] {
						amfRegistrationAuditLogModelImpl.getEvent_type(),
						amfRegistrationAuditLogModelImpl.getUser_id()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPEANDUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPEANDUSERID,
					args);
			}
		}

		entityCache.putResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			AmfRegistrationAuditLogImpl.class,
			amfRegistrationAuditLog.getPrimaryKey(), amfRegistrationAuditLog,
			false);

		amfRegistrationAuditLog.resetOriginalValues();

		return amfRegistrationAuditLog;
	}

	protected AmfRegistrationAuditLog toUnwrappedModel(
		AmfRegistrationAuditLog amfRegistrationAuditLog) {
		if (amfRegistrationAuditLog instanceof AmfRegistrationAuditLogImpl) {
			return amfRegistrationAuditLog;
		}

		AmfRegistrationAuditLogImpl amfRegistrationAuditLogImpl = new AmfRegistrationAuditLogImpl();

		amfRegistrationAuditLogImpl.setNew(amfRegistrationAuditLog.isNew());
		amfRegistrationAuditLogImpl.setPrimaryKey(amfRegistrationAuditLog.getPrimaryKey());

		amfRegistrationAuditLogImpl.setId(amfRegistrationAuditLog.getId());
		amfRegistrationAuditLogImpl.setAction_time(amfRegistrationAuditLog.getAction_time());
		amfRegistrationAuditLogImpl.setScreen_name(amfRegistrationAuditLog.getScreen_name());
		amfRegistrationAuditLogImpl.setUser_id(amfRegistrationAuditLog.getUser_id());
		amfRegistrationAuditLogImpl.setIp_address(amfRegistrationAuditLog.getIp_address());
		amfRegistrationAuditLogImpl.setEvent_type(amfRegistrationAuditLog.getEvent_type());

		return amfRegistrationAuditLogImpl;
	}

	/**
	 * Returns the amf registration audit log with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf registration audit log
	 * @return the amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAmfRegistrationAuditLogException {
		AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByPrimaryKey(primaryKey);

		if (amfRegistrationAuditLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAmfRegistrationAuditLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return amfRegistrationAuditLog;
	}

	/**
	 * Returns the amf registration audit log with the primary key or throws a {@link NoSuchAmfRegistrationAuditLogException} if it could not be found.
	 *
	 * @param id the primary key of the amf registration audit log
	 * @return the amf registration audit log
	 * @throws NoSuchAmfRegistrationAuditLogException if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog findByPrimaryKey(long id)
		throws NoSuchAmfRegistrationAuditLogException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the amf registration audit log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf registration audit log
	 * @return the amf registration audit log, or <code>null</code> if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
				AmfRegistrationAuditLogImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AmfRegistrationAuditLog amfRegistrationAuditLog = (AmfRegistrationAuditLog)serializable;

		if (amfRegistrationAuditLog == null) {
			Session session = null;

			try {
				session = openSession();

				amfRegistrationAuditLog = (AmfRegistrationAuditLog)session.get(AmfRegistrationAuditLogImpl.class,
						primaryKey);

				if (amfRegistrationAuditLog != null) {
					cacheResult(amfRegistrationAuditLog);
				}
				else {
					entityCache.putResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
						AmfRegistrationAuditLogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
					AmfRegistrationAuditLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return amfRegistrationAuditLog;
	}

	/**
	 * Returns the amf registration audit log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the amf registration audit log
	 * @return the amf registration audit log, or <code>null</code> if a amf registration audit log with the primary key could not be found
	 */
	@Override
	public AmfRegistrationAuditLog fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, AmfRegistrationAuditLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AmfRegistrationAuditLog> map = new HashMap<Serializable, AmfRegistrationAuditLog>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AmfRegistrationAuditLog amfRegistrationAuditLog = fetchByPrimaryKey(primaryKey);

			if (amfRegistrationAuditLog != null) {
				map.put(primaryKey, amfRegistrationAuditLog);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
					AmfRegistrationAuditLogImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AmfRegistrationAuditLog)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE_PKS_IN);

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

			for (AmfRegistrationAuditLog amfRegistrationAuditLog : (List<AmfRegistrationAuditLog>)q.list()) {
				map.put(amfRegistrationAuditLog.getPrimaryKeyObj(),
					amfRegistrationAuditLog);

				cacheResult(amfRegistrationAuditLog);

				uncachedPrimaryKeys.remove(amfRegistrationAuditLog.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AmfRegistrationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
					AmfRegistrationAuditLogImpl.class, primaryKey, nullModel);
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
	 * Returns all the amf registration audit logs.
	 *
	 * @return the amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amf registration audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @return the range of amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findAll(int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amf registration audit logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AmfRegistrationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf registration audit logs
	 * @param end the upper bound of the range of amf registration audit logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of amf registration audit logs
	 */
	@Override
	public List<AmfRegistrationAuditLog> findAll(int start, int end,
		OrderByComparator<AmfRegistrationAuditLog> orderByComparator,
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

		List<AmfRegistrationAuditLog> list = null;

		if (retrieveFromCache) {
			list = (List<AmfRegistrationAuditLog>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AMFREGISTRATIONAUDITLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AMFREGISTRATIONAUDITLOG;

				if (pagination) {
					sql = sql.concat(AmfRegistrationAuditLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AmfRegistrationAuditLog>)QueryUtil.list(q,
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
	 * Removes all the amf registration audit logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AmfRegistrationAuditLog amfRegistrationAuditLog : findAll()) {
			remove(amfRegistrationAuditLog);
		}
	}

	/**
	 * Returns the number of amf registration audit logs.
	 *
	 * @return the number of amf registration audit logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AMFREGISTRATIONAUDITLOG);

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
		return AmfRegistrationAuditLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf registration audit log persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AmfRegistrationAuditLogImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AMFREGISTRATIONAUDITLOG = "SELECT amfRegistrationAuditLog FROM AmfRegistrationAuditLog amfRegistrationAuditLog";
	private static final String _SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE_PKS_IN =
		"SELECT amfRegistrationAuditLog FROM AmfRegistrationAuditLog amfRegistrationAuditLog WHERE id IN (";
	private static final String _SQL_SELECT_AMFREGISTRATIONAUDITLOG_WHERE = "SELECT amfRegistrationAuditLog FROM AmfRegistrationAuditLog amfRegistrationAuditLog WHERE ";
	private static final String _SQL_COUNT_AMFREGISTRATIONAUDITLOG = "SELECT COUNT(amfRegistrationAuditLog) FROM AmfRegistrationAuditLog amfRegistrationAuditLog";
	private static final String _SQL_COUNT_AMFREGISTRATIONAUDITLOG_WHERE = "SELECT COUNT(amfRegistrationAuditLog) FROM AmfRegistrationAuditLog amfRegistrationAuditLog WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "amfRegistrationAuditLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AmfRegistrationAuditLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AmfRegistrationAuditLog exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AmfRegistrationAuditLogPersistenceImpl.class);
}