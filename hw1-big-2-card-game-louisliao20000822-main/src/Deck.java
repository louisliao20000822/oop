

import java.util.Scanner;

public class Deck {
	
	Card[] card = new Card[52];

	 public  Deck() {
		 for(int i=0;i<52;i++)
		 card[i]= new Card();
	 }
	 
	 public void print_deck() {
		 for(int i=0;i<52;i++)
		 System.out.println(card[i].get_suit()+"["+card[i].get_rank()+"]");
	 }
	 public int Deal(Player P[]) {
		 int count =0;
		 int club_3 = -1;
		 for(int i=0;i<13;i++) {
			 for(int j=0;j<4;j++)
			 {
		     if(card[count].get_card().equals("C[3]"))
		     {
		    	 club_3 = count % 4;
		     }
			 P[j].set_hand_card(i,card[count].get_rank() ,card[count].get_suit());
			 count++;			 
			 }
		 }
		 return club_3;
	 }
	 
	 
	 
	}

