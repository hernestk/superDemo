package lab1;

public class Weather {
	private String weather;
	private String day;
	private int percipitation;
	private int degrees;

	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;	
	}
	
	public int getPercipitation() {
		return percipitation;
	}
	
	public void setPercipitation(int percipitation) {
		this.percipitation = percipitation;
	}
	
	public int getDegrees() {
		return degrees;
	}

	public void setDegrees(int degrees) {
		this.degrees = degrees;
	}

	public String getWeather(boolean prediction) {
		if(percipitation > 50 && ((degrees > 30) && (degrees <60))){
			weather = "It is going to rain for sure. Better grab an umbrella!";
		}
		else if (percipitation > 50 && degrees > 60) {
			weather = "There's a chance of rain but I'm not really feeling it.";
		}
		else if (percipitation > 50 && ((degrees < 30))) {
			weather = "Look out, snow incoming! Grab a sled and go down a hill!";
		}
		else if((percipitation <50 && percipitation>30 )&& degrees < 60) {
			weather = "Looking like clouds on the horizon. Sweater weather for sure!";
		}
		else if (percipitation < 50 && degrees > 60) {
			weather = "Sun sun sun nothing but sun. Perhaps a picnic!";
		}
		else if ((percipitation < 50 && percipitation >30) && degrees < 30) {
			weather = "Wind wind and more wind! Grab a jacket for sure!";
		}
		else if (percipitation < 30 && degrees < 30) {
			weather = "It'll be cold but dry!";
		}
		else {
			weather = "I really don't know, you should go find out for us!";
		}
		
		if (prediction == false) {
			return "Here is the weather for " + day + ". It will be " + degrees + " degrees and the percipitation will be " + percipitation + "%. \n" + weather;
		}else return "Based on your inputs, my prediction for " + day + " is: \n" + weather;
		
	}
	
	public void setWeather(String weather) {
		this.weather = weather;
	}
}
