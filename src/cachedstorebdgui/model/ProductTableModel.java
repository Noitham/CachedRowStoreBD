/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.model;

import cachedstorebdgui.controllers.ModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dmora
 */
public class ProductTableModel extends AbstractTableModel {

    private final Store data;

    private final String[] columnNames = {
        "Code", "Name", "Price"
    };

    public ProductTableModel(Store data) {
        this.data = data;
        addTableModelListener(new ModelListener());
    }

    @Override
    public int getRowCount() {
        return data.getNumProducts();
    }

    @Override
    public int getColumnCount() {
        return 3; //number of attributes of person object
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product elem = data.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = elem.getCode();
                break;
            case 1:
                value = elem.getName();
                break;
            case 2:
                value = elem.getPrice();
                break;
            default:
                value = null;
                break;
        }
        return value;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Product elem = data.get(row);
        switch (col) {
            case 0:
                elem.setCode((String) value);
                break;
            case 1:
                elem.setName((String) value);
                break;
            case 2:
                elem.setPrice((int) value);
                break;
            default:
                break;
        }
        fireTableCellUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true; //all cells editable (change if necessary).
    }
}
