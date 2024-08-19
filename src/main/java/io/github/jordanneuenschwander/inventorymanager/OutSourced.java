package io.github.jordanneuenschwander.inventorymanager;
/**
 * The <code>OutSourced</code> class extends the <code>Part</code> class. It stores information about parts that
 * are not produced in house.
 * Refer to the {@link io.github.jordanneuenschwander.inventorymanager.Part} class for inherited member variables and functions
 *
 * @author Jordan Neuenschwander
 * @version 1.0
 */
public class OutSourced extends Part{
    /**
     * This is the name of the company that the <code>Outsourced</code> part is supplied from.
     */
    private String companyName;

    /**
     * Constructs an instance of the <code>OutSourced</code> class. Calls the constructor of the extended class <code>Part</code>.
     *
     * @param newId The id of the part
     * @param newName The name of the part
     * @param newPrice The price of the part
     * @param newStock The inventory level or stock amount of the part
     * @param newMin The minimum stock allowed for this part
     * @param newMax The maximum stock allowed for this part
     * @param newCompanyName The name of the company that the <code>Outsourced</code> part is supplied from.
     */
    public OutSourced(int newId, String newName, double newPrice, int newStock, int newMin, int newMax, String newCompanyName){
        super(newId, newName, newPrice, newStock, newMin, newMax);
        companyName = newCompanyName;
    }

    /**
     * Returns the company name of the company that the <code>OutSourced</code> part has been sourced from
     *
     * @return String the name of the source company
     */
    public String getCompanyName(){
        return companyName;
    }

    /**
     * Sets the name of the company that this <code>OutSourced</code> part has been sourced from
     *
     * @param newCompanyName the company name to set for this part
     */
    public void setCompanyName(String newCompanyName){
        companyName = newCompanyName;
    }
}