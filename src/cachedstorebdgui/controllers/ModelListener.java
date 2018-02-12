/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachedstorebdgui.controllers;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author dmora
 */
public class ModelListener implements TableModelListener {

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            //retrieve data model for the table and row and colum witch changed.
            TableModel model = (TableModel) e.getSource();
            int row = e.getFirstRow();
            int col = e.getColumn();
            Object value = model.getValueAt(row, col);
            System.out.format("Changed row %d colum %d to value %s\n", row + 1, col + 1, value.toString());
        }
    }

}
