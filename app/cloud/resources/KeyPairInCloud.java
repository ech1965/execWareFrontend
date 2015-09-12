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

package cloud.resources;

import com.google.common.base.Optional;
import de.uniulm.omi.cloudiator.sword.api.domain.KeyPair;

/**
 * Created by daniel on 10.09.15.
 */
public class KeyPairInCloud extends AbstractCredentialScopedResource<KeyPair> implements KeyPair {
    private final KeyPair keyPair;

    public KeyPairInCloud(KeyPair resource, String cloud, String credential) {
        super(resource, cloud, credential);
        this.keyPair = resource;
    }

    @Override public String publicKey() {
        return keyPair.publicKey();
    }

    @Override public Optional<String> privateKey() {
        return keyPair.privateKey();
    }
}
