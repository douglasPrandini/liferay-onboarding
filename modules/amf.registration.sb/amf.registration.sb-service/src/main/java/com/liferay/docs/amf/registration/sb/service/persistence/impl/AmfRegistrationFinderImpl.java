package com.liferay.docs.amf.registration.sb.service.persistence.impl;

import com.liferay.docs.amf.registration.sb.service.persistence.AmfRegistrationFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.math.BigInteger;
import java.util.List;

public class AmfRegistrationFinderImpl extends AmfRegistrationFinderBaseImpl
        implements AmfRegistrationFinder {

    public static final String FIND_USERS_BY_ZIP_CODE = "findUsersByZipCode";
    public static final String COUNT_USERS_BY_ZIP_CODE = "countUsersByZipCode";

    public List<Object[]> findByUsersByZip(int zipCode, int start, int end) {

        Session session = null;
        try {
            session = amfRegistrationPersistence.openSession();
            String sql = CustomSQLUtil.get(getClass(), FIND_USERS_BY_ZIP_CODE);

            SQLQuery queryObject = session.createSQLQuery(sql);
            queryObject.setCacheable(false);
            //queryObject.addEntity("User_", User.class);

            QueryPos qPos = QueryPos.getInstance(queryObject);
            qPos.add(zipCode);

            //Pagination
            qPos.add(start);
            qPos.add(end);

            return (List<Object[]>) queryObject.list();
        } catch (Exception e) {
            throw e;
        } finally {
            amfRegistrationPersistence.closeSession(session);
        }
    }

    public int countByUsersByZip(int zipCode) {
        Session session = null;
        try {
            session = amfRegistrationPersistence.openSession();
            String sql = CustomSQLUtil.get(getClass(), COUNT_USERS_BY_ZIP_CODE);

            SQLQuery queryObject = session.createSQLQuery(sql);
            queryObject.setCacheable(false);

            QueryPos qPos = QueryPos.getInstance(queryObject);
            qPos.add(zipCode);

            BigInteger total = (BigInteger)queryObject.uniqueResult();
            return total.intValue();

        } catch (Exception e) {
            throw e;
        } finally {
            amfRegistrationPersistence.closeSession(session);
        }
    }
}
