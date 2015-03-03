package game;

import field.*;

public class Board {
	Field Field[]= new Field[40];

	
	public Field()
	 {
		Field[1]	new Start("Start"),
		Field[2]	new Street("Rødovrevej", 50, 1200, null, "Blue"),
		Field[3]	new Chance("Prøv Lykken"),
		Field[4]	new Street("Hvidovrevej", 50, 1200, null, "Blue"),
		Field[5]	new Taxes("Betal indkomstskat", 4000),
		Field[6]	new Shipping("LB Færgerne", 0, null),
		Field[7]	new Street("Roskildevej", 100, 2000, null, "Orange"),
		Field[8]	new Chance("Prøv Lykken"),
		Field[9]	new Street("Valbylanggade", 100, 2000, null, "Orange"),
		Field[10]	new Street("Allégade", 150, 2400, null, "Orange"),
		Field[11]	new Faengsel("Fængsel (På besøg)"),
		Field[12]	new Street("Frederiksberg Allé", 200, 2800, null, "Green"),
		Field[13]	new Brewery("Carlsberg", 0, null),
		Field[14]	new Street("Bülowsvej", 200, 2800, null, "Green"),
		Field[15]	new Street("Gl. Kongevej", 250, 3200, null, "Green"),
		Field[16]	new Shipping("Danmark", 0, null),
		Field[17]	new Street("Bernstorfvej", 300, 3600, null, "Grey"),
		Field[18]	new Chance("Prøv Lykken"),
		Field[19]	new Street("Hellerupvej", 300, 3600, null, "Grey"),
		Field[20]	new Street("Strandvejen", 350, 4000, null, "Grey"),
		Field[21]	new Refuge("Helle"),
		Field[22]	new Street("Trianglen", 350, 4400, null, "Red"),
		Field[23]	new Chance("Prøv Lykken"),
		Field[24]	new Street("Řsterbrogade", 350, 4400, null, "Red"),
		Field[25]	new Street("Grønningen", 400, 4800, null, "Red"),
		Field[26]	new Shipping("Mols-linjen A/S", 0, null),
		Field[27]	new Street("Bredgade", 450, 5200, null, "White"),
		Field[28]	new Street("Kgs. Nytov", 450, 5200, null, "White"),
		Field[29]	new Brewery("Coca-Cola", 0, null),
		Field[30]	new Street("Østergade", 500, 5600, null, "White"),
		Field[31]	new Faengsel("De fængsles"),
		Field[32]	new Street("Amagertov", 550, 6000, null, "Yellow"),
		Field[33]	new Street("Vimmelskaftet", 550, 6000, null, "Yellow"),
		Field[34]	new Chance("Prøv Lykken"),
		Field[35]	new Street("Nygade", 600, 6400, null, "Yellow"),
		Field[36]	new Shipping("Skandinavisk Linietrafik A/S", 0, null),
		Field[37]	new Chance("Prøv Lykken"),
		Field[38]	new Street("Frederiksbeggade", 700, 7000, null, "Purple"),
		Field[39]	new Taxes("Ekstaordinær statsskat", 2000),
		Field[40]	new Street("Rådhuspladsen", 1000, 8000, null, "Purple"), 
			};
	

public Field getFieldArray(int i)
}
 
 return Field [i];
 
 
 



