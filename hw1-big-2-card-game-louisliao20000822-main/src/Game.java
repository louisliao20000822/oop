
import java.util.Scanner;
import java.util.Arrays;

public class Game {

	public static int Top_player;
	public static Card Top_play = new Card();
	public static int END_G = 0;
	public static int Top_play_pattern = 0; // 0 empty 1 single 2 pair 3 fullhouse 4 straight

	public int round_start(Scanner sc, Player player[], boolean first_round) {
		int R_END = 0;
		int pass_num = 0;
		int next_player = Top_player;
		int x[] = new int[4];
		int ret_val = 0;

		int action_count = 0;
		int error = 0;
		new_top_play();
		if (first_round == true) {
			System.out.println("Next turn: " + player[next_player].get_name());
			while (ret_val == 0) {
				player[next_player].print_hand();
				String l = sc.nextLine();
				String[] input = l.split(" ");
				action_count = input.length;
				int action_list[] = new int[action_count];
				for (int i = 0; i < action_count; i++) {
					action_list[i] = Integer.parseInt(input[i]);
				}
				Arrays.sort(action_list);
				error = Pattern.check_error(action_list, action_count, player[next_player]);
				if (error != 0) {
					if (error == 1)
						System.out.println("Invalid play, please try again.");
				}
				else if (action_count == 1&&action_list[0]==0)
							ret_val = Pattern.play_card_single(action_list, player[next_player], next_player, action_count);
				else if (action_count == 2&&action_list[0]==0)
							ret_val = Pattern.play_pair(action_list, player[next_player], next_player, action_count);
				else if(action_count==5&&action_list[0]==0)
							ret_val = Pattern.play_fullhouse_or_straight(action_list, player[next_player], next_player, action_count);
				}
		next_player = (next_player + 1) % 4;
		}
					

		

		while (R_END != 1) {
			ret_val = 0;
			System.out.println("Next turn: " + player[next_player].get_name());
			while (ret_val == 0) {
				player[next_player].print_hand();
				String l = sc.nextLine();
				String[] input = l.split(" ");
				action_count = input.length;
				int action_list[] = new int[action_count];
				for (int i = 0; i < action_count; i++) {
					action_list[i] = Integer.parseInt(input[i]);
				}
				error = Pattern.check_error(action_list, action_count, player[next_player]);
				if (error != 0) {
					if (error == -1) {
						x[next_player] = 1;
						pass_num++;
						System.out.println("Player " + player[next_player].get_name() + " passes.");
						ret_val = 1;
						if (pass_num == 3) {
							R_END = 1;
						}
					} else if (error == 1)
						System.out.println("Invalid play, please try again.");

				} else if (action_count == 1)
					ret_val = Pattern.play_card_single(action_list, player[next_player], next_player, action_count);
				else if (action_count == 2)
					ret_val = Pattern.play_pair(action_list, player[next_player], next_player, action_count);
				else if(action_count==5)
					ret_val = Pattern.play_fullhouse_or_straight(action_list, player[next_player], next_player, action_count);
			}
			if (error != -1)
				pass_num = 0;
			if (END_G == 1)
				break;
			next_player = (next_player + 1) % 4;
		}
		return END_G;
	}
		

	public void new_top_play() {
		Top_play_pattern = 0;
		Top_play.set_suit('N');
		Top_play.set_rank('0');
	}


}
