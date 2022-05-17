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
        createTables();
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
    
     public Table findTableByID(int tableID){
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

	public ArrayList<Table> getTables() {
		return tables;
	}


	public void createTables()  {
		for(int i = 1; i<= 8; i++) {
			Table table = new Table(i);
			tables.add(table);
		}
	}

	public void setActiveTable(int tableID) {
		Table table = findTableByID(tableID);
		table.setIsActive(true);
	}
}