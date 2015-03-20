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

package dtos.conversion.api;

import com.google.inject.ImplementedBy;
import dtos.conversion.generic.DefaultModelDtoConversionService;
import dtos.api.Dto;
import models.generic.Model;

import java.util.List;

@ImplementedBy(DefaultModelDtoConversionService.class) public interface ModelDtoConversionService {

    public <T extends Model, S extends Dto> S toDto(T model, Class<S> dtoClass);

    public <T extends Model, S extends Dto> S toDto(T model, S dto);

    public <T extends Model, S extends Dto> T toModel(S dto, Class<T> modelClass);

    public <T extends Model, S extends Dto> T toModel(S dto, T model);

    public <T extends Model, S extends Dto> List<S> toDtos(List<T> models, Class<S> dtoClass);

}
