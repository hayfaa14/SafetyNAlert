package com.OC.SafetyNAlert.service.URL;

import java.util.HashMap;
import java.util.List;

import DTO.Household;
import DTO.HouseholdMember;

public interface IFloodService {

	public HashMap<String, List<HouseholdMember>> getHouseholds(String station);

}
