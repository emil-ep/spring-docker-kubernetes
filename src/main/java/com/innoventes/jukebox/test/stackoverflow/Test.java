package com.innoventes.jukebox.test.stackoverflow;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        PatientInformation();
    }

    public static void PatientInformation ()
    {
        String[] patientsName = new String[50];
        int [] patientsAge = new int[50];
        String[] patientsGender = new String[50];
        String[] patientsPhone = new String[50];
        Scanner input = new Scanner (System.in);
        System.out.print("How many patients would you like to register? ");
        int num = input.nextInt();
        for(int i =0;i<num;i++)
        {
            System.out.println("Please enter the patient's name ");
            patientsName[i]=input.next();
            System.out.println("Please enter the patient's age ");
            patientsAge[i]=input.nextInt();   //outputs the above two lines at once and i get a compiler error
            System.out.println("Please enter the patient's gender ");
            patientsGender[i]=input.next();
            while (patientsGender[i].equalsIgnoreCase("female") == false && patientsGender[i].equalsIgnoreCase("male")== false)
            {
                System.out.print("Invalid information. Please enter male or female ");
                patientsGender[i]=input.next();
            }
            System.out.println("Please enter the patient's phone number ");
            patientsPhone[i]=input.next();
            while(patientsPhone[i].length()!= 10)
            {
                System.out.print("Invalid number. Please enter 10 digits ");
                patientsPhone[i]=input.next();
            }

        }
        System.out.print("Would you like to display the patient information?\nEnter yes or no ");
        String ans = input.next();
        if(ans.equalsIgnoreCase("yes"))
        {
            System.out.println("Patient name      Age       Gender       Phone Number\n-----------------------------------");

            for(int j =0;j<num;j++)
            {
                System.out.println(patientsName[j]+"    "+patientsAge[j]+"    "+patientsGender[j]+"    "+patientsPhone[j] );
            }
        }
        else
            return;
    }
}
