package kursovaya;


public class Sport{

    public String sport;
    public int countries;
    public String isOlympic;

    static Sport makeSport(String sport) {
        String[] st = sport.split(" ");
        return new Sport(st[0], Integer.parseInt(st[1]), st[2]);
    }

    public Sport() {
    }

    public Sport(String sport, int countries, String isOlympic) {
        this.sport = sport;
        this.countries = countries;
        this.isOlympic = isOlympic;
    }

    public String getSport() {
        return sport;
    }

    public int getCountries() {
        return countries;
    }

    public String getIsOlympic() {
        return isOlympic;
    }

    @Override
    public String toString() {
        return sport + " " + countries + " " + isOlympic;
    }

}
