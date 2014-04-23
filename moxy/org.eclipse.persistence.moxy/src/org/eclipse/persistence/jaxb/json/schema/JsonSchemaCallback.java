/*******************************************************************************
 * Copyright (c) 1998, 2014 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Gerard Davison 2.6 - Initial Implementation
 ******************************************************************************/

package org.eclipse.persistence.jaxb.json.schema;

import java.util.Map;
import org.eclipse.persistence.jaxb.json.schema.model.JsonSchema;
import org.eclipse.persistence.jaxb.json.schema.model.JsonSchemaProperty;

import org.eclipse.persistence.internal.oxm.mappings.Mapping;
import org.eclipse.persistence.oxm.XMLDescriptor;


/**
 * A interface to ask the generator to create specific subclasses of
 * the standard schema objects, for example JsonSchema with hypermedia
 * extensions would be an example of a suitable extension.
 * @param <Schema> The type of the Schema object
 * @param <Property> The type of the Property object
 */
public interface JsonSchemaCallback<Schema extends JsonSchema<Property>, Property extends JsonSchemaProperty> {

    
    /**
     * A default implements of a factory that produces vanilla v3 JSON Schema
     * models
     */
    public static final JsonSchemaCallback DEFAULT =  new JsonSchemaCallback<JsonSchema<JsonSchemaProperty>, JsonSchemaProperty>()
    {
        public JsonSchema createSchema(Class rootClass) {
            return new JsonSchema();
        }

        public JsonSchemaProperty createProperty() {
            return new JsonSchemaProperty();
        }

        public void updateProperty(Class clazz, XMLDescriptor descriptor, JsonSchemaProperty property) {
        }
    };
    
    
     
    public Schema createSchema(Class rootClass);

    public Property createProperty();

    public void updateProperty(Class clazz, XMLDescriptor descriptor, JsonSchemaProperty property);
      
}
