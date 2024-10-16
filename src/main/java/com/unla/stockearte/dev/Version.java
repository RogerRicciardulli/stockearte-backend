package com.unla.stockearte.dev;

public enum Version {

	V0_0_1("0.0.1", "Primera version para stockearte", "20240906"),
	V1_0_0("1.0.0", "Segunda version para stockearte", "20240923"),
	V3_0_0("3.0.0", "Tercera version para stockearte", "20241011"),
	ACTUAL(V3_0_0);
	
	private String versionNumber;
	private String description;
	private String fecha;
	
	private Version(String versionNumber, String description, String fecha) {
		this.versionNumber = versionNumber;
		this.description = description;
		this.fecha = fecha;
	}

	private Version(Version version) {
		this.versionNumber = version.versionNumber;
		this.description = version.description;
		this.fecha = version.fecha;
	}
	
	public String longDescription() {
		return versionNumber + " - " + fecha + " - " + description;
	}
	
}

