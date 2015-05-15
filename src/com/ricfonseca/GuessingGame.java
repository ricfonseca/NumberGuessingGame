package com.ricfonseca;

import java.util.Scanner;

import com.ricfonseca.util.Constants;

public class GuessingGame {

	private static final int MAX_NUMBER = 100;
	private int lowValue = 0;
	private int highValue = MAX_NUMBER;
	

	/**
	 * Main Class
	 * @param args
	 */
	public static void main(String[] args) {		
		GuessingGame guessingGame = new GuessingGame();
		guessingGame.startGame();
		
	}
	
	/**
	 * startGame
	 */
	public void startGame(){
		boolean gameRunning = true;
		
		//First choose a number
		System.out.format(Constants.BEGIN_TXT, lowValue, highValue );
		Scanner input = new Scanner(System.in);
		
		//Initialize guess Number 
		int number = calculateNumber(0,null);
		
		
		//isReady to start the game
		if(input.next().trim().equalsIgnoreCase(Constants.Response.READY.toString())){			
			
			do{								
				System.out.format(Constants.IS_NUMBER_TXT, number);
				input = new Scanner(System.in);
				String inputTxt = input.next();
				
				if(isValidInput(inputTxt)){
					if(inputTxt.trim().equalsIgnoreCase(Constants.Response.YES.toString())){
						gameRunning=false;
						System.out.println(Constants.YAHOO_TXT);
						
					} else if(inputTxt.trim().equalsIgnoreCase(Constants.Response.END.toString())){
						gameRunning=false;
						System.out.println(Constants.SORRY_TXT);
						
					} else {
						//Calculate a new Number
						number=calculateNumber(number, inputTxt);
					}
				} else {
					System.out.println(Constants.INVALID_INPUT_1_TXT);
				}
			}while(gameRunning);
		} else {
			System.out.println(Constants.INVALID_INPUT_0_TXT);
		}
		
		input.close();
	}
	
	/**
	 * Validates input value
	 */
	private boolean isValidInput(String inputValue){		
		boolean isValid=false;
		//Iterates over the valid values
		for (Constants.Response response :(Constants.Response.values())){
				if(inputValue.trim().equalsIgnoreCase(response.toString())){
					isValid=true;
				}
			}		
		return isValid;
	}
	
	/**
	 * Calculates a guessing Number
	 * @param calculatedNumber
	 * @param inputValue
	 * @return
	 */
	public int calculateNumber(int calculatedNumber, String inputValue){
				
		if(inputValue!= null){
			if(inputValue.trim().equalsIgnoreCase(Constants.Response.HIGHER.toString())){
				lowValue = calculatedNumber;				 
			} else if(inputValue.trim().equalsIgnoreCase(Constants.Response.LOWER.toString())){
				highValue = calculatedNumber;
			}
		}
		
		calculatedNumber=(highValue+lowValue)/2;
		
		return calculatedNumber;
	}

}
