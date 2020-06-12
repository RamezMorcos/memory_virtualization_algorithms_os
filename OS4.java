/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os4;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author HP450
 */
/**
 * @param args the command line arguments
 */
class OS4 {

    int fn, bn,mm;
    int[] partition, block, allocation;
    boolean AVAILABLE=true;

    
    void Inputs() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of memory: ");
        int M = input.nextInt();

  
        System.out.println("Enter the number of partition");
        fn = input.nextInt();
        System.out.println("Enter the number of blocks");
        bn = input.nextInt();

        partition = new int[fn];
        block = new int[bn];
        allocation = new int[fn];

        System.out.println("Enter the Size of each partition");
        for (int i = 0; i < fn; i++) {
            partition[i] = input.nextInt();
          
        }
        System.out.println("Enter the size of each block");
        for (int i = 0; i < bn; i++) {
            block[i] = input.nextInt();
              mm+=block[i];
        }

        for (int i = 0; i < fn; i++) {
            allocation[i] = -1;
        }
        System.out.println("You want to see the memory size now?  memory size=  ");
        System.out.println(mm);
    }

    void BestFit() {
        System.out.println("  The BEST Fit Start ");
        for (int i = 0; i < fn; i++) {
            int bfit = 0;
            for (int j = 0; j < bn; j++) {
                if (partition[i] <= block[j]) {
                    if (bfit == 0 && AVAILABLE==true) {
                        bfit = j;
                    } else if (block[bfit] > block[j]) {
                        bfit = j;
                    }
                }
            }
            if (bfit != 0) {
                allocation[i] = bfit;
                block[bfit] = block[bfit] - partition[i];
                if(block[bfit]==0){
                   AVAILABLE=true; 
                }
                else{
                    AVAILABLE=false;
                }

            }
        }
        System.out.println("  The BEST Fit DONE  ");
    }

    public void Result() {
        System.out.println("Process, Alllocated Partition Size,Address of the allocated partition");
        for (int i = 0; i < fn; i++) {
            System.out.print((i + 1) + " \t " + partition[i] + " \t ");
            if (allocation[i] != -1) {
               System.out.print(allocation[i]+1 );
               System.out.println();
            } else {
               
                System.out.print(  allocation[i]);
                System.out.println();
            }
        }
    }

    public void FirstFit() {
        System.out.println("  The First Fit Start ");

        for (int i = 0; i < fn; i++) {
            for (int j = 0; j < bn; j++) {
                if (partition[i] < block[j]) {
                    allocation[i] = j;
                    block[j] = block[j] - partition[i];
                    break;
                }
            }
        }
        System.out.println("  The FIRST Fit DONE ");
    }

    public void WorstFit() {
        System.out.println("  The Worst Fit Start ");
         System.out.println(" HER FN"+fn +" BN"+ bn);
        for (int i = 0; i < fn; i++) {
            int Wfit = 0;
            for (int j = 0; j < bn; j++) {
                if (partition[i] <= block[j]) {
                    if (Wfit == 0) {
                        Wfit = j;

                    } else if (block[Wfit] < block[j]) {
                        Wfit = j;
                    }
                }
            }
            
            if (Wfit != 0) {
                allocation[i] = Wfit;
                block[Wfit] = block[Wfit] - partition[i];
            }
           
        }
         System.out.println("  The Worst Fit DONE  ");
    }

    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println("Enter the size of memory: ");
        Scanner input = new Scanner(System.in);
//        int M = input.nextInt();

        OS4 s = new OS4();
        System.out.println("Enter Number of the allocated method");
        System.out.println("1)Best Fit \t\t 2)First Fit \t\t 3)WorstFit");

        int M = input.nextInt();
        switch (M) {
            case 1:
                //        s.BestFit();
                s.Inputs();
                s.BestFit();
                s.Result();
                break;
            case 2:
                s.Inputs();
                s.FirstFit();
                s.Result();
                break;
            case 3:
                s.Inputs();
                s.WorstFit();
                s.Result();
                break;
            default:
                System.out.println("Wrong input TRY AGAIN");
                break;
        }

    }
}
