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

package models.service;

import com.google.inject.Inject;
import models.Location;

/**
 * Created by bwpc on 09.12.2014.
 */
public class DefaultLocationModelService extends BaseRemoteModelService<Location>
    implements LocationModelService {

    @Inject public DefaultLocationModelService(RemoteModelRepository<Location> locationRepository) {
        super(locationRepository);
    }

    @Override public Location getByUuidInCloudAndUuidOfCloud(String cloudUuid, String UuidOfCloud) {
        for (Location location : getAll()) {
            if (location.getRemoteId().equals(cloudUuid) && location.getCloud().getUuid()
                .equals(UuidOfCloud)) {
                return location;
            }
        }
        return null;
    }
}