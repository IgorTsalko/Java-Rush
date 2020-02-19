package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        TableInterface source;

        public TableInterfaceWrapper(TableInterface source) {
            this.source = source;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            source.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return source.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            source.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}