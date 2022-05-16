package model;
import java.util.ArrayList;

public class TableContainer {
	private ArrayList<Table> tables;
    private static TableContainer instance;
    /**
     * Constructor for objects of class CostumerContainer
     */
    private TableContainer()
    {
        tables = new ArrayList<>();
    }

    public static TableContainer getInstance(){
        if(instance == null){
            instance = new TableContainer();
        }
        return instance;
    }
    public void addTable() {
    	Table table = new Table(tables.size());
    	tables.add(table);
    }
    
     public  Table findTableByID(int tableID){
        boolean found = false;
        int i = 0;
        Table returnTable = null;
        while(i < tables.size() && !found){
        	Table table = tables.get(i);
            if(table.getTableID() == tableID){
                found = true;
                returnTable = table;
            }
            i++;
        }
        return returnTable;
    }
}
