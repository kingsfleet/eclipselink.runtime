/*******************************************************************************
 * Copyright (c) 1998, 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.internal.oxm.schema.model;

public class Attribute extends SimpleComponent {
    public static final String OPTIONAL = "optional";
    public static final String REQUIRED = "required";
    public static final String PROHIBITED = "prohibited";
    private String use;
  
    public Attribute() {
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getUse() {
        return use;
    }
   
}
