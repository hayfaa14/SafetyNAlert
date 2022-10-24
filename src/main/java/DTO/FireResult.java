package DTO;

import java.util.List;

public class FireResult {
	
	
	private String station;
	private List<Resident> residents;
	
	public FireResult(String station, List<Resident> residents) {
		this.station=station;
		this.residents=residents;
		// TODO Auto-generated constructor stub
	}

	public void setResidents(List<Resident> res) {
		this.residents=res;
	
	}
	
	public List<Resident> getResidents() {
		return residents;
	}
	
	
	
	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}



	@Override
	public String toString() {
		return "{\"Residents\": [\n { \"Persons Covered\":\""+residents+"\", \"Station Number\":\""+station+"\"}\n]}";
	}
}
