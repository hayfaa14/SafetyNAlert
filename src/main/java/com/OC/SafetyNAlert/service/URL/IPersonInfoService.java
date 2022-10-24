package com.OC.SafetyNAlert.service.URL;

import java.util.List;


import DTO.PersonInfo;

public interface IPersonInfoService {

	List<PersonInfo> getPersonInfo(String firstName, String lastName);

}
