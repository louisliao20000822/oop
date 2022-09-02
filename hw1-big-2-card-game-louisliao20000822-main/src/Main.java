
import java.util.Scanner;

public class Main {
	
	public static void main (String[] arg) {
		Scanner sc = new Scanner(System.in);
		Deck S_deck = new Deck();
		Game game = new Game();
		int END = 0;
		boolean first = true;
		Player player[] = new Player[4];	
			 for(int i=0;i<4;i++)
			 player[i]= new Player();
		
		for(int i=51;i>=0;i--){		
				String card_info = sc.next();
		        S_deck.card[i].set_suit(card_info.charAt(0));
		        S_deck.card[i].set_rank(card_info.charAt(2));
		 }
		for(int i=0;i<4;i++)
		{
			player[i].set_player_name(sc.next());
		}
	     sc.nextLine();
		int player_club_3 = S_deck.Deal(player);
		for(int i=0;i<4;i++) {
			player[i].sort_hand_card();	
		}
		
		game.Top_player = player_club_3;
		
		while(END!=1)
		{	
			System.out.println("New round begins.");
			END = game.round_start(sc ,player,first);
			first =false;
			if(END==1)
			System.out.println("Game over, the winner is " + player[game.Top_player].get_name() + '.');	
		}
}
}