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
		    fields[0] = new Start     (1,  "(Start)");
			fields[1] = new Street    (2, "(Roedovrevej)", 1200, 1000, 50, 250, 750, 2250, 4000, 6000);
			fields[2] = new Lucky     (3, "(Proev Lykken)");
			fields[3] = new Street    (4, "(Hvidovrevej)", 1200, 1000, 50, 250, 750, 2250, 4000, 6000);
			fields[4] = new Taxes     (5, "(Indkomstskatten)", 4000);
			fields[5] = new Shipping  (6," (Shipping - LB Faergerne)",2000, 4000, 500, 1000, 2000,4000);
			fields[6] = new Street    (7, "(Roskildevej)", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000);
			fields[7] = new Lucky     (8, "(Proev Lykken)");
			fields[8] = new Street    (9, "(Valby Langgade)", 2000, 1000, 100, 600, 1800, 5400, 8000, 11000);
			fields[9] = new Street    (10, "(Allegade)", 2400, 1000, 150, 800, 2000, 6000, 9000, 12000);
			fields[10] = new Jail     (11, "(Faengsel)");
			fields[11] = new Street   (12, "(Frederiksberg Alle)", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000);
			fields[12] = new Brewery  (13, "(Bryggeri - Carlsberg)", 3000, 100, 200);
			fields[13] = new Street   (14, "(Bulowsvej)", 2800, 2000, 200, 1000, 3000, 9000, 12500, 15000);	
			fields[14] = new Street   (15, "(Gl. Kongevej)", 3200, 2000, 250, 1250, 3750, 10000, 14000, 18000);	
			fields[15] = new Shipping (16, "(Shipping - Kalundborg/Aarhus)",2000, 4000, 500, 1000, 2000,4000);	
			fields[16] = new Street   (17, "(Bernstorfsvej)", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000);	
			fields[17] = new Lucky    (18, "(Proev Lykken)");	
			fields[18] = new Street   (19, "(Hellerupvej)", 3600, 2000, 300, 1400, 4000, 11000, 15000, 19000);	
			fields[19] = new Street   (20, "(Strandvej)", 4000, 2000, 350, 1600, 4400, 12000, 16000, 20000);	
			fields[20] = new Refuge   (21, "(Parkering eller Helle)", 5000);	
			fields[21] = new Street   (22, "(Trianglen)", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000);	
			fields[22] = new Lucky    (23, "(Proev Lykken)");	
			fields[23] = new Street   (24, "(Oesterbrogade)", 4400, 3000, 350, 1800, 5000, 14000, 17500, 21000);	
			fields[24] = new Street   (25, "(Groenningen)", 4800, 3000, 400, 2000, 6000, 15000, 18500, 22000);	
			fields[25] = new Shipping (26, "(Shipping - Mols-Linien A/S)", 4000, 500, 1000, 2000,4000,2000);	
			fields[26] = new Street   (27, "(Bredgade)", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000);	
			fields[27] = new Street   (28, "(Kgs. Nytorv)", 5200, 3000, 450, 2200, 6600, 16000, 19500, 23000);	
			fields[28] = new Brewery  (29, "(Bryggeri - Coca-Cola)", 3000, 100, 200);	
			fields[29] = new Street   (30, "(Oestergade)", 5600, 3000, 500, 2400, 7200, 17000, 20500, 24000);	
			fields[30] = new Jail     (31, "(De Faengsles)");	
			fields[31] = new Street   (32, "(Amagertorv)", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000);	
			fields[32] = new Street   (33, "(Vimmelskaftet)", 6000, 4000, 550, 2600, 7800, 18000, 22000, 25000);	
			fields[33] = new Lucky    (34, "(Proev lykken)");	
			fields[34] = new Street   (35, "(Nygade)", 6400, 4000, 600, 3000, 9000, 20000, 24000, 28000);	
			fields[35] = new Shipping (36, "(Shipping - Skandinavisk Linietrafik A/S)", 2000,4000, 500, 1000, 2000,4000);	
			fields[36] = new Lucky    (37, "(Proev lykken)");	
			fields[37] = new Street   (38, "(Frederiksberggade)", 7000, 4000, 700, 3500, 10000, 22000, 26000, 30000);	
			fields[38] = new Taxes   (39, "(Ekstraordinaer statsskat)", 2000);	
			fields[39] = new Street   (40, "(Raadhuspladsen)", 8000, 4000, 1000, 4000, 12000, 28000, 34000, 40000);	
	

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

 



