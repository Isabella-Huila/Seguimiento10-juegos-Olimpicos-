public class Country  implements  Comparable<Country> {


    private String name;
    private int silver;
    private int gold;
    private int bronze;
    private int totalMedals;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public int getTotalMedals() {
        return totalMedals;
    }

    public void setTotalMedals(int totalMedals) {
        this.totalMedals = totalMedals;
    }


    public void addMedalsGold(int medalsGold) {
        gold = gold + medalsGold;
    }

    public void addMedalsSilver(int medalsSilver) {

        silver = silver + medalsSilver;

    }

    public void addMedalBronze(int medalsBronze) {

        bronze = bronze + medalsBronze;
    }


    public void addMedals( String medal, int add) {

        if (medal.equalsIgnoreCase("gold")) {
            addMedalsGold(add);
        } else if (medal.equalsIgnoreCase("silver")) {
            addMedalsSilver(add);
        } else if (medal.equalsIgnoreCase("bronze")) {
            addMedalBronze(add);
        }
        totalMedals = gold + bronze + silver;
    }

    @Override
    public int compareTo(Country o) {

        int criterionOne= o.gold - this.gold;
        if (criterionOne==0){
            int criterionTwo= o.silver - this.silver;
            if (criterionTwo == 0){
                int criterionThree= o.bronze - this.bronze;
                if (criterionThree == 0){
                    return this.name.compareTo(o.name);
                }else {
                    return criterionThree;
                }
            }else {
                return criterionTwo;
            }
        }else {
            return criterionOne;
        }

    }
}
