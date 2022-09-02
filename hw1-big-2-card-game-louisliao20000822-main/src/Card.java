



public class Card {
	    private char Rank;
	    private char Suit;
	    
	    public Card() { 
	    	this.Rank = 'N';
	    	this.Suit = 'N';	
	    }
	    
	    public void set_rank(char c){
	    	this.Rank = c;
	    }
	    public void set_suit(char c){
	    	this.Suit = c;
	    }
	    public char get_suit() {
	    	return Suit;
	    }
	    
	    public char get_rank() {	    	
	    	return Rank;
	    }
	    public String get_card() {
	    	if(Rank == '1')
	    		return Suit+"["+Rank+'0'+"]";
	    	else
	    		return Suit+"["+Rank+"]";
	    }
	    static public int compare_card(Card a,Card b)
	    {
	    	char a_r = a.get_rank();
	    	char b_r = b.get_rank();
	    	char a_s = a.get_suit();
	    	char b_s = b.get_suit();
	    	int a_r_val = give_value(a_r);
	    	int b_r_val = give_value(b_r);
	    	int a_s_val = give_value(a_s);
	    	int b_s_val = give_value(b_s);
	    	int value = 0; //val = 1 a is bigger,val = -1 b is bigger 
	    	
	    	if(a_r_val>b_r_val)
	    		value = 1;
	    	else if (a_r_val<b_r_val)
	    		value = -1;
	    	else
	    	{
	    		if(a_s_val>b_s_val)
	    			value = 1;
	    		if(a_s_val<=b_s_val)
	    			value = -1;
	    	}
	    		    	
	    	return value;	
	    }
	    public static int give_value(char a)
	    {
	    	int val = 0;
	    	if(a == 'C')
	    	    val = 1;
	    	else if(a == 'N')
	    		val = 0;
	    	else if(a == 'D')
	    		val = 2;
	    	else if(a == 'H')
	    		val = 3;
	    	else if(a == 'S')
	    		val = 4;
	    	else if(a == 'E')
	    		val = 100;
	    	else if(a == 'J')
	    		val = 11;
	    	else if(a == 'Q')
	    		val = 12;
	    	else if(a == 'K')
	    		val = 13;
	    	else if(a == 'A')
	    		val = 14;
	    	else if(a == '2')
	    		val = 15;
	    	else if(a == '1')
	    		val = 10;
	    	else
	    		val = a - '0';
	    	return val;
	    }
	    public static void swap(Card a[],int i,int j)
	    {
	    	Card tmp = new Card();
	    	tmp = a[i];
	    	a[i] = a[j];
	    	a[j] = tmp;
	    }
	    
		public static void sort_card(int n,Card c[]) {
			for (int i = 0; i < n; i++) {
				int min = i;
				for (int j = i + 1; j < n; j++) {
					if (Card.compare_card(c[min], c[j]) > 0) {
						min = j;
					}

				}
				Card.swap(c, min, i);
			}

		}
}


	

