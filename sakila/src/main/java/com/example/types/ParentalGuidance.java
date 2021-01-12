package com.example.types;

public enum ParentalGuidance {
	Unrated(null),
	GeneralAudiences ("G"),
	ParentalGuidanceSuggested ("PG"),
	ParentsStronglyCautioned ("PG-13"),
	Restricted ("R"),
	AdultsOnly ("NC-17");

	private final String code;
	ParentalGuidance(String code) {
		this.code = code;
	}
    public String getCode() {
        return code;
    }
    public static ParentalGuidance fromCode(String code) {
    	if(code == null) return Unrated;
    	switch (code) {
		case "": return Unrated;
		case "G": return GeneralAudiences;
		case "PG": return ParentalGuidanceSuggested;
		case "PG-13": return ParentsStronglyCautioned;
		case "R": return Restricted;
		case "NC-17": return AdultsOnly;
		default: throw new UnsupportedOperationException("The code " + code + " is not supported!");
		}
    }

}
