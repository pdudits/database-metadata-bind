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


package com.github.jinahya.sql.database.metadata.bind;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
@XmlRootElement
@XmlType(
    propOrder = {
        "columnName", "dataType", "columnSize", "decimalDigits", "numPrecRadix",
        "columnUsage", "remarks", "charOctetLength", "isNullable"
    }
)
public class PseudoColumn {


    // ---------------------------------------------------------------- tableCat
    public String getTableCat() {

        return tableCat;
    }


    public void setTableCat(final String tableCat) {

        this.tableCat = tableCat;
    }


    // -------------------------------------------------------------- tableSchem
    public String getTableSchem() {

        return tableSchem;
    }


    public void setTableSchem(final String tableSchem) {

        this.tableSchem = tableSchem;
    }


    // --------------------------------------------------------------- tableName
    public String getTableName() {

        return tableName;
    }


    public void setTableName(final String tableName) {

        this.tableName = tableName;
    }


    // -------------------------------------------------------------- columnName
    public String getColumnName() {

        return columnName;
    }


    public void setColumnName(final String columnName) {

        this.columnName = columnName;
    }


    // ---------------------------------------------------------------- dataType
    public int getDataType() {

        return dataType;
    }


    public void setDataType(final int dataType) {

        this.dataType = dataType;
    }


    // -------------------------------------------------------------- columnSize
    public int getColumnSize() {

        return columnSize;
    }


    public void setColumnSize(int columnSize) {

        this.columnSize = columnSize;
    }


    // ----------------------------------------------------------- decimalDigits
    public Integer getDecimalDigits() {

        return decimalDigits;
    }


    public void setDecimalDigits(final Integer decimalDigits) {

        this.decimalDigits = decimalDigits;
    }


    // ------------------------------------------------------------ numPrecRadix
    public int getNumPrecRadix() {

        return numPrecRadix;
    }


    public void setNumPrecRadix(final int numPrecRadix) {

        this.numPrecRadix = numPrecRadix;
    }


    // ------------------------------------------------------------- columnUsage
    public String getColumnUsage() {
        return columnUsage;
    }


    public void setColumnUsage(String columnUsage) {
        this.columnUsage = columnUsage;
    }


    // ----------------------------------------------------------------- remarks
    public String getRemarks() {

        return remarks;
    }


    public void setRemarks(final String remarks) {

        this.remarks = remarks;
    }


    // --------------------------------------------------------- charOctetLength
    public int getCharOctetLength() {

        return charOctetLength;
    }


    public void setCharOctetLength(final int charOctetLength) {

        this.charOctetLength = charOctetLength;
    }


    // -------------------------------------------------------------- isNullable
    public String getIsNullable() {

        return isNullable;
    }


    public void setIsNullable(final String isNullable) {

        this.isNullable = isNullable;
    }


    // ------------------------------------------------------------------- table
    public Table getTable() {

        return table;
    }


    public void setTable(final Table table) {

        this.table = table;
    }


    @Label("TABLE_CAT")
    @XmlAttribute
    @NillableBySpecification
    private String tableCat;


    @Label("TABLE_SCHEM")
    @XmlAttribute
    @NillableBySpecification
    private String tableSchem;


    @Label("TABLE_NAME")
    @XmlAttribute
    @NillableBySpecification
    private String tableName;


    @Label("COLUMN_NAME")
    @XmlElement(required = true)
    private String columnName;


    @Label("DATA_TYPE")
    @XmlElement(required = true)
    private int dataType;


    @Label("COLUMN_SIZE")
    @XmlElement(required = true)
    private int columnSize;


    @Label("DECIMAL_DIGITS")
    @XmlElement(nillable = true, required = true)
    @NillableBySpecification
    private Integer decimalDigits;


    @Label("NUM_PREC_RADIX")
    @XmlElement(required = true)
    private int numPrecRadix;


    @Label("COLUMN_USAGE")
    @XmlElement(required = true)
    private String columnUsage;


    @Label("REMARKS")
    @XmlElement(nillable = true, required = true)
    @NillableBySpecification
    private String remarks;


    @Label("CHAR_OCTET_LENGTH")
    @XmlElement(required = true)
    private int charOctetLength;


    @Label("IS_NULLABLE")
    @XmlElement(required = true)
    private String isNullable;


    @XmlTransient
    private Table table;


}
