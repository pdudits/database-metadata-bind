/*
 * Copyright 2013 Jin Kwon <onacit at gmail.com>.
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


package com.github.jinahya.sql.database.meta.data.bind;


import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author Jin Kwon <onacit at gmail.com>
 */
@XmlType(
    propOrder = {
        "procedureName", "remarks", "procedureType", "specificName"
    }
)
public class Procedure {


    /**
     *
     * @param database
     * @param suppression
     * @param catalog
     * @param schemaPattern
     * @param procedureNamePattern
     * @param procedures
     *
     * @throws SQLException if a database access error occurs.
     *
     * @see DatabaseMetaData#getProcedures(String, String, String)
     */
    public static void retrieve(final DatabaseMetaData database,
                                final Suppression suppression,
                                final String catalog,
                                final String schemaPattern,
                                final String procedureNamePattern,
                                final Collection<? super Procedure> procedures)
        throws SQLException {

        if (database == null) {
            throw new NullPointerException("null database");
        }

        if (suppression == null) {
            throw new NullPointerException("null suppression");
        }

        if (procedures == null) {
            throw new NullPointerException("null procedures");
        }

        if (suppression.isSuppressed(Schema.SUPPRESSION_PATH_PROCEDURES)) {
            return;
        }

        final ResultSet resultSet = database.getProcedures(
            catalog, schemaPattern, procedureNamePattern);
        try {
            while (resultSet.next()) {
                procedures.add(ColumnRetriever.retrieve(
                    Procedure.class, suppression, resultSet));
            }
        } finally {
            resultSet.close();
        }
    }


    public static void retrieve(final DatabaseMetaData database,
                                final Suppression suppression,
                                final Schema schema)
        throws SQLException {

        if (database == null) {
            throw new NullPointerException("null database");
        }

        if (suppression == null) {
            throw new NullPointerException("null suppression");
        }

        if (schema == null) {
            throw new NullPointerException("null schema");
        }

        retrieve(database, suppression,
                 schema.getCatalog().getTableCat(),
                 schema.getTableSchem(),
                 null,
                 schema.getProcedures());

        for (final Procedure procedure : schema.getProcedures()) {
            procedure.schema = schema;
        }
    }


    /**
     * Creates a new instance.
     */
    public Procedure() {

        super();
    }


    // ------------------------------------------------------------------ schema
    public Schema getSchema() {

        return schema;
    }


    // ----------------------------------------------------------- procedureName
    public String getProcedureName() {

        return procedureName;
    }


    public void setProcedureName(final String procedureName) {

        this.procedureName = procedureName;
    }


    public String getRemarks() {

        return remarks;
    }


    public void setRemarks(final String remarks) {

        this.remarks = remarks;
    }


    public short getProcedureType() {

        return procedureType;
    }


    public void setProcedureType(final short procedureType) {

        this.procedureType = procedureType;
    }


    public String getSpecificName() {

        return specificName;
    }


    public void setSpecificName(final String specificName) {

        this.specificName = specificName;
    }


    /**
     * procedure catalog (may be {@code null}).
     */
    @ColumnLabel("PROCEDURE_TYPE")
    @SuppressionPath("procedure/procedureCat")
    @XmlAttribute
    String procedureCat;


    /**
     * procedure schema (may be {@code null}).
     */
    @ColumnLabel("PROCEDURE_TYPE")
    @SuppressionPath("procedure/procedureSchem")
    @XmlAttribute
    private String procedureSchem;


    /**
     * parent schema.
     */
    @XmlTransient
    private Schema schema;


    /**
     * procedure name.
     */
    @ColumnLabel("PROCEDURE_NAME")
    @XmlElement(required = true)
    String procedureName;


    /**
     * explanatory comment on the procedure.
     */
    @ColumnLabel("REMARKS")
    @XmlElement(required = true)
    String remarks;


    /**
     * kind of procedure:
     * <ul>
     * <li>{@link DatabaseMetaData#procedureResultUnknown} - Cannot determine if
     * a return value will be returned</li>
     * <li>{@link DatabaseMetaData#procedureNoResult} - Does not return a return
     * value</li>
     * <li>{@link DatabaseMetaData#procedureReturnsResult} - Returns a return
     * value</li>
     * </ul>
     */
    @ColumnLabel("PROCEDURE_TYPE")
    @XmlElement(required = true)
    short procedureType;


    /**
     * The name which uniquely identifies this procedure within its schema.
     */
    @ColumnLabel("SPECIFIC_NAME")
    @XmlElement(required = true)
    String specificName;


}
