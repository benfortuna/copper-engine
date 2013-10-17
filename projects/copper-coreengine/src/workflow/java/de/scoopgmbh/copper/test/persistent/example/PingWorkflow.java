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
package de.scoopgmbh.copper.test.persistent.example;

import de.scoopgmbh.copper.AutoWire;
import de.scoopgmbh.copper.InterruptException;
import de.scoopgmbh.copper.Response;
import de.scoopgmbh.copper.WaitMode;
import de.scoopgmbh.copper.persistent.PersistentWorkflow;

public class PingWorkflow extends PersistentWorkflow<PingData> {

	private PingAdapter pingAdapter;
	
	// The pingAdapter is injected my the engine due to the AutoWire annotation 
	@AutoWire
	public void setPingAdapter(PingAdapter pingAdapter) {
		this.pingAdapter = pingAdapter;
	}

	@Override
	public void main() throws InterruptException {
		System.out.println("started");
		// Asynchronous call of the ping service  
		String correlationId = pingAdapter.ping(getData().pingMessage);
		// Wait up to 60 seconds for the response
		wait(WaitMode.ALL, 60000, correlationId);
		// get and remove the response from the engine using the correlationId
		Response<String> response = getAndRemoveResponse(correlationId);
		System.out.println("finished, response="+response.getResponse());
	}
}
