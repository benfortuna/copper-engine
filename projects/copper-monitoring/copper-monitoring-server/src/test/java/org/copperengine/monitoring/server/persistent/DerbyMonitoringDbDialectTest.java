/*
 * Copyright 2002-2014 SCOOP Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.copperengine.monitoring.server.persistent;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.derby.jdbc.EmbeddedConnectionPoolDataSource40;
import org.copperengine.core.audit.BatchingAuditTrail;
import org.copperengine.core.audit.DummyPostProcessor;
import org.copperengine.core.db.utility.JdbcUtils;
import org.copperengine.core.persistent.DerbyDbDialect;
import org.copperengine.core.persistent.StandardJavaSerializer;
import org.copperengine.monitoring.server.util.DerbyCleanDbUtil;

public class DerbyMonitoringDbDialectTest extends MonitoringDbDialectTestBase {

    @Override
    void init() {
        EmbeddedConnectionPoolDataSource40 datasource = new EmbeddedConnectionPoolDataSource40();
        datasource.setDatabaseName("./build/copperExampleDB;create=true");
        this.datasource = datasource;

        DerbyMonitoringDbDialect derbyMonitoringDbDialect = new DerbyMonitoringDbDialect(new StandardJavaSerializer(), new DummyPostProcessor(), new BatchingAuditTrail());
        this.monitoringDbDialect = derbyMonitoringDbDialect;

        DerbyDbDialect databaseDialect = new DerbyDbDialect();
        databaseDialect.setDataSource(datasource);
        databaseDialect.startup();
        this.databaseDialect = databaseDialect;

        Connection connection = null;
        try {
            connection = datasource.getConnection();
            connection.setAutoCommit(false);
            DerbyCleanDbUtil.dropSchema(connection.getMetaData(), "APP"); // APP = default schema
            DerbyDbDialect.checkAndCreateSchema(datasource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

}
