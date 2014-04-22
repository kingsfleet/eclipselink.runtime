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
package org.eclipse.persistence.jaxb.json;

import java.util.Map;
import org.eclipse.persistence.internal.jaxb.json.schema.JsonSchemaGeneratorImpl;
import org.eclipse.persistence.jaxb.JAXBContext;
import org.eclipse.persistence.jaxb.json.schema.JsonSchemaCallback;
import org.eclipse.persistence.jaxb.json.schema.JsonSchemaGenerator;
import org.eclipse.persistence.jaxb.json.schema.model.JsonSchema;
import org.eclipse.persistence.jaxb.json.schema.model.JsonSchemaProperty;

/**
 *
 * @author gdavison
 */
public class JsonSchemaGeneratorFactory {

    
    
    /**
     * @param jaxbContext The JAXBContext for the classes to generate the schema for
     * @param properties Properties that override the generation options
     * @return A generic JSON Schema model generator
     */ 
    public static JsonSchemaGenerator<JsonSchema<JsonSchemaProperty>, JsonSchemaProperty> newInstance(
            JAXBContext jaxbContext, Map properties) {
        return newInstance(JsonSchemaCallback.DEFAULT, jaxbContext, properties);
    }    

    /**
     * @param <Schema> The specific subtype of JSON Schema required
     * @param <Property> The specific subtype of the JSON Schema property object
     * @param callback The callback to from the generator
     * @param jaxbContext The JAXBContext for the classes to generate the schema for
     * @param properties Properties that override the generation options
     * @return A type specific JSON Schema model generator
     */ 
    public static <Schema extends JsonSchema<Property>, Property extends JsonSchemaProperty> JsonSchemaGenerator<Schema,Property> newInstance(
            JsonSchemaCallback<Schema, Property> callback,
            JAXBContext jaxbContext, Map properties) {

        return new JsonSchemaGeneratorImpl(
                callback, jaxbContext, properties);
    }

}
