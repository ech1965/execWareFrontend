/*
 * Copyright (c) 2014-2015 University of Ulm
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package cloud.config;

import cloud.CloudService;
import cloud.ComputeServiceFactory;
import cloud.DefaultCloudService;
import cloud.SwordComputeServiceFactory;
import com.google.inject.AbstractModule;

/**
 * Created by daniel on 28.04.15.
 */
public class CloudModule extends AbstractModule {

    @Override protected void configure() {
        bind(CloudService.class).to(DefaultCloudService.class);
        bind(ComputeServiceFactory.class).to(SwordComputeServiceFactory.class);
    }
}