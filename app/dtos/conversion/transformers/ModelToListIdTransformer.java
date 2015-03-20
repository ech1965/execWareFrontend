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

package dtos.conversion.transformers;

import models.generic.Model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by daniel on 19.03.15.
 */
public class ModelToListIdTransformer<T extends Model>
    implements Transformer<Collection<Long>, Collection<T>> {

    private final IdToModelTransformer<T> idToModelTransformer;

    public ModelToListIdTransformer(IdToModelTransformer<T> idToModelTransformer) {
        this.idToModelTransformer = idToModelTransformer;
    }

    @Override public Collection<T> transform(Collection<Long> longs) {
        Collection<T> list = new ArrayList<>(longs.size());
        for (Long id : longs) {
            list.add(idToModelTransformer.transform(id));
        }
        return list;
    }

    @Override public Collection<Long> transformReverse(Collection<T> ts) {
        Collection<Long> ids = new ArrayList<>(ts.size());
        for (T t : ts) {
            ids.add(idToModelTransformer.transformReverse(t));
        }
        return ids;
    }
}
