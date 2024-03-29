package game;

import java.util.Random;
import cards.*;

	/**
	 * Contains the card pile and methods to draw & shuffle.
	 * @author Andreas
	 */

public class CardPile {

	/**
	 * Constructs the card pile with the needed variables.
	 */
	
	public static Card[] cardlist = {
		new BonusCard("De modtager Deres aktieudbytte. Modtag kr. 1000 af banken.", 1000),
		new MoveCard("Ryk frem til start.", 0, 1),
		new MoveCard("Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer Start, indkassere de ikke kr. 4.000", 0, 31),
		new MoveCard("Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer Start, indkassere de ikke kr. 4.000", 0, 31),
		new FineCard("De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal told kr. 200.", 200),
		new FineCard("De har modtaget Deres tandlægeregning. Betal kr. 2.000.", 2000),
		new BonusCard("De havde en række med elleve rigtige i tipning. Modtag kr. 1.000.", 1000),
		new BonusCard("Deres præmieobligation er kommet ud. De modtager kr. 1.000 af banken.", 1000),
		new BonusCard("Deres præmieobligation er kommet ud. De modtager kr. 1.000 af banken.", 1000),
		new BirthdayCard("Det er deres fødselsdag. Modtag af hver medspiller kr. 200."),
		new BonusCard("Værdien af egen avl fra nyttehaven udgør kr. 200, som De modtager af banken.", 200),
		new FineCard("Betal Deres bilforsikring kr. 1.000.", 1000),
		new PropertyCard("Ejendomsskatterne er steget, ekstraudgifterne er: kr. 800 pr. hus, kr. 2.300 pr. hotel.", 800, 2300),
		new MoveCard("Ryk frem til Grønningen. Hvis de passerer Start indkasser da kr. 4.000.", 0, 25),
		new MoveCard("Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selvskabet ikke ejes af nogen kan de købe det af banken.", 0, 16),
		new MoveCard("Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selvskabet ikke ejes af nogen kan de købe det af banken.", 0, 16),
		new MoveCard("Tag med LB-færgerne - flyt brikken frem, og hvis De passere Start indkasser da kr. 4.000.", 0, 6),
		new JailCard("I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares, indtil de får brug for det."),
		new JailCard("I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares, indtil de får brug for det."),
		new BonusCard("Grunder dyrtiden har De fået gageforhøjelse. Modtag kr. 1.000.", 1000),
		new MoveCard("Ryk frem til Frederiksberg Allé. Hvis de passerer Start indkasser kr. 4.000.", 0, 12),
		new BonusCard("De har vundet i Klasselotteriet. Modtag kr. 500.", 500),
		new MoveCard("Tag ind på Rådhuspladsen.", 0, 40),
		new MoveCard("Ryk tre felter tilbage.", -3, 0),
		new PropertyCard("Oliepriserne er steget, og De skal betale: kr. 500 pr. hus, kr. 2.000 pr. hotel.", 500, 2000),
		new FineCard("Betal kr. 3.000 for reparation af Deres vogn.", 3000),
		new FineCard("Betal kr. 3.000 for reparation af Deres vogn.", 3000),
		new LegatCard("De modtager Matador-legatet for værdigt trængende, på kr. 40.000. Ved værdigt trængende forstås, at deres formue, d.v.s. deres kontante penge + skøder + bygningen ikke overstiger kr. 15.000."),
		new BonusCard("Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 3.000.", 3000),
		new BonusCard("Modtag udbytte af Deres aktier kr. 1.000.", 1000),
		new BonusCard("Modtag udbytte af Deres aktier kr. 1.000.", 1000),
		new FineCard("De har kørt frem for Fuld Stop. Betal kr. 1.000 i bøde", 1000),
		new FineCard("De har modtaget en parkeringsbøde. Betal kr. 200 i bøde", 200)
	};

	private static int listNumber = cardlist.length;
	
	/**
	 * Shuffles the card pile.
	 */
	
	private static void shuffleCardPile(){
		Random rand = new Random();
		for(int i = 0; i < cardlist.length; i++){
			int index = rand.nextInt(i + 1);
			
			Card a = cardlist[index];
			cardlist[index] = cardlist[i];
			cardlist[i] = a;
		}
	}
	
	/**
	 * Checks if the card pile is empty by next card draw,
	 * if so it uses the shuffleCardPile to shuffle.
	 */
	
	private static void shuffleTimer(){
		
		if(listNumber + 1 >= cardlist.length){
			listNumber = 0;
			shuffleCardPile();
		}else{
			listNumber++;
		}
	}
	
	/**
	 * Sends a request to see if card pile is empty, where
	 * after it returns the top card.
	 * @return
	 */
	
	public static Card drawCard() {
		shuffleTimer();
		return cardlist[listNumber];
		
	}
	
	/**
	 * Returns the card pile
	 * @return
	 */
	
	public Card[] getCards(){
		return cardlist;
	}
	
	/**
	 * Returns one card in the pile.
	 * @param i The position of the card to return.
	 * @return
	 */
	
	public Card getCard(int i){
		return cardlist[i];
	}
}
