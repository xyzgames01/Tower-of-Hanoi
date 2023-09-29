package com.game.towerofhanoi;

import java.util.ArrayList;
import java.util.Scanner;

public class TowerDriver {

    public static Scanner scanObj = new Scanner(System.in);

    public static ArrayList<LinkedStack<Integer>> Towers = new ArrayList<>();

    // The method that adds a dynamic amount of disks inputted by the player.
    public static void createTower(int n){

        for (int i = 0; i < 3; i++){
            Towers.add(new LinkedStack<>());
        }

        for (int i = n; i >= 1; i--){
            Towers.get(0).push(i);
        }
    }

    // The Method that handles selecting a from a tower
    public static void rearrangeFromDisk(){

        //Asks User What tower to move a disk FROM
        System.out.println("Choose a tower to move FROM: (1-3)");

        //The Scanner
        int towerFrom;
        towerFrom = scanObj.nextInt();

        //The first of many checks to see if it's a valid Tower.
        //This One Checks to See if the scanner has 1 2 or 3.
        if (towerFrom >= 1 && towerFrom <= 3){

            //Checks to see if the Stack we are selecting FROM is empty. if not, On to the next check
            if (Towers.get(towerFrom - 1).isEmpty()){
                System.out.println("Stack is Empty Try Again");
                rearrangeFromDisk();
            }
            else {
                //This Checks to see if there is even a valid spot to put the selected Disk.
                //A valid spot is A stack that is empty or has a value less than the top value of the stack we are selecting from
                for (int i = 0; i < 3; i ++){
                    if(!Towers.get(i).isEmpty()){
                        if(Towers.get(towerFrom - 1).peek() >= Towers.get(i).peek()){
                            if(i == 2){
                                break;
                            }
                        }else{
                            rearrangeToDisk(towerFrom);
                        }
                    }else {
                        rearrangeToDisk(towerFrom);
                    }
                }
                System.out.println("Invalid stack selection, disk can't move anywhere");
                rearrangeFromDisk();
            }
        }else {
            System.out.println("Invalid tower index try again");
            rearrangeFromDisk();
        }
    }

    // The method that handles putting a disk on to a tower.
    public static void rearrangeToDisk(int n){

        //Asks User What tower to move a disk TO
        System.out.println("Choose a tower to move TO: (1-3)");

        int towerTo;
        towerTo = scanObj.nextInt();

        // Checks if the move to tower isn't the same as the move from tower
        if (towerTo != n){
            //Checks if the number is a valid tower index
            if (towerTo >= 1 && towerTo <= 3){
                //Checks to see if the tower is not empty if it is, ignore the size check and place the disk
                if (!Towers.get(towerTo - 1).isEmpty()){
                    //Checks to see if the current disk selected is smaller than the top disk, if not, tell the player
                    if (Towers.get(n - 1).peek() > Towers.get(towerTo - 1).peek()){
                        System.out.println("Disk is too big");
                        rearrangeToDisk(n);
                    }else {
                        addToTower(towerTo,n);
                    }
                }else {
                    addToTower(towerTo,n);
                }

            }else {
                System.out.println("Invalid tower index try again");
                rearrangeToDisk(n);
            }
        }else{
            System.out.println("Invalid Stack Try Again");
            rearrangeToDisk(n);
        }
    }

    //Adds the Disk from the selected tower to the new tower and displays the towers
    public static void addToTower(int towerTo, int n){
        Towers.get(towerTo - 1).push(Towers.get(n - 1).pop());
        System.out.println("Stack 1: " + Towers.get(0));
        System.out.println("Stack 2: " + Towers.get(1));
        System.out.println("Stack 3: " + Towers.get(2));
        rearrangeFromDisk();
    }

    public static void main(String[] args){
        System.out.println("Choose Disk Amount");

        int disks;
        disks = scanObj.nextInt();

        createTower(disks);
        rearrangeFromDisk();
    }

}
