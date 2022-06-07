package Opgave6;

public class Date {

    //Methods
    public String getSeason(int day, int month) {
        String season;

        if (month <= 3) {
            season = "Winter";
        } else if (month <= 6) {
            season = "Spring";
        }else if (month <= 9) {
            season = "Summer";
        }else {
            season = "Fall";
        }

        if (month % 3 == 0 && day >= 21) {
            if (season.equals("Winter")) {
                season = "Spring";
            } else if (season.equals("Winter")) {
                season = "Summer";
            } else if (season.equals("Winter")) {
                season = "Fall";
            } else {
                season = "Winter";
            }
        }

        return season;
    }
}
