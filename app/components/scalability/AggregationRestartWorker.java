/*
 * Copyright (c) 2014-2015 University of Ulm
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package components.scalability;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import components.execution.SimpleBlockingQueue;
import de.uniulm.omi.executionware.srl.aggregator.AggregatorService;
import de.uniulm.omi.executionware.srl.aggregator.DirectEngineCommunicator;
import de.uniulm.omi.executionware.srl.aggregator.IEngineCommunicator;
import models.ComposedMonitor;
import models.service.ModelService;
import play.Logger;
import play.db.jpa.Transactional;

/**
 * Created by Frank on 09.08.2015.
 */
public class AggregationRestartWorker  implements Runnable {

    private final ModelService<ComposedMonitor> modelService;
    private final ScalingEngine se;


    @Inject public AggregationRestartWorker(ModelService<ComposedMonitor> modelService,
        ScalingEngine se) {
        this.modelService = modelService;
        this.se = se;
    }

    @Override @Transactional public void run() {
        try {
            for(ComposedMonitor m : modelService.getAll()){
                se.aggregateMonitors(m, false);
            }
        } catch (Exception e) {
            Logger.error("Job Execution got an error", e);

            Thread.currentThread().interrupt();
        }
    }
}
