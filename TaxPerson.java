
import java.util.InputMismatchException;
import java.util.Scanner;

/** Taxperson

Calculate the total cost of an item including tax based on whether it is considered a necessary or luxury item. 
The tax rate for basic necessities is 1%, the tax rate for luxury items is 9%. 
For simplicity of implementation, all transactions are measured in cents (pennies).
 * 
 */

/**
 * @author 
 *
 */
public class TaxPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		try{

			System.out.println("Enter the number of items you want to buy?");
			int iNoItems = in.nextInt();

			//Initial Validation
			if(iNoItems <= 0)
				System.out.println("Error! Zero or Negative value entered..");
			else{

				int[] arItem = new int[iNoItems];
				float[] arItemCo = new float[iNoItems];
				int iCho;

				for(int i = 0; i < iNoItems; i++){

					System.out.println("Enter the cost of item no " + (i+1) + " in cents");
					arItem[i] = in.nextInt();
					
					int iflag = 0;
					
					while(iflag == 0){
						System.out.println("Please tell if this item is luxury or a necessary.");
						System.out.println("Enter 1 - For luxury item");
						System.out.println("Enter 2 - For Necessary item");
						iCho = in.nextInt();

						if(iCho == 1){
							arItemCo[i] = (float) (arItem[i] * 1.09);
							iflag = 1;
						}else if(iCho == 2){
							arItemCo[i] = (float) (arItem[i] * 1.01);
							iflag = 1;
						}else{

							System.out.println("Invalid input! Please enter either 1 or 2");

						}						
						
					}

				}//end of for loop
				
				float tot = (float) 0.0;
				for(int i = 0 ; i < iNoItems; i++){
					
					System.out.println("The cost of item no. "+(i+1)+" is: " + arItemCo[i]);
					tot = tot + arItemCo[i];
					
				}
				
				System.out.println("The total cost of the items is: " + tot);
				
			}// end of else

		}catch(InputMismatchException e){

			System.out.println("Error! The input should be an integer. E.g. 1, 2, 10, 100..");

		}finally{

			in.close();
		}
	}

}

