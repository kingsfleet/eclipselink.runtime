/*******************************************************************************
 * Copyright (c) 2011, 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *      gonural - initial 
 ******************************************************************************/
package org.eclipse.persistence.jpa.rs.util.list;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.jpa.rs.ReservedWords;

/**
 * This class is used to wrap collection of records returned by a JPA report query.
 *
 * @author gonural
 *
 */
@XmlRootElement(name = ReservedWords.JPARS_LIST_GROUPING_NAME)
public class ReportQueryResultList {

    private List<ReportQueryResultListItem> items;

    /**
     * Instantiates a new query result list.
     */
    public ReportQueryResultList() {
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    @XmlElement(name = ReservedWords.JPARS_LIST_ITEM_NAME)
    public List<ReportQueryResultListItem> getItems() {
        return items;
    }

    /**
     * Sets the items.
     *
     * @param items the new items
     */
    public void setItems(List<ReportQueryResultListItem> items) {
        this.items = items;
    }

    /**
     * Adds the item.
     *
     * @param item the item
     */
    public void addItem(ReportQueryResultListItem item) {
        if (items == null) {
            items = new ArrayList<ReportQueryResultListItem>();
        }
        items.add(item);
    }
}
