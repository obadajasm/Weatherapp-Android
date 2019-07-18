package com.obadajasm.weatherapp;

import org.json.JSONObject;

public class WeatherDataModel {

    // TODO: Declare the member variables here
     private    String temperature;
    private   String city;
    private  String iconName;
    private  int condition;


    // TODO: Create a WeatherDataModel from a JSON:
        public  static WeatherDataModel fromJson(JSONObject jsonObject){
            try {


                WeatherDataModel weatherData = new WeatherDataModel();
                weatherData.city = jsonObject.getString("name");
                weatherData.condition= jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
                weatherData.iconName= updateWeatherIcon(weatherData.condition);
            double tempresult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
                int roundedvalueoftemp= (int)Math.rint(tempresult);
                weatherData.temperature= Integer.toString(roundedvalueoftemp);
                return weatherData;
            }catch (Exception e){
                e.printStackTrace();

            }
            return null;
        }

    // TODO: Uncomment to this to get the weather image name from the condition:
    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    // TODO: Create getter methods for temperature, city, and icon name:


    public String getTemperature() {
        return temperature  + "°";
    }

    public String getCity() {
        return city;
    }

    public String getIconName() {
        return iconName;
    }
}
