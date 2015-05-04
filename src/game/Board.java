package game;

import java.awt.Color;

import field.*;

public class Board {
	public Field[] fields = {
		new Start    (1, "Start"),
		new Street   (2, "Rødovrevej", 1200, 1000, 50, 250, 750, 2250, 4000, 6000, new Color(35, 104, 173)),
		new Chance   (3, "Prøv Lykken"),
		new Street   (4, "Hvidovrevej", 1200, 1000, 50, 250, 750, 2250, 4000, 6000, new Color(35, 104, 173)),
		new Taxes    (5, "Indkomstskatten", 4000),
		new Shipping (6, "Shipping - LB Færgerne", 4000),
		new Street   (7, "Roskildevej", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000, new Color(223, 110, 30)),
		new Chance   (8, "Prøv Lykken"),
		new Street   (9, "Valby Langgade", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000, new Color(223, 110, 30)),
		new Street   (10, "Allegade", 2400, 1000, 150, 800, 2000, 6000, 9000, 12000, new Color(223, 110, 30)),
		new Jail     (11, "Fængsel"),
		new Street   (12, "Frederiksberg Alle", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000, new Color(188, 185, 32)),
		new Brewery  (13, "Bryggeri - Carlsberg", 3000),
		new Street   (14, "Bulowsvej", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000, new Color(188, 185, 32)),	
		new Street   (15, "Gl. Kongevej", 3200, 2000, 250, 1250, 3750, 10000, 14000, 18000, new Color(188, 185, 32)),	
		new Shipping (16, "Shipping - Kalundborg/Århus", 4000),
		new Street   (17, "Bernstorfsvej", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000, new Color(163, 171, 174)),	
		new Chance   (18, "Prøv Lykken"),
		new Street   (19, "Hellerupvej", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000, new Color(163, 171, 174)),	
		new Street   (20, "Strandvej", 4000, 2000, 350, 1600, 4400, 12000, 16000, 20000, new Color(163, 171, 174)),
		new Refuge   (21, "Parkering"),
		new Street   (22, "Trianglen", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000, new Color(217, 71, 96)),	
		new Chance   (23, "Prøv Lykken"),
		new Street   (24, "Østerbrogade", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000, new Color(217, 71, 96)),	
		new Street   (25, "Grønningen", 4800, 3000, 400, 2000, 6000, 15000, 18500, 22000, new Color(217, 71, 96)),
		new Shipping (26, "Shipping - Mols-Linien A/S", 4000),
		new Street   (27, "Bredgade", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000, new Color(221, 215, 219)),	
		new Street   (28, "Kgs. Nytorv", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000, new Color(221, 215, 219)),	
		new Brewery  (29, "Bryggeri - Coca-Cola", 3000),
		new Street   (30, "Østergade", 5600, 3000, 500, 2400, 7200, 17000, 20500, 24000, new Color(221, 215, 219)),	
		new Jail     (31, "De Faengsles"),
		new Street   (32, "Amagertorv", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000, new Color(255, 255, 0)),	
		new Street   (33, "Vimmelskaftet", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000, new Color(255, 255, 0)),	
		new Chance   (34, "Prøv lykken"),
		new Street   (35, "Nygade", 6400, 4000, 600, 3000, 9000, 20000, 24000, 28000, new Color(255, 255, 0)),	
		new Shipping (36, "Shipping - Skandinavisk Linietrafik A/S", 4000),
		new Chance   (37, "Prøv lykken"),
		new Street   (38, "Frederiksberggade", 7000, 4000, 700, 3500, 10000, 22000, 26000, 30000, new Color(115, 77, 136)),	
		new Taxes    (39, "Ekstraordinær statsskat", 2000),	
		new Street   (40, "Rådhuspladsen", 8000, 4000, 1000, 4000, 12000, 28000, 34000, 40000, new Color(115, 77, 136))
		};

	public int getSimilarCount(Street fieldToCompare){
		int count = 0;
		for(Field field : fields){
			if(field instanceof Street){
				Street street = (Street) field;
				if(street.getColour().equals(fieldToCompare.getColour()) && street.getOwner() != null && street.getOwner().getUserName().equals(fieldToCompare.getOwner().getUserName()) && street.getFieldActive() == true){
					count++;
				}
			}
		}
		return count;
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





