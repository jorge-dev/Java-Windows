package com.jdev.java;

public class Main {

    public static void main(String[] args) {
	// write your code here

        League <Team<Footbal>> footballLeague = new League<>("La Liga");
        Team<Footbal> barcelona = new Team<>("Barcelona");
        Team<Footbal> realMadrid = new Team<>("Real Madrid");
        Team<Footbal> sevilla = new Team<>("Sevilla");
        Team<Footbal> villaReal = new Team<>("Villa Real");
        Team<Footbal> girona = new Team<>("Girona");

        Team<Baseball> chicago = new Team<>("Chicago Cubs");

        footballLeague.add(barcelona);
        footballLeague.add(realMadrid);
        footballLeague.add(sevilla);
        footballLeague.add(villaReal);
        footballLeague.add(girona);
      //  footballLeague.add(chicago);

        barcelona.matchResult(realMadrid,5,2);
        barcelona.matchResult(sevilla,2,1);
        sevilla.matchResult(realMadrid,4,1);


        footballLeague.showLeageTable();



        System.out.println();

    }
}
