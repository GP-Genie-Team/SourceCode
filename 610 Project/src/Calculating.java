import java.util.*;


public class Calculating {
	public static void main (String [] arg){
		int index, index1,index2, index3, index4, index5;
		
		int index6, index7, index8;
		double [] finalprint = new double [10000000];
		
		int index9, index10, cutoff;
		long start,now, diff;
		index10 =0;
		index9=0;

		//TreeNode temp1, temp2;
		GetInput getinput = new GetInput();
		getinput.getvariable();
		

		Random generator = new Random();
		final int POPULATION = getinput.size;
		int height = GetInput.height;
		int choose = GetInput.choice;
		cutoff = POPULATION*GetInput.percent/100;
		final int CUT_OFF = POPULATION*GetInput.percent/100;
		int rand [] = new int [CUT_OFF];
		
		for (index =0; index<CUT_OFF; index++)
		{
			rand[index] = index;
		}
		
		double [] training_input;
		double [] training_output;
		
		if (choose ==1){
			training_input = new double [] {-5.685849616022263,3.3682869645854163,4.201003178664386,-2.3980005154824813,2.863257914834587,-5.470855402802133,-0.5555000364092466,-3.483791316032827,4.2230395963185,5.6899462002511125,2.9624292580748945,-4.782305734450672,9.538506931113558,-8.101785147114358,0.4943746185904496,-89.18845101519794,-52.66172022018547,99.2748675723729,-86.85508620189755,-92.34122488123204,22.482269506799323,32.00928246343402,-15.753598238413357,-63.386374562537284,-76.27341611966743,-72.25379313426734,77.56553444232912,44.16597969622549,25.203823953836356,-78.28350201015493,976.5000488477659,-252.89208809902618,-885.6522815894974,364.32872056922963,423.5310442111377,785.3318997855279,451.1238745928481,134.37245324912416,969.5023648588233,-801.4748387064421,919.5302806002776,293.99599273640445,-748.9148149626214,982.8588804527707,86.02574968410414};
			training_output = new double [] {-44.993328784030766,-13.518035613694057,-22.97264156072242,-5.1256097083813685,-8.797368830294362,-41.39538825755394,3.0371295643239886,-14.705202900498605,-23.251095148110885,-45.063231642628104,-9.663980663647255,-30.80567220663967,-132.97467171235206,-94.95838385500423,3.1333906047403213,-11928.369691735545,-4156.385164823637,-14779.748997268263,-11312.20899870858,-12786.852718849399,-754.6786632645379,-1533.391245735857,-368.7637861860106,-6023.24872027341,-8722.951009845914,-7827.415933434248,-9021.118199986218,-2922.4506437911036,-949.349112843963,-9188.960030460898,-1430325.0180995339,-95928.11233462843,-1176566.4458270236,-199099.62494741773,-269064.31811586506,-925115.7892311197,-305265.6253414956,-27080.434288282086,-1409898.7532002765,-963539.3756192763,-1268300.405411238,-129646.96561759597,-841306.6001057462,-1449013.8683273105,-11097.144413068216};
		}
		else{
		training_input = new double [] {0.8306968763325888,0.8711863744099975,-0.44335405250759274,-0.5571805335798072,-0.5472198902003198,0.08350240720003077,-1.8864579035738842,-1.1746182249278179,-0.832326245270127,0.27476196573433675,1.7095997073168374,0.05519455219827751,-1.3743806864318882,-1.212079764099549,-0.16207152186536167,-1.0349712232682218,0.5187456427110213,-1.9751174249671233,-1.7891971023446587,1.765839980149745,-0.6075312539181836,-1.422346556505544,-0.9784280754766153,-1.2128667788409517,1.4698809289591357,-1.024712158289363,0.32093764862722907,-1.990781337036851,1.8608330478471786,1.6380766752395504,1.6703220902471791,-0.9645738027982471,-1.7343047484509961,1.1499272695184302,-0.21417724842440578,-0.015615771920271193,0.6470628824117779,-0.8955678122867607,-0.9379597520902263,-0.7605055971905439,-0.6690449050478504,1.5496511258229724,-0.33416017154900324,1.074769048907934,-0.38766390051423283};
		training_output = new double [] {2.640157334164728,2.508199136635321,3.6307203814856646,3.7594651678333175,3.745797172604922,3.4991266501591207,13.570072888974652,5.930980436140679,4.36491220717479,3.4688856234391285,-3.9950505016494455,3.499747779779142,7.3941474316387605,6.171067487180325,3.506385742318914,5.162938097761595,3.2906106231250933,15.057662823479546,12.091437152137583,-4.759339064581079,3.836354415525185,7.816259389233669,4.905005347643602,6.1762739136971865,-1.2636267410294444,5.113975457985429,3.450414664249698,15.334827745229992,-6.16525886487976,-3.093164905021875,-3.4902375283788194,4.846162991471773,11.324696449770546,1.2191203099047034,3.514737073972726,3.5000057119136136,3.0936214998411766,4.577424104550584,4.737781161368805,4.1597790226610645,3.9492179094372433,-2.0820415829394268,3.555970001003459,1.6377554473448936,3.587389115251777};
		}
		Mutation mute = new Mutation();
		
		GPTree temp = new GPTree();
		
		//calculating current time
		start = System.currentTimeMillis( );
		diff = 0;
		System.out.println(training_output[2]);

		
		// this part initialize the population, and sort them using the fitness data
		System.out.println("Generating trees and calculating their fitness…");
		GPTree [] Trees = new GPTree[POPULATION];
		Trees[0] = new GPTree();

		Trees[0].rootnode.left = Trees[0].GenTree(1);
		Trees[0].rootnode.right = Trees[0].GenTree(1);
		for (index2 = 0; index2<45; index2 ++)
		{
			double value = training_input[index2];
			double cal = Trees[0].EvalTree(Trees[0].rootnode,value);
			if (Double.isNaN(cal)) Trees[0].fitness = Double.MAX_VALUE;
			else Trees[0].fitness += Math.abs(cal-training_output[index2]);
			
		}
		
		
		
		for (index=1;index < POPULATION; index ++)
		{
			Trees[index] = new GPTree();
			
			Trees[index].rootnode.left = Trees[index].GenTree(1);
			Trees[index].rootnode.right = Trees[index].GenTree(1);
			
			
			index1 = index;
			for (index2 = 0; index2<45; index2 ++)
			{
				double value = training_input[index2];
				double cal = Trees[index].EvalTree(Trees[index].rootnode,value);
				if (Double.isNaN(cal)) Trees[index].fitness = Double.MAX_VALUE;
				else Trees[index].fitness += Math.abs(cal-training_output[index2]);
				
			}
			
			
			temp = new GPTree(Trees[index]);
			while( (index1>0) && (temp.fitness<Trees[index1-1].fitness))
			{
				Trees[index1] = new GPTree(Trees[index1-1]);
				index1 --;
			}
			Trees[index1] = new GPTree(temp);
			
		}
		
		
		//print trees as they were initially generated and sorted
		for (index =0; index <POPULATION; index ++)
		{
			System.out.print(Trees[index].fitness);
			System.out.print("\t");
			Trees[index].PrintTree(Trees[index].rootnode);
			System.out.println();
		}
		System.out.println("Above data shows initial trees sorted by fitness and their fitness values.");
		System.out.println("Now performing crossover and mutation for next generation of trees...");
		
		
		finalprint[0] = Trees[0].fitness;
		index10 =1;
		

						
		//now generating next generation of population
		//assuming keeping first 200 every time
		while (diff < GetInput.timeinterval*60*1000 && (Trees[0].fitness >=0.0)){
			index9++;
			
				//first, crossover, using the kept parent to generate a new set of children
			
			//random generate a set of random number for cross-over
			
			for (int i =0; i<100; i++)
			{
				index1 = generator.nextInt(cutoff);
				index2 = generator.nextInt(cutoff);
				int j = rand[index1];
				rand[index1]=rand[index2];
				rand[index2] =j;
			}

			

				for (index6 = 0; index6<cutoff/2; index6 ++)
				{

					index7 = cutoff + 2*index6;
					index8 = cutoff + 2 * index6 +1;
					
					Trees[index7] = new GPTree(Trees[rand[index6*2]]);
					Trees[index8] = new GPTree(Trees[rand[index6 *2 +1]]);
					
					mute.crossover(Trees[index7].rootnode, Trees[index8].rootnode);

					
				}
	
				
				
		
					//now, mutation, using the kept parent to generate another set of children using mutation
					for (index6 = 0; index6<cutoff; index6++)
					{
						index7 = index6 + cutoff*2;				
						Trees[index7] = new GPTree(Trees[rand[index6]]);
						
						//System.out.println(index7);
						//Trees[index4].PrintTree(Trees[index4].rootnode);
						mute.mutating(Trees[index7].rootnode);
						
						//System.out.println(index4);
					}
					
		
					//System.out.println("done1");
					//now insert the newly generated tree to the correct position
					
					for (index = cutoff; index <cutoff*3; index ++)
					{
						
						index1 = index;
						for (index2 = 0; index2<45; index2 ++)
						{
							double value = training_input[index2];
							double cal = Trees[index].EvalTree(Trees[index].rootnode,value);
							if (Double.isNaN(cal)) Trees[index].fitness = Double.MAX_VALUE;
							else Trees[index].fitness += Math.abs(cal-training_output[index2]);
							
						}
						
						
						temp = new GPTree(Trees[index]);
						while( (index1>0) && (temp.fitness<Trees[index1-1].fitness))
						{
							Trees[index1] = new GPTree(Trees[index1-1]);
							index1 --;
						}
						Trees[index1] = new GPTree(temp);
						

						
					}
					
					
					//System.out.println("done2");
				//now random generate the rest tree
				
				for (index=cutoff*3;index < POPULATION; index ++)
				{
					Trees[index] = new GPTree();
					
					Trees[index].rootnode.left = Trees[index].GenTree(1);
					Trees[index].rootnode.right = Trees[index].GenTree(1);
					
					
					index1 = index;
					for (index2 = 0; index2<45; index2 ++)
					{
						double value = training_input[index2];
						double cal = Trees[index].EvalTree(Trees[index].rootnode,value);
						if (Double.isNaN(cal)) Trees[index].fitness = Double.MAX_VALUE;
						else Trees[index].fitness += Math.abs(cal-training_output[index2]);
						
					}
					
					
					temp = new GPTree(Trees[index]);
					while( (index1>0) && (temp.fitness<Trees[index1-1].fitness))
					{
						Trees[index1] = new GPTree(Trees[index1-1]);
						index1 --;
					}
					Trees[index1] = new GPTree(temp);
				}
				
		
			
			now = System.currentTimeMillis( );
			diff = now - start;
			//System.out.println(diff);
			//System.out.println(Trees[0].fitness);
			if ((index9 % 100) == 0 && (index9 >= 100))
			{
				finalprint[index10] = Trees[0].fitness;
				index10++;
			}
			
		//}
			
		}
		
		System.out.println("Population and trees after crossover and mutation:");
		System.out.println();
		for (index =0; index <POPULATION; index ++)
		{
			System.out.print(Trees[index].fitness);
			System.out.print("\t");
			Trees[index].PrintTree(Trees[index].rootnode);


			System.out.println();
		}
		
		
		
		System.out.println("Run complete. Least fit and three fittest trees shown below.");


		System.out.println();
		System.out.print("Equation Choice\t");
		System.out.println();
		System.out.print(GetInput.choice);
		System.out.print("Population\t");
		System.out.print(GetInput.size);
		System.out.println();
		System.out.print("Max Height\t");
		System.out.print(GetInput.height);
		System.out.println();
		System.out.print("Fit Percent\t");
		System.out.print(GetInput.percent);
		System.out.println();
		System.out.print("Run Time\t");
		System.out.print(diff/60000);
		System.out.print(" minute(s)");
		
		System.out.println();
		System.out.println();
		
		System.out.print("Tree 99\t");
		System.out.print(Trees[99].fitness);
		System.out.print("\t");
		Trees[99].PrintTree(Trees[99].rootnode);
		System.out.println();
		
		System.out.print("Tree  2\t");
		System.out.print(Trees[2].fitness);
		System.out.print("\t");
		Trees[2].PrintTree(Trees[2].rootnode);
		System.out.println();
		
		System.out.print("Tree  1\t");
		System.out.print(Trees[1].fitness);
		System.out.print("\t");
		Trees[1].PrintTree(Trees[1].rootnode);
		System.out.println();
		
		System.out.print("Tree  0\t");
		System.out.print(Trees[0].fitness);
		System.out.print("\t");
		Trees[0].PrintTree(Trees[0].rootnode);
		System.out.println();
		
		System.out.println("Fiteness: ");
		for (index10=0; index10< 1000; index10 ++)
		{
			if (finalprint[index10]>= 0.00) System.out.println(finalprint[index10]);
		}
		
	}

}
