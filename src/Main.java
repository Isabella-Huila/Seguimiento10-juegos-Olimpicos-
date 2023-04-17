import java.io.IOException;
import java.util.Scanner;

public class Main {
        static CountryList countryList = new CountryList();
        public static void main(String[] args) throws IOException {
            countryList.load();
            Scanner scanner= new Scanner(System.in);
            while (true){
                System.out.println("--------------[Menú]--------------");
                System.out.println("welcome to the 2024 olympics");
                System.out.println(" 1. Enter a country\n 2. show medals \n 3. show total medals \n 4. show countries \n 0. exit\n");
                int option= Integer.parseInt(scanner.nextLine());
                switch (option){
                    case 1:
                        System.out.println("Write the answear with the format Country::Medal type::Amount");
                        System.out.println("For example : Chile::Silver::5");
                        String input= scanner.nextLine();
                        String[] data= input.split("::");
                        countryList.addCountry(data);
                        break;
                    case 2:
                        countryList.showMedals();
                        break;
                    case 3:
                        countryList.totalMedals();
                        break;
                    case 4:
                        countryList.insertionSort();
                        break;
                    case 0:
                        System.out.println("Thank you for using this app :)");
                        System.exit(0);

                        break;

                    default:
                        System.out.println("Invalid option. Try again");
                        break;
                }
            }
        }
    }