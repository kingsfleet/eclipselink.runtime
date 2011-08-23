/*******************************************************************************
 * Copyright (c) 1998, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Denise Smith - 2.4
 ******************************************************************************/
package org.eclipse.persistence.testing.jaxb.namespaceuri.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.testing.jaxb.JAXBTestCases;

public class XMLNamespaceTestCases extends JAXBTestCases{

	private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/namespaceuri/xml/xmlnamespace.xml";
	
	public XMLNamespaceTestCases(String name) throws Exception {
		super(name);
		setClasses(new Class[]{Address.class});
    	setControlDocument(XML_RESOURCE);
	}

	@Override
	protected Object getControlObject() {
		Address addr = new Address();
		addr.setStreet("theStreet");
		addr.lang = "blah";
		return addr;	
	}
	
	public void testSchemaGen() throws Exception{
		List<InputStream> controlSchemas = new ArrayList<InputStream>();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/namespaceuri/xml/xmlnamespace.xsd");

		controlSchemas.add(inputStream);
	
		super.testSchemaGen(controlSchemas);
	}	
}