/*******************************************************************************
 * Copyright (c) 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Mike Norman - June 10 2011, created DDL parser package
 *     David McCann - July 2011, visit tests
 ******************************************************************************/
package dbws.testing;

//javase imports
import java.sql.Connection;
import java.sql.SQLException;

//JUnit4 imports
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//testing imports
import dbws.testing.advancedjdbcpackage.AdvancedJDBCPackageTestSuite;
import dbws.testing.complexplsqlsf.ComplexPLSQLSFTestSuite;
import dbws.testing.complexplsqlsp.ComplexPLSQLSPTestSuite;
import dbws.testing.customsql.CustomSQLTestSuite;
import dbws.testing.iottype.IOTTypeTestSuite;
import dbws.testing.nonassociativeplsql.NonAssociativePLSQLCollectionTestSuite;
import dbws.testing.objecttabletype.ObjectTableTypeTestSuite;
import dbws.testing.objecttype.ObjectTypeTestSuite;
import dbws.testing.ordescriptor.ORDescriptorTestSuite;
import dbws.testing.oxdescriptor.OXDescriptorTestSuite;
import dbws.testing.plsqlcollection.PLSQLCollectionTestSuite;
import dbws.testing.plsqlrecord.PLSQLRecordTestSuite;
import dbws.testing.secondarysql.SecondarySQLTestSuite;
import dbws.testing.simpleplsqlsf.SimplePLSQLSFTestSuite;
import dbws.testing.simpleplsqlsp.SimplePLSQLSPTestSuite;
import dbws.testing.simplesf.SimpleSFTestSuite;
import dbws.testing.simplesp.SimpleSPTestSuite;
import dbws.testing.simpletablewithnestedsql.SimpleTableWithNestedSQLTestSuite;
import dbws.testing.tabletype.TableTypeTestSuite;
import dbws.testing.toplevelsimpleplsqlsp.TopLevelSimplePLSQLSPTestSuite;
import dbws.testing.types.TypesTestSuite;
import dbws.testing.varray.VArrayTestSuite;
import static dbws.testing.DBWSTestSuite.buildConnection;

@RunWith(Suite.class)
@SuiteClasses({
    AdvancedJDBCPackageTestSuite.class,
    ComplexPLSQLSFTestSuite.class,
    ComplexPLSQLSPTestSuite.class,
    CustomSQLTestSuite.class,
    IOTTypeTestSuite.class,
    NonAssociativePLSQLCollectionTestSuite.class,
    ObjectTableTypeTestSuite.class,
    ObjectTypeTestSuite.class,
    ORDescriptorTestSuite.class,
    OXDescriptorTestSuite.class,
    PLSQLCollectionTestSuite.class,
    PLSQLRecordTestSuite.class,
    SecondarySQLTestSuite.class,
    SimplePLSQLSFTestSuite.class,
    SimplePLSQLSPTestSuite.class,
    SimpleSFTestSuite.class,
    SimpleSPTestSuite.class,
    SimpleTableWithNestedSQLTestSuite.class,
    TableTypeTestSuite.class,
    TopLevelSimplePLSQLSPTestSuite.class,
    TypesTestSuite.class,
    VArrayTestSuite.class
  }
)
public class AllTests {

    //shared JUnit fixtures
    public static Connection conn = null;

    @BeforeClass
    public static void setUp() throws ClassNotFoundException, SQLException {
        conn = buildConnection();
    }
}