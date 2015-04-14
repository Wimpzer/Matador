package game;

import cards.*;

public class CardPile {
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
		//new BirthdayCard(),
		new BonusCard("Værdien af egen avl fra nyttehaven udgør kr. 200, som De modtager af banken.", 200),
		new FineCard("Betal Deres bilforsikring kr. 1.000.", 1000),
		//13 
		new MoveCard("Ryk frem til Grønningen. Hvis de passerer Start indkasser da kr. 4.000.", 0, 25),
		//15
		//16
		new MoveCard("Tag med LB-færgerne - flyt brikken frem, og hvis De passere Start indkasser da kr. 4.000.", 0, 6),
		//new JailCard(),
		//new JailCard(),
		new BonusCard("Grunder dyrtiden har De fået gageforhøjelse. Modtag kr. 1.000.", 1000),
		new MoveCard("Ryk frem til Frederiksberg Allé. Hvis de passerer Start indkasser kr. 4.000.", 0, 12),
		new BonusCard("De har vundet i Klasselotteriet. Modtag kr. 500.", 500),
		new MoveCard("Tag ind på Rådhuspladsen.", 0, 40),
		new MoveCard("Ryk tre felter tilbage.", -3, 0),
		//25 
		new FineCard("Betal kr. 3.000 for reparation af Deres vogn.", 3000),
		new FineCard("Betal kr. 3.000 for reparation af Deres vogn.", 3000),
		//28
		new BonusCard("Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 3.000.", 3000),
		new BonusCard("Modtag udbytte af Deres aktier kr. 1.000.", 1000),
		new BonusCard("Modtag udbytte af Deres aktier kr. 1.000.", 1000),
		new FineCard("De har kørt frem for Fuld Stop. Betal kr. 1.000 i bøde", 1000),
		new FineCard("De har modtaget en parkeringsbøde. Betal kr. 200 i bøde", 200)
	};

	
	
}
