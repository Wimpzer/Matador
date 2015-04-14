package game;

import field.*;
import java.util.ArrayList;

public class Board {
	public Field[]fields ;
	public ArrayList<Street> street;
	public Board()
	{
	
	fields =new Field[40];
	street = new ArrayList<Street>();
	
	}
	
	public void NewBoard()
	 {
		    fields[0] = new Start     ("Start");
			fields[1] = new Street    ("Rødovrevej", 1200, 1000, 50, 250, 750, 2250, 4000, 6000);
			fields[2] = new Lucky     ("Prøv Lykken");
			fields[3] = new Street    ("Hvidovrevej", 1200, 1000, 50, 250, 750, 2250, 4000, 6000);
			fields[4] = new Taxes     ("Indkomstskatten", 4000);
			fields[5] = new Shipping  ("Shipping - LB Færgerne",2000, 4000, 500, 1000, 2000,4000);
			fields[6] = new Street    ("Roskildevej", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000);
			fields[7] = new Lucky     ("Prøv Lykken");
			fields[8] = new Street    ("Valby Langgade", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000);
			fields[9] = new Street    ("Allegade", 2400, 1000, 150, 800, 2000, 6000, 9000, 12000);
			fields[10] = new Jail     ("Fængsel");
			fields[11] = new Street   ("Frederiksberg Alle", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000);
			fields[12] = new Brewery  ("Bryggeri - Carlsberg", 3000, 100, 200);
			fields[13] = new Street   ("Bulowsvej", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000);	
			fields[14] = new Street   ("Gl. Kongevej", 3200, 2000, 250, 1250, 3750, 10000, 14000, 18000);	
			fields[15] = new Shipping ("Shipping - Kalundborg/Århus",2000, 4000, 500, 1000, 2000,4000);	
			fields[16] = new Street   ("Bernstorfsvej", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000);	
			fields[17] = new Lucky    ("Prøv Lykken");	
			fields[18] = new Street   ("Hellerupvej", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000);	
			fields[19] = new Street   ("Strandvej", 4000, 2000, 350, 1600, 4400, 12000, 16000, 20000);	
			fields[20] = new Refuge   ("Parkering", 5000);	
			fields[21] = new Street   ("Trianglen", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000);	
			fields[22] = new Lucky    ("Prøv Lykken");	
			fields[23] = new Street   ("Østerbrogade", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000);	
			fields[24] = new Street   ("Grønningen", 4800, 3000, 400, 2000, 6000, 15000, 18500, 22000);	
			fields[25] = new Shipping ("Shipping - Mols-Linien A/S", 4000, 500, 1000, 2000,4000,2000);	
			fields[26] = new Street   ("Bredgade", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000);	
			fields[27] = new Street   ("Kgs. Nytorv", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000);	
			fields[28] = new Brewery  ("Bryggeri - Coca-Cola", 3000, 100, 200);	
			fields[29] = new Street   ("Østergade", 5600, 3000, 500, 2400, 7200, 17000, 20500, 24000);	
			fields[30] = new Jail     ("De Faengsles");	
			fields[31] = new Street   ("Amagertorv", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000);	
			fields[32] = new Street   ("Vimmelskaftet", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000);	
			fields[33] = new Lucky    ("Prøv lykken");	
			fields[34] = new Street   ("Nygade", 6400, 4000, 600, 3000, 9000, 20000, 24000, 28000);	
			fields[35] = new Shipping ("Shipping - Skandinavisk Linietrafik A/S", 2000,4000, 500, 1000, 2000,4000);	
			fields[36] = new Lucky    ("Prøv lykken");	
			fields[37] = new Street   ("Frederiksberggade", 7000, 4000, 700, 3500, 10000, 22000, 26000, 30000);	
			fields[38] = new Taxes    ("Ekstraordinær statsskat", 2000);	
			fields[39] = new Street   ("Rådhuspladsen)", 8000, 4000, 1000, 4000, 12000, 28000, 34000, 40000);	
	

			Street blue = new Street("Blue");
		    Street orange = new Street("Orange");
		    Street green = new Street("Green");
		    Street grey = new Street("Grey");
		    Street red = new Street("Red");
		    Street white = new Street("white");
		    Street yellow = new Street("Yellow");
		    Street purple = new Street("Purple");
		   
		    blue.addStreet((Street) getField(1));
		    blue.addStreet((Street) getField(3));
		    orange.addStreet((Street) getField(6));
		    orange.addStreet((Street) getField(8));
		    orange.addStreet((Street) getField(9));
		    
		    green.addStreet((Street) getField(11));
		    green.addStreet((Street) getField(13));
		    green.addStreet((Street) getField(14));
		    
		    grey.addStreet((Street) getField(16));
		    grey.addStreet((Street) getField(18));
		    grey.addStreet((Street) getField(19));
		    
		    red.addStreet((Street) getField(21));
		    red.addStreet((Street) getField(23));
		    red.addStreet((Street) getField(24));
		    
		    white.addStreet((Street) getField(26));
		    white.addStreet((Street) getField(27));
		    white.addStreet((Street) getField(29));
		    
		    yellow.addStreet((Street) getField(31));
		    yellow.addStreet((Street) getField(32));
		    yellow.addStreet((Street) getField(34));
		    
		    purple.addStreet((Street) getField(37));
		    purple.addStreet((Street) getField(39));
		    
		    street.add(blue);
		    street.add(orange);
		    street.add(green);
		    street.add(grey);
		    street.add(red);
		    street.add(white);
		    street.add(yellow);
		    street.add(purple);
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

 



