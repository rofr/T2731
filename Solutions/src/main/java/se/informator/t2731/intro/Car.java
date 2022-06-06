package se.informator.t2731.intro;

public class Car {

	private final String type;
	private final int productionYear;
	private String regNo;
	private String owner;
	
	public Car(String type, int productionYear, String regNo, String owner) {
		this.type = type;
		this.productionYear = productionYear;
		this.regNo = regNo;
		this.owner = owner;
	}

	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}

	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the productionYear
	 */
	public int getProductionYear() {
		return productionYear;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [type=");
		builder.append(type);
		builder.append(", productionYear=");
		builder.append(productionYear);
		builder.append(", regNo=");
		builder.append(regNo);
		builder.append(", owner=");
		builder.append(owner);
		builder.append("]");
		return builder.toString();
	}
	
}
