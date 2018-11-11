package com.forcepoint.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Rough2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> listOne = new ArrayList(Arrays.asList("3", "4", "2", "5", "8 "));

		for (String s : listOne) {
		}
		List<Integer> listTwo = new ArrayList(Arrays.asList("22", "44", "33", "5", "1"));

		
		List<String> sourceList = new ArrayList<String>(listOne);
		List<Integer> destinationList = new ArrayList<Integer>(listTwo);

		Collections.sort(listTwo);
		System.out.println(listTwo);
		// sourceList.removeAll(listTwo);
		// destinationList.removeAll(listOne);

//		System.out.println(sourceList);
//		System.out.println(destinationList);
		
		 List<Integer> lList = new ArrayList<Integer>();

	        lList.add(22);       
	        lList.add(44);
	        lList.add(33);
	        lList.add(5);
	        lList.add(1);


	        Collections.sort(lList);

            System.out.println(lList);

            for (int i = 0; i < listOne.size(); i++) {
				lList.add(Integer.parseInt(listOne.get(i)));

			}
	        
	        for(int i=0; i<lList.size();i++ )
	        {
//	            System.out.println(lList.get(i));
	        }

		

	}

}
