package com.ricfonseca.util;

public class Constants {

	public static final String BEGIN_TXT = "Choose a number between  %d and  %d  in your mind and type 'ready' \n";
	public static final String IS_NUMBER_TXT = "Is the number %d ? ";
	public static final String INVALID_INPUT_0_TXT = "Invalid input";
	public static final String INVALID_INPUT_1_TXT = "Invalid input, please try again";
	public static final String YAHOO_TXT = "It was fun playing  with you!";
	public static final String SORRY_TXT = "I am sorry I could not guess your number.";
	
	
			
	public enum Response {
		READY("ready"),
		HIGHER("higher"),
	    LOWER("lower"),
	    YES("yes"),
	    END("end");

	    private final String text;

	    /**
	     * @param text
	     */
	    private Response(final String text) {
	        this.text = text;
	    }
	    
	    @Override
	    public String toString() {
	        return text;
	    }
	}
	
	
}
