
public class Player {
	private String name;

	Card[] hand_card = new Card[13];
	private int card_num = 13;

	public Player() {
		for (int i = 0; i < 13; i++)
			hand_card[i] = new Card();
	}

	public void set_hand_card(int num, char R, char S) {

		hand_card[num].set_rank(R);
		hand_card[num].set_suit(S);
	}

	public void set_player_name(String N) {
		name = N;
	}

	public void sort_hand_card() {
		for (int i = 0; i < 13; i++) {
			int min = i;
			for (int j = i + 1; j < 13; j++) {
				if (Card.compare_card(hand_card[min], hand_card[j]) > 0) {
					min = j;
				}

			}
			Card.swap(hand_card, min, i);
		}

	}
	

	public void print_hand() {
		for (int i = 0; i < card_num; i++) {
			int len = hand_card[i].get_card().length();
			System.out.print(i);
			for (int j = 0; j < len - i / 10; j++)
				System.out.print(" ");
		}
		System.out.println();
		for (int i = 0; i < card_num; i++) {
			System.out.print(hand_card[i].get_card() + " ");
		}
		System.out.println();
	}

	public void minus_card(int v) {
		card_num = card_num - v;
	}

	public void del_card(int num) {
		hand_card[num].set_rank('E');
		card_num--;
	}

	public String get_name() {
		return name;
	}

	public int player_hand_empty() {
		if (card_num == 0)
			return 1;
		else
			return 0;
	}

	public int get_card_num() {
		return card_num;
	}
}
