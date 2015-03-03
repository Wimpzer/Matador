package game;

import field.*;

public class Board {

	
	private Field[] fieldlist = {
			new Start("Start"),
			new Street("Rødovrevej", 50, 1200, null, "Blue"),
			new Chance("Prøv Lykken"),
			new Street("Hvidovrevej", 50, 1200, null, "Blue"),
			new Taxes("Betal indkomstskat", 4000),
			new Shipping("LB Færgerne", 0, null),
			new Street("Roskildevej", 100, 2000, null, "Orange"),
			new Chance("Prøv Lykken"),
			new Street("Valbylanggade", 100, 2000, null, "Orange"),
			new Street("Allégade", 150, 2400, null, "Orange"),
			new Faengsel("Fængsel (På besøg)"),
			new Street("Frederiksberg Allé", 200, 2800, null, "Green"),
			new Brewery("Carlsberg", 0, null),
			new Street("Bülowsvej", 200, 2800, null, "Green"),
			new Street("Gl. Kongevej", 250, 3200, null, "Green"),
			new Shipping("Danmark", 0, null),
			new Street("Bernstorfvej", 300, 3600, null, "Grey"),
			new Chance("Prøv Lykken"),
			new Street("Hellerupvej", 300, 3600, null, "Grey"),
			new Street("Strandvejen", 350, 4000, null, "Grey"),
			new Refuge("Helle"),
			new Street("Trianglen", 350, 4400, null, "Red"),
			new Chance("Prøv Lykken"),
			new Street("Řsterbrogade", 350, 4400, null, "Red"),
			new Street("Grønningen", 400, 4800, null, "Red"),
			new Shipping("Mols-linjen A/S", 0, null),
			new Street("Bredgade", 450, 5200, null, "White"),
			new Street("Kgs. Nytov", 450, 5200, null, "White"),
			new Brewery("Coca-Cola", 0, null),
			new Street("Østergade", 500, 5600, null, "White"),
			new Faengsel("De fængsles"),
			new Street("Amagertov", 550, 6000, null, "Yellow"),
			new Street("Vimmelskaftet", 550, 6000, null, "Yellow"),
			new Chance("Prøv Lykken"),
			new Street("Nygade", 600, 6400, null, "Yellow"),
			new Shipping("Skandinavisk Linietrafik A/S", 0, null),
			new Chance("Prøv Lykken"),
			new Street("Frederiksbeggade", 700, 7000, null, "Purple"),
			new Taxes("Ekstaordinær statsskat", 2000),
			new Street("Rådhuspladsen", 1000, 8000, null, "Purple"), 
			};
	
}
