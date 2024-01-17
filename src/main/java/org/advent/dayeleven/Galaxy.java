package org.advent.dayeleven;

import java.util.List;

public class Galaxy {

    public List<Row> rows;
    public List<Column> columns;

    public Galaxy() {


    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
