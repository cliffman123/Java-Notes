
public class ManagementCompany {
	private final int MAX_PROPERTY = 5;
	private double mgmFee;
	private String name;
	private Property [] properties;
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int x = 0;
	
	public ManagementCompany() {
		name = " ";
		taxID = " ";
		mgmFee = 0;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFee = otherCompany.mgmFee;
		plot = otherCompany.plot;
		properties = new Property[MAX_PROPERTY];
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	public int addProperty(Property property) {
		int result;
		if (property == null) {
			result = -2;
		}
		else if (plot.encompasses(property.getPlot())) {
			result = -3;
		}
		else if (x < properties.length) {
			result = -1;
			properties[x] = property;
			result = x;
			x++;
		}
		else {
			result = -1;
		}
		for  (int i = 0; i < properties.length; i++) {
			 if (properties[i].getPlot().overlaps(property.getPlot())) {
				 result = -4;
			 }
		}
		return result;
	}
	public int addProperty(String name, String city, double rent, String owner) {
		int result;
		if (x < MAX_PROPERTY) {
			properties[x] = new Property(name, city, rent, owner);
			result = x;
			x++;
		}
		else {
			result = -1;
		}
		return result;
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		int result;
		
		if (x < MAX_PROPERTY) {
			properties[x] = new Property(name, city, rent, owner, x, y, width, depth);
			result = x;
			x++;
		}
		else {
			result = -1;
		}
		return result;
	}
	public double totalRent() {
		double total = 0;
		for(int i = 0; i < MAX_PROPERTY; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}
	public double maxRentProp() {
		double temp = properties[0].getRentAmount();
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(temp < properties[i].getRentAmount()) {
				temp = properties[i].getRentAmount();
			}
		}
		return temp;
	}
	public int maxPropertRentIndex() {
		int index = 0;
		double temp = properties[0].getRentAmount();
		for(int i = 0; i < properties.length; i++) {
			if(temp > properties[i].getRentAmount()) {
				index = i;
			}
		}
		return index;
	}
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	public String toString() {
		String output = " ";
		for(int i = 0; i < MAX_PROPERTY; i++) {
			output += properties[i].toString();
		}
		return ("List of the properties for Mananagemen Company, "+ "Alliance, taxid, 1235"
				+ "\n-------------------------------------------\n"+
		output+
		"-------------------------------------------\ntotal management Fee:"+this.mgmFee);
	}
}
