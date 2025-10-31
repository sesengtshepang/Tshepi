/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tv_series_application;

//(OpenAI, 2022)
//(www.w3schools.com, n.d.)
//(Lee, 2019)
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class SeriesModel {
//Declaration of Scanner and Arraylist

    Scanner scanner = new Scanner(System.in);
    ArrayList<SeriesModel> seriesList = new ArrayList<>();

    //Variables
    public String seriesid;
    public String seriesName;
    public String seriesAge;
    public String seriesNumberOfEpisodes;

    //Default constructor
//    public SeriesModel() {
//    }
    //Get and set methods
    public String getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(String seriesid) {
        this.seriesid = seriesid;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(String seriesAge) {
        this.seriesAge = seriesAge;
    }

    public String getSeriesNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }

    public void setSeriesNumberOfEpisodes(String seriesNumberOfEpisodes) {
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Input methods
    public void Seriesid() {
        System.out.print("Enter the series id: ");
        this.seriesid = scanner.nextLine();
    }

    public void SeriesName() {
        System.out.print("Enter the series name: ");
        this.seriesName = scanner.nextLine();
    }

    public void SeriesAge() {
        System.out.print("Enter the series age restriction: ");
        this.seriesAge = scanner.nextLine();
    }

    public void SeriesNumberOfEpisodes() {
        System.out.print("Enter the number of episodes for Extreme Sports: ");
        this.seriesNumberOfEpisodes = scanner.nextLine();
    }

    //Main methods
    public void Menu() {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("**************************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");

        try {
            int selection = Integer.parseInt(scanner.nextLine());

            while (selection == 1) {
                System.out.println("Please select one of the following menu items: ");
                System.out.println("(1) Capture a new series");
                System.out.println("(2) Search for a series");
                System.out.println("(3) Update a series age restriction");
                System.out.println("(4) Delete a series ");
                System.out.println("(5) Print series report- 2025");
                System.out.println("(6) Exit application");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) { //based on choice a method is initiated
                    case 1:
                        CaptureSeries();
                        break;
                    case 2:
                        SearchSeries();
                        break;
                    case 3:
                        UpdateSeries();
                        break;
                    case 4:
                        DeleteSeries();
                        break;
                    case 5:
                        SeriesReport();
                        break;
                    case 6:
                        ExitSeriesApplication();
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }

                System.out.print("Enter (1) to continue or any other key to exit: ");
                selection = Integer.parseInt(scanner.nextLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("Exiting application...");
        }
    }

    public void CaptureSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("***************************");
        System.out.print("How many series do you want to enter?: ");
        int seriesCounter = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < seriesCounter; i++) {
            System.out.println("\n--- Series number: " + (i + 1)); //which number user is at

            //(OpenAI, 2022)
            //newSeries to populate array based on the capture
            SeriesModel newSeries = new SeriesModel();
            newSeries.Seriesid();
            newSeries.SeriesName();
            newSeries.SeriesAge();
            newSeries.SeriesNumberOfEpisodes();

            seriesList.add(newSeries);
        }

        System.out.println("Series processed successfully!!!");

    }

    public String ageRestriction() {
        SeriesAge();
        int age;
        //(Lee, 2019)
        while (true) {
            //try catch is meant to test risky code and clarify errors, i think
            try {
                age = Integer.parseInt(seriesAge); //convert the string to int

                if (age >= 2 && age <= 18) {
                    return String.valueOf(age); //return the value of int as a string 
                } else {
                    System.out.println("You have entered an incorrect series age!!!");
                }
            } catch (Exception e) { //Specific exception would be a NumberFormatException
                System.out.println("Please enter numbers only");
            }
            System.out.println("Please re-enter the series age >>");
            getSeriesAge();
        }
    }

    public void SearchSeries() {
        System.out.print("Enter the series id to search : ");
        String searchID = scanner.nextLine();
        System.out.println("-----------------------------------------------------");

        //(www.w3schools.com, n.d.)
        for (SeriesModel s : seriesList) { //creates variable (s) from object SeriesModel to be able to go through info within the arraylist
            if (s.getSeriesid().equals(searchID)) {
                System.out.println("SERIES ID: " + s.seriesid);
                System.out.println("SERIES NAME: " + s.seriesName);
                System.out.println("SERIES AGE RESTRICTION: " + s.seriesAge);
                System.out.println("SERIES NUMBER OF EPISODES: " + s.seriesNumberOfEpisodes);
                System.out.println("---------------------------------------------");
                break;
            }
        }
        if (false) {
            System.out.println("Series with SeriesID: " + searchID + " was not found!");
            System.out.println("-----------------------------------------------------");
        }
    }

    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age restriction: ");
        String age = scanner.nextLine();
        System.out.print("Enter the number of episodes: ");
        String episodes = scanner.nextLine();

        for (SeriesModel s : seriesList) {
            if (s.getSeriesid().equals(id)) {
                s.setSeriesName(name);
                s.setSeriesAge(age);
                s.setSeriesNumberOfEpisodes(episodes);
                break;
            }
        }
    }

    public void DeleteSeries() {
        System.out.print("Enter series id to delete: ");
        String deleteID = scanner.nextLine();
        System.out.println("Are you sure you want to delete series " + deleteID + " from the system? Yes (y) to delete.");
        String yesOrNo = scanner.nextLine();
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesid().equals(deleteID) && "y".equals(yesOrNo)) {
                seriesList.remove(i);
                System.out.println("Series with Series ID: " + deleteID + " WAS deleted!");
                System.out.println("----------------------------------------------------");
            }
        }
    }

    public void SeriesReport() {
        for (int i = 0; i < seriesList.size(); i++) {
            for (SeriesModel s : seriesList) {
                System.out.println("Series " + (i + 1));
                System.out.println("------------------------------------------------");
                System.out.println("SERIES ID: " + s.seriesid);
                System.out.println("SERIES NAME: " + s.seriesName);
                System.out.println("SERIES AGE OF RESTRICTION: " + s.seriesAge);
                System.out.println("NUMBER OF EPISODES: " + s.seriesNumberOfEpisodes);
                System.out.println("------------------------------------------------");
            }
        }
    }

    public void ExitSeriesApplication() {
        System.out.println("Thank you for using this application. Goodbye");
        scanner.close();
        System.exit(0);
    }

//    NOTE FOR MYSELF!!!!!
    //static void means that it shouldn't be subject to change but user info is constantly changing
}

//Reference list 
//OpenAI (2022). ChatGPT. [online] ChatGPT. Available at: https://chatgpt.com/ [Accessed 28 Aug. 2025].
//www.w3schools.com. (n.d.). Java Loop Through an Array. [online] Available at: https://www.w3schools.com/java/java_arrays_loop.asp [Accessed 29 Aug. 2025].
//Lee, A. (2019). Try Catch Java Tutorial. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=ceGnVDrMy1A [Accessed 30 Aug. 2025].