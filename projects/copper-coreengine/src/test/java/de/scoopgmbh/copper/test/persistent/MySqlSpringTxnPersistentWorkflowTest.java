/*
 * Copyright 2002-2013 SCOOP Software GmbH
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
package de.scoopgmbh.copper.test.persistent;

import javax.sql.DataSource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.fail;


public class MySqlSpringTxnPersistentWorkflowTest extends BaseSpringTxnPersistentWorkflowTest {

	private static final String DS_CONTEXT = "/datasources/datasource-mysql.xml";
	private static final Logger logger = LoggerFactory.getLogger(MySqlPersistentWorkflowTest.class);

	private static boolean dbmsAvailable = false;

	static {
		if (Boolean.getBoolean(Constants.SKIP_EXTERNAL_DB_TESTS_KEY)) {
			dbmsAvailable = true;
		}
		else {
			final ConfigurableApplicationContext context = new MySqlSpringTxnPersistentWorkflowTest().createContext(DS_CONTEXT);
			try {
				DataSource ds = context.getBean(DataSource.class);
				ds.setLoginTimeout(10);
				ds.getConnection();
				dbmsAvailable = true;
			}
			catch(Exception e) {
				logger.error("Oracle DBMS not available! Skipping Oracle unit tests.",e);
				e.printStackTrace();
			}
			finally {
				context.close();
			}
		}
	}	

	@Override
	protected boolean skipTests() {
		return Boolean.getBoolean(Constants.SKIP_EXTERNAL_DB_TESTS_KEY);
	}

	@Test
	public void testAsnychResponse() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testAsnychResponse(DS_CONTEXT);
	}

	@Test
	public void testAsnychResponseLargeData() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testAsnychResponseLargeData(DS_CONTEXT,65536);
	}

	@Test
	public void testWithConnection() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testWithConnection(DS_CONTEXT);
	}

	@Test
	public void testWithConnectionBulkInsert() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testWithConnectionBulkInsert(DS_CONTEXT);
	}

	@Test
	public void testTimeouts() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testTimeouts(DS_CONTEXT);
	}

	@Test
	public void testErrorHandlingInCoreEngine() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testErrorHandlingInCoreEngine(DS_CONTEXT);
	}

	@Test
	public void testParentChildWorkflow() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testParentChildWorkflow(DS_CONTEXT);
	}

	@Test
	public void testErrorKeepWorkflowInstanceInDB() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testErrorKeepWorkflowInstanceInDB(DS_CONTEXT);
	}

	@Test
	public void testAuditTrailUncompressed() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testAuditTrailUncompressed(DS_CONTEXT);
	}

	@Test
	public void testErrorHandlingWithWaitHook() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testErrorHandlingWithWaitHook(DS_CONTEXT);
	}

	@Test
	public void testSpringTxnUnitTestWorkflow() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testSpringTxnUnitTestWorkflow(DS_CONTEXT);
	}	

	@Test
	public void testAutoCommit() throws Exception {
		if (!dbmsAvailable) fail("DBMS not available");
		super.testAutoCommit(DS_CONTEXT);
	}		
}
