/********************************************************************************************************************
 *   File Name: Vet.java
 *      Author: Mark Walters
 *        Date: 02/15/2015
 *       Class: CSCI 300
 * Description: Class that creates the Vet object for the Vet Driver. Uses Pet.java for the pet object.
 * ******************************************************************************************************************/
public class Vet implements Database
{
	private Pet[] listOfPets;
	private String nameOfVet;
	
	public Vet(String n, int size)
	{
		nameOfVet = n;
		listOfPets = new Pet[size];
	}
	
	@Override
	public int size() {
		return listOfPets.length;
	}
	@Override
	public void display() {
		System.out.println(nameOfVet);
		for (int i = 0; i < listOfPets.length; i++)
		{
			if(listOfPets[i] != null)
				System.out.println(listOfPets[i].toString());
		}
	}
	@Override
	public Pet find(String petName) {
		try {
			for(int i = 0; i < listOfPets.length; i++)
			{
				if (listOfPets[i] == null){return null;}
				if(petName.equalsIgnoreCase(listOfPets[i].name)){
					return listOfPets[i];
				}
			}
			return null;
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	@Override
	public boolean add(Pet p) 
	{
		for(int i = 0; i < listOfPets.length; i++)
			if(listOfPets[i] == null){
				listOfPets[i] = p;
				return true;
			}	
		return false;
	}
	@Override
	public boolean delete(Pet p) {
		for(int i = 0; i < listOfPets.length; i++){
			if(p == listOfPets[i])
			{
				listOfPets[i] = null;
				return true;
			}
		}
		return false;
	}
}
