// Copyright 2015 ThoughtWorks, Inc.

// This file is part of Gauge-Java.

// This program is free software.
//
// It is dual-licensed under:
// 1) the GNU General Public License as published by the Free Software Foundation,
// either version 3 of the License, or (at your option) any later version;
// or
// 2) the Eclipse Public License v1.0.
//
// You can redistribute it and/or modify it under the terms of either license.
// We would then provide copied of each license in a separate .txt file with the name of the license as the title of the file.

package com.thoughtworks.gauge;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Table structure used as parameter is steps
 */
public class Table {
    private final List<String> headers;
    private final List<List<String>> rows;
    private final List<TableRow> tableRows;

    public Table(List<String> headers) {
        this.headers = headers;
        rows = new ArrayList<List<String>>();
        tableRows = new ArrayList<TableRow>();
    }

    public void addRow(List<String> row) {
        rows.add(row);
        TableRow rowToAdd = new TableRow();
        for (String header : headers) {
            rowToAdd.addCell(header, row.get(headers.indexOf(header)));
        }
        tableRows.add(rowToAdd);
    }

    /**
     * @return - List of Names of the Columns on the table
     */
    public List<String> getColumnNames() {
        return headers;
    }

    /**
     * @return - List of Rows in the table. Each Row is represented by a TableRow.
     */
    public List<TableRow> getTableRows(){
        return tableRows;
    }


    /**
     * @deprecated - Use getTableRows() method instead of this.
     * @return - List of TableRows in the table. Each Row is represented by a List of String values
     * according to the order of column names
     */
    @Deprecated
    public List<List<String>> getRows() {
        return rows;
    }

    public List<String> getColumnValues(String columnName) {
        List<String> columnValues = new ArrayList<String>();

        int columnIndex = headers.indexOf(columnName);

        if (columnIndex >= 0) {
            for (List<String> row : rows) {
                columnValues.add(row.get(columnIndex));
            }
        }
        return columnValues;
    }
}
