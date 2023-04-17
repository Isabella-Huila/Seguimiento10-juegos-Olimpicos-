import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class CountryList {

    private ArrayList<Country> countries;
    static String path= "data.txt";
    public CountryList() {
        this.countries = new ArrayList<>();
    }
    public void save() throws IOException{
        File file= new File(path);
        FileOutputStream fos=new FileOutputStream(file);

        Gson gson= new Gson();
        String data=gson.toJson(countries);

        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }
    public void load()throws IOException{
        File file= new File(path);
        if (file.exists()){
            FileInputStream fis= new FileInputStream(file);
            BufferedReader reader= new BufferedReader(new InputStreamReader(fis));

            String content= "";
            String line= "";
            while ( (line= reader.readLine()) != null){
                content += line + "\n";
            }
            Gson gson= new Gson();
            Country[] array= gson.fromJson(content, Country[].class);
            Collections.addAll(countries, array);
            fis.close();
        }else {
            file.createNewFile();
        }
    }
    public void addCountry(String[] date) throws IOException {

        Country searched = null;
        for (int i = 0; i < countries.size() && searched==null; i++) {
            Country current = countries.get(i);
            if(current.getName().equals(date[0])) {
                searched = current;
            }
        }
        if(searched!=null) {
            searched.addMedals(date[1] , Integer.parseInt(date[2]));

        }else {
            Country newCountry= new Country(date[0]);
            newCountry.addMedals(date[1], Integer.parseInt(date[2]));
            countries.add(newCountry);
        }
        save();
    }
    public void showMedals(){
        Collections.sort(countries);
        printMedals();
    }
    public void totalMedals(){
        Collections.sort(countries, (a,b)-> {
            int criterionOne= b.getTotalMedals() - a.getTotalMedals();
            if (criterionOne == 0){
                return a.getName().compareTo(b.getName());
            }else {
                return criterionOne;
            }
        });
        System.out.println("------------[Medals]---------------\n");
        countries.forEach(country -> {
            System.out.println( country.getName()+" " + "Total Medals: " + country.getTotalMedals());
        });
    }
    public void insertionSort(){
        for(int i=1;i < countries.size();i++){

            for(int j=0 ; j < countries.size()-1 ; j++){

                if(countries.get(i).getName().compareTo(countries.get(j).getName()) < 0){

                    Country x= countries.get(j);
                    Country y= countries.get(i);

                    countries.set(i, x);
                    countries.set(j, y);

                }
            }
        }
        printCountrys();
    }
    public void printMedals(){
        System.out.println("------------[Medals]---------------\n");
        countries.forEach(country -> {
            System.out.println( country.getName()+ " " + "Gold: " + country.getGold() + " "+ "Silver: " + country.getSilver()+" "+ "Bronze: " +country.getBronze());
        });
    }
    public void printCountrys(){
        System.out.println("------------[Countrys]---------------\n");
        countries.forEach(country -> {
            System.out.println(country.getName());
        });

    }}
