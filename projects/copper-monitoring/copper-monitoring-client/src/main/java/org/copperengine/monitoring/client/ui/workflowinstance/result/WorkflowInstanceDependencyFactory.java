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
package org.copperengine.monitoring.client.ui.workflowinstance.result;

import javafx.scene.layout.BorderPane;

import org.copperengine.monitoring.client.form.FxmlForm;
import org.copperengine.monitoring.client.form.filter.FilterAbleForm;
import org.copperengine.monitoring.client.form.filter.FilterResultController;
import org.copperengine.monitoring.client.form.filter.enginefilter.EngineFilterAbleForm;
import org.copperengine.monitoring.client.ui.audittrail.filter.AuditTrailFilterModel;
import org.copperengine.monitoring.client.ui.audittrail.result.AuditTrailResultModel;
import org.copperengine.monitoring.client.ui.workflowinstancedetail.filter.WorkflowInstanceDetailFilterModel;
import org.copperengine.monitoring.client.ui.workflowinstancedetail.result.WorkflowInstanceDetailResultModel;
import org.copperengine.monitoring.core.model.ProcessingEngineInfo;

public interface WorkflowInstanceDependencyFactory {
    public FilterAbleForm<AuditTrailFilterModel, AuditTrailResultModel> createAuditTrailForm();

    public EngineFilterAbleForm<WorkflowInstanceDetailFilterModel, WorkflowInstanceDetailResultModel> createWorkflowInstanceDetailForm(String workflowInstanceId, ProcessingEngineInfo engine);

    public FxmlForm<FilterResultController<WorkflowInstanceDetailFilterModel, WorkflowInstanceDetailResultModel>> createWorkflowinstanceDetailResultForm(
            BorderPane detailPane);
}
