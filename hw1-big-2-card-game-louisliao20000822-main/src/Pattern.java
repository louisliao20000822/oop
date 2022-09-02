

public class Pattern {
	
	public static int check_error(int action[], int action_count, Player player) {
		if (action[0] == -1) {
			if (Game.Top_play.get_suit() != 'N')
				return -1;
			else {
				System.out.println("You can't pass in the new round.");
				return 2;
			}
		}
		if (action_count!=1 && action_count!=2&&action_count!=5)
			return 1;
		for (int i = 0; i < action_count; i++)
			if (action[i] >= player.get_card_num())
				return 1;
		if (action_count == 2) {
			if (check_pair(player.hand_card[action[0]], player.hand_card[action[1]]) != 1)
				return 1;
		}
		if(action_count == 5) {
			Card [] c = new Card[5];
			for(int j=0;j<5;j++)
				c[j]=player.hand_card[action[j]];
			Card.sort_card(5,c);
			if (check_fullhouse(c) == 0)
				if(check_straight(c)== 0)
				return 1;
		}

		return 0;
	}
	
	public static int play_fullhouse_or_straight(int action[], Player player, int player_num, int action_count) {
		Card [] c = new Card[5];
		for(int j=0;j<5;j++)
		c[j]=player.hand_card[action[j]];
		Card.sort_card(5,c);
		if (check_fullhouse(c) == 1&&(Game.Top_play_pattern == 3||Game.Top_play_pattern==0)) {
			Game.Top_play_pattern = 3;
			Game.Top_play.set_rank(fullhouse(c).get_rank());
			Game.Top_play.set_suit(fullhouse(c).get_suit());
			Game.Top_player = player_num;
			System.out.println("Player " + player.get_name() + " plays a" + " full house "
					+ c[0].get_card() + " " +c[1].get_card()+" "
					+ c[2].get_card() + " "+c[3].get_card() + " "+c[4].get_card()+".");
			player.del_card(action[0]);
			player.del_card(action[1]);
			player.del_card(action[2]);
			player.del_card(action[3]);
			player.del_card(action[4]);
			player.sort_hand_card();
			return 1;	
		}
		else if(check_straight(c)==1&&(Game.Top_play_pattern == 4||Game.Top_play_pattern==0)) {
			Game.Top_play_pattern = 4;
			Game.Top_play.set_rank(straight(c).get_rank());
			Game.Top_play.set_suit(straight(c).get_suit());
			
			System.out.println("Player " + player.get_name() + " plays a" + " straight "
					+ c[0].get_card() + " " +c[1].get_card()+" "
					+ c[2].get_card() + " "+c[3].get_card() + " "+c[4].get_card()+".");
			player.del_card(action[0]);
			player.del_card(action[1]);
			player.del_card(action[2]);
			player.del_card(action[3]);
			player.del_card(action[4]);
			player.sort_hand_card();
			return 1;	
		}
		else{
			System.out.println("Invalid play, please try again.");
			return 0;
		}
	}
	
	public static int play_pair(int action[], Player player, int player_num, int action_count) {
		int bigger = 0;
		if (Card.compare_card(player.hand_card[action[0]], player.hand_card[action[1]]) > 0)
			bigger = action[0];
		else
			bigger = action[1];
		if (Card.compare_card(player.hand_card[bigger], Game.Top_play) > 0 && (Game.Top_play_pattern == 2||Game.Top_play_pattern==0)) {
			Game.Top_play.set_suit(player.hand_card[bigger].get_suit());
			Game.Top_play.set_rank(player.hand_card[bigger].get_rank());
			Game.Top_player = player_num;
			Game.Top_play_pattern = 2;
			System.out.println("Player " + player.get_name() + " plays a" + " pair "
					+ player.hand_card[action[0]].get_card() + " " + player.hand_card[action[1]].get_card() + ".");
			player.del_card(action[0]);
			player.del_card(action[1]);
			player.sort_hand_card();
			Game.END_G = player.player_hand_empty();
			return 1;
		} else {
			System.out.println("Invalid play, please try again.");
			return 0;
		}
	}
	
	public static int play_card_single(int action[], Player player, int player_num, int action_count) {

		if (Card.compare_card(player.hand_card[action[0]], Game.Top_play) > 0&&(Game.Top_play_pattern == 1||Game.Top_play_pattern==0)) {
			Game.Top_play.set_suit(player.hand_card[action[0]].get_suit());
			Game.Top_play.set_rank(player.hand_card[action[0]].get_rank());
			Game.Top_player = player_num;
			Game.Top_play_pattern = 1;
			System.out.println("Player " + player.get_name() + " plays a" + " single "
					+ player.hand_card[action[0]].get_card() + ".");
			player.del_card(action[0]);
			player.sort_hand_card();
			Game.END_G = player.player_hand_empty();
			return 1;
		} else {
			System.out.println("Invalid play, please try again.");
			return 0;
		}
	}
    public static int check_straight(Card c[]) {
    	
    	int [] val =new int[5];
    	int flag =0;
    	for(int i=0;i<5;i++)
    		val[i]= Card.give_value(c[i].get_rank());
    	for(int i=0;i<4;i++)
    		if(val[i+1]-val[i]!=1)
    			flag = 1;
    	if(flag==0)
    		return 1;
    	if(c[0].get_rank() == '3'&&c[1].get_rank() == 'Q'&&c[2].get_rank() == 'K'&&c[3].get_rank() == 'A'&&c[4].get_rank() == '2')
    		return 1;
    	if(c[0].get_rank() == '3'&&c[1].get_rank() == '4'&&c[2].get_rank() == 'K'&&c[3].get_rank() == 'A'&&c[4].get_rank() == '2')
    		return 1;
    	if(c[0].get_rank() == '3'&&c[1].get_rank() == '4'&&c[2].get_rank() == '5'&&c[3].get_rank() == 'A'&&c[4].get_rank() == '2')
    		return 1;
    	if(c[0].get_rank() == '3'&&c[1].get_rank() == '4'&&c[2].get_rank() == '5'&&c[3].get_rank() == '6'&&c[4].get_rank() == '2')
    		return 1;
    	else
    		return 0;
    }

    public static Card straight(Card c[]) {
    	
    	int [] val =new int[5];
    	int max=-1;
    	for(int i=0;i<5;i++)
    		val[i]= Card.give_value(c[i].get_rank());
    	for(int i=0;i<5;i++)
    		if(val[i]>max)
    			max = i;
    	return c[max];
    }

    public static int check_pair(Card a,Card b) {
    	if(a.get_rank()==b.get_rank())
    		return 1;
    	else
    		return 0;
    }
    public static int check_triple(Card a,Card b,Card c) {
    	if(a.get_rank()==b.get_rank()&&b.get_rank()==c.get_rank())
    		return 1;
    	else
    		return 0;
    }
    
    public static int check_fullhouse(Card c[]) {
    	if(check_pair(c[3],c[4])==1)
    		if(check_triple(c[0],c[1],c[2])==1)
    			return 1;
    		else if(check_pair(c[0],c[1])==1)
	    		if(check_triple(c[2],c[3],c[4])==1)
    			return 1;
    	return 0;
    }
    
    public static Card fullhouse(Card c[]) {
    	if(check_pair(c[0],c[1])==1)
    		if(check_triple(c[2],c[3],c[4])==1)
    			return c[0];
    	else if(check_pair(c[3],c[4])==1)
    		if(check_triple(c[0],c[1],c[2])==1)
    			return c[0];
    	return null;
    }
}


