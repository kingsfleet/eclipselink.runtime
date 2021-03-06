/*******************************************************************************
 * Copyright (c) 2005, 2009 SAP. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     SAP - initial API and implementation
 ******************************************************************************/

package org.eclipse.persistence.testing.models.wdf.jpa1.employee;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Cacheable(true)
@Entity
@DiscriminatorValue("11")
public class Truck extends MotorVehicle {

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(name = "MAX_LOAD")
    protected short maxLoad;

    public void setMaxLoad(short maxLoad) {
        this.maxLoad = maxLoad;
    }

    public short getMaxLoad() {
        return maxLoad;
    }

}
