/*
 * Copyright 2017 Jin Kwon &lt;onacit at gmail.com&gt;.
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
package com.github.jinahya.database.metadata.bind;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A wrapper class for {@link Catalog}s.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
@XmlRootElement
public class Schemas extends Plural<Schema> {

    private static final long serialVersionUID = -1029819528806345298L;

    // -------------------------------------------------------------------------
    static Schemas newInstance(final List<Schema> schemas) {
        final Schemas instance = new Schemas();
        instance.getSchemas().addAll(schemas);
        return instance;
    }

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    /**
     * Returns a list of {@link Schema}s.
     *
     * @return a list of {@link Schema}.
     */
    @XmlElement(name = "schema")
    public List<Schema> getSchemas() {
        return getElements();
    }
}
