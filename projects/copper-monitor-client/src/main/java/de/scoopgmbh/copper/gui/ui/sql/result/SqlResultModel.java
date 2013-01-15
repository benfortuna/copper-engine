/*
 * Copyright 2002-2012 SCOOP Software GmbH
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
package de.scoopgmbh.copper.gui.ui.sql.result;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;


public class SqlResultModel {
	public final List<SimpleStringProperty> rows = new ArrayList<>();
	
	public SqlResultModel(String... rows){
		for (String row: rows){
			this.rows.add(new SimpleStringProperty(row));;
		}
	}
	
}
