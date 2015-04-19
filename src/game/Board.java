package game;

import field.*;

public class Board {
	public Field[] fields = {
		new Start    (1, "Start"),
		new Street   (2, "Rødovrevej", 1200, 1000, 50, 250, 750, 2250, 4000, 6000, "blue"),
		new Chance   (3, "Prøv Lykken"),
		new Street   (4, "Hvidovrevej", 1200, 1000, 50, 250, 750, 2250, 4000, 6000, "blue"),
		new Taxes    (5, "Indkomstskatten", 4000),
		new Shipping (6, "Shipping - LB Færgerne", 4000),
		new Street   (7, "Roskildevej", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000, "orange"),
		new Chance   (8, "Prøv Lykken"),
		new Street   (9, "Valby Langgade", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000, "orange"),
		new Street   (10, "Allegade", 2400, 1000, 150, 800, 2000, 6000, 9000, 12000, "orange"),
		new Jail     (11, "Fængsel"),
		new Street   (12, "Frederiksberg Alle", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000, "green"),
		new Brewery  (13, "Bryggeri - Carlsberg", 3000),
		new Street   (14, "Bulowsvej", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000, "green"),	
		new Street   (15, "Gl. Kongevej", 3200, 2000, 250, 1250, 3750, 10000, 14000, 18000, "green"),	
		new Shipping (16, "Shipping - Kalundborg/Århus", 4000),
		new Street   (17, "Bernstorfsvej", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000, "grey"),	
		new Chance   (18, "Prøv Lykken"),
		new Street   (19, "Hellerupvej", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000, "grey"),	
		new Street   (20, "Strandvej", 4000, 2000, 350, 1600, 4400, 12000, 16000, 20000, "grey"),
		new Refuge   (21, "Parkering"),
		new Street   (22, "Trianglen", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000, "red"),	
		new Chance   (23, "Prøv Lykken"),
		new Street   (24, "Østerbrogade", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000, "red"),	
		new Street   (25, "Grønningen", 4800, 3000, 400, 2000, 6000, 15000, 18500, 22000, "red"),
		new Shipping (26, "Shipping - Mols-Linien A/S", 4000),
		new Street   (27, "Bredgade", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000, "white"),	
		new Street   (28, "Kgs. Nytorv", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000, "white"),	
		new Brewery  (29, "Bryggeri - Coca-Cola", 3000),
		new Street   (30, "Østergade", 5600, 3000, 500, 2400, 7200, 17000, 20500, 24000, "white"),	
		new Jail     (31, "De Faengsles"),
		new Street   (32, "Amagertorv", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000, "yellow"),	
		new Street   (33, "Vimmelskaftet", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000, "yellow"),	
		new Chance   (34, "Prøv lykken"),
		new Street   (35, "Nygade", 6400, 4000, 600, 3000, 9000, 20000, 24000, 28000, "yellow"),	
		new Shipping (36, "Shipping - Skandinavisk Linietrafik A/S", 4000),
		new Chance   (37, "Prøv lykken"),
		new Street   (38, "Frederiksberggade", 7000, 4000, 700, 3500, 10000, 22000, 26000, 30000, "purple"),	
		new Taxes    (39, "Ekstraordinær statsskat", 2000),	
		new Street   (40, "Rådhuspladsen)", 8000, 4000, 1000, 4000, 12000, 28000, 34000, 40000, "purple")
		};

	public int getSimilarCount(Street fieldToCompare){
		int count = 0;
		for(Field field : fields){
			if(field instanceof Street){
				Street street = (Street) field;
				if(street.getColour().equals(fieldToCompare.getColour()) && street.getOwner() != null && street.getOwner().getUserName().equals(fieldToCompare.getOwner().getUserName()){
					count++;
				}
			}
		}
	}
	
	public Field[] getFields()
	{
		return fields;
	}
	public Field getField(int i)
	{
		return fields[i];
	}



}





