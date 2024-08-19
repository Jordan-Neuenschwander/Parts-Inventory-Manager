package io.github.jordanneuenschwander.inventorymanager;

/**
 * The <code>InHouse</code> class extends the <code>Part</code> class. It stores information about parts that
 * are produced in house.
 *
 * @author Jordan Neuenschwander
 * @version 1.0
 */
public class InHouse extends Part{
    /**
     * An integer value to hold the <code>machineId</code> where this part was produced
     */
    private int machineId;

    /**
     * Constructs an instance of the <code>InHouse</code> class. Calls the constructor of the extended class <code>Part</code>.
     *
     * @param newId The id of the part
     * @param newName The name of the part
     * @param newPrice The price of the part
     * @param newStock The inventory level or stock amount of the part
     * @param newMin The minimum stock allowed for this part
     * @param newMax The maximum stock allowed for this part
     * @param newMachineId The machineId of the machine that produces the part in house
     */
    public InHouse(int newId, String newName, double newPrice, int newStock, int newMin, int newMax, int newMachineId){
        super(newId,newName,newPrice,newStock,newMin,newMax);
        machineId = newMachineId;
    }

    /**
     * Sets the <code>machineId</code> of this <code>InHouse</code> part
     *
     * @param newMachineId the new machine ID
     */
    public void setMachineId(int newMachineId){
        machineId = newMachineId;
    }

    /**
     * Gets the <code>machineId</code> of this <code>InHouse</code> part
     *
     * @return int This returns the machineId of this InHouse part
     */
    public int getMachineId(){
        return machineId;
    }

}