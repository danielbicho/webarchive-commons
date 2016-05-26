/*
 * Copyright 2016 The International Internet Preservation Consortium.
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
package org.netpreserve.commons.uri.normalization;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.netpreserve.commons.uri.Normalizer;
import org.netpreserve.commons.uri.UriBuilder;

/**
 *
 */
public abstract class SchemeBasedNormalizer implements Normalizer {

    public abstract Set<String> getSupportedSchemes();

    @Override
    public boolean validFor(UriBuilder builder) {
        if (builder.config.isSchemeBasedNormalization()) {
            Set<String> supportedSchemes = getSupportedSchemes();
            if (supportedSchemes.isEmpty()) {
                return true;
            } else {
                return getSupportedSchemes().contains(builder.scheme());
            }
        }
        return false;
    }

    protected final static Set<String> immutableSetOf(String... values) {
        return Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(values)));
    }

}
