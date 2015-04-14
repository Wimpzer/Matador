package game;

import field.*;

public class Board {
	public Field[]fields ;
	public Board()
	{
	fields =new Field[40];
	}
	
	public void NewBoard()
	 {
		    fields[0] = new Start     (1, "Start");
			fields[1] = new Street    (2, "Rødovrevej", 1200, 1000, 50, 250, 750, 2250, 4000, 6000, "blue");
			fields[2] = new Lucky     (3, "Prøv Lykken");
			fields[3] = new Street    (4, "Hvidovrevej", 1200, 1000, 50, 250, 750, 2250, 4000, 6000, "blue");
			fields[4] = new Taxes     (5, "Indkomstskatten", 4000);
			fields[5] = new Shipping  (6, "Shipping - LB Færgerne", 4000);
			fields[6] = new Street    (7, "Roskildevej", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000, "orange");
			fields[7] = new Lucky     (8, "Prøv Lykken");
			fields[8] = new Street    (9, "Valby Langgade", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000, "orange");
			fields[9] = new Street    (10, "Allegade", 2400, 1000, 150, 800, 2000, 6000, 9000, 12000, "orange");
			fields[10] = new Jail     (11, "Fængsel");
			fields[11] = new Street   (12, "Frederiksberg Alle", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000, "green");
			fields[12] = new Brewery  (13, "Bryggeri - Carlsberg", 3000, 100, 200);
			fields[13] = new Street   (14, "Bulowsvej", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000, "green");	
			fields[14] = new Street   (15, "Gl. Kongevej", 3200, 2000, 250, 1250, 3750, 10000, 14000, 18000, "green");	
			fields[15] = new Shipping (16, "Shipping - Kalundborg/Århus", 4000);	
			fields[16] = new Street   (17, "Bernstorfsvej", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000, "grey");	
			fields[17] = new Lucky    (18, "Prøv Lykken");	
			fields[18] = new Street   (19, "Hellerupvej", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000, "grey");	
			fields[19] = new Street   (20, "Strandvej", 4000, 2000, 350, 1600, 4400, 12000, 16000, 20000, "grey");	
			fields[20] = new Refuge   (21, "Parkering", 5000);	
			fields[21] = new Street   (22, "Trianglen", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000, "red");	
			fields[22] = new Lucky    (23, "Prøv Lykken");	
			fields[23] = new Street   (24, "Østerbrogade", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000, "red");	
			fields[24] = new Street   (25, "Grønningen", 4800, 3000, 400, 2000, 6000, 15000, 18500, 22000, "red");	
			fields[25] = new Shipping (26, "Shipping - Mols-Linien A/S", 4000);	
			fields[26] = new Street   (27, "Bredgade", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000, "white");	
			fields[27] = new Street   (28, "Kgs. Nytorv", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000, "white");	
			fields[28] = new Brewery  (29, "Bryggeri - Coca-Cola", 3000, 100, 200);	
			fields[29] = new Street   (30, "Østergade", 5600, 3000, 500, 2400, 7200, 17000, 20500, 24000, "white");	
			fields[30] = new Jail     (31, "De Faengsles");	
			fields[31] = new Street   (32, "Amagertorv", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000, "yellow");	
			fields[32] = new Street   (33, "Vimmelskaftet", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000, "yellow");	
			fields[33] = new Lucky    (34, "Prøv lykken");	
			fields[34] = new Street   (35, "Nygade", 6400, 4000, 600, 3000, 9000, 20000, 24000, 28000, "yellow");	
			fields[35] = new Shipping (36, "Shipping - Skandinavisk Linietrafik A/S", 4000);	
			fields[36] = new Lucky    (37, "Prøv lykken");	
			fields[37] = new Street   (38, "Frederiksberggade", 7000, 4000, 700, 3500, 10000, 22000, 26000, 30000, "purple");	
			fields[38] = new Taxes    (39, "Ekstraordinær statsskat", 2000);	
			fields[39] = new Street   (40, "Rådhuspladsen)", 8000, 4000, 1000, 4000, 12000, 28000, 34000, 40000, "purple");	
	

			
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

 



