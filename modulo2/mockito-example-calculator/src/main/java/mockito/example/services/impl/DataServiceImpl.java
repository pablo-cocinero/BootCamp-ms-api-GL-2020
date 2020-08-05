package mockito.example.services.impl;

import mockito.example.services.DataService;

public class DataServiceImpl implements DataService {

	int[] listOfNumbers;
	
	public DataServiceImpl() {}
	
	public DataServiceImpl(int[] listOfNumbers) 
	{
		this.listOfNumbers = listOfNumbers;
	}
	
	public void setListOfNumbers(int[] listOfNumbers) {
		this.listOfNumbers = listOfNumbers;
	}
	
 	@Override
	public int[] getListOfNumbers() {
		return listOfNumbers;
	}

}
