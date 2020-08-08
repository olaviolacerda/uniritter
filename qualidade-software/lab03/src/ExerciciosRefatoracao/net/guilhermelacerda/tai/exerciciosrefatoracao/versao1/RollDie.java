// Fig. 6.8: RollDie.java
// Roll a six-sided die 6000 times.
package ExerciciosRefatoracao.net.guilhermelacerda.tai.exerciciosrefatoracao.versao1;

import java.util.Random;

public class RollDie 
{
   public static void main( String[] args )
   {
      Random randomNumbers = new Random(); // random number generator

      int frequency1 = 0; // count of 1s rolled
      int frequency2 = 0; // count of 2s rolled
      int frequency3 = 0; // count of 3s rolled
      int frequency4 = 0; // count of 4s rolled
      int frequency5 = 0; // count of 5s rolled
      int frequency6 = 0; // count of 6s rolled
      
      int face; // stores most recently rolled value
   
      // tally counts for 6000 rolls of a die
      for ( int roll = 1; roll <= 6000; roll++ ) 
      {
         face = 1 + randomNumbers.nextInt( 6 ); // number from 1 to 6
   
         // determine roll value 1-6 and increment appropriate counter
         switch ( face ) 
         {   
            case 1:
               ++frequency1; // increment the 1s counter
               break; 
            case 2:
               ++frequency2; // increment the 2s counter
               break;
            case 3:
               ++frequency3; // increment the 3s counter
               break;
            case 4:
               ++frequency4; // increment the 4s counter
               break;
            case 5:
               ++frequency5; // increment the 5s counter
               break;
            case 6:
               ++frequency6; // increment the 6s counter
               break; // optional at end of switch
         } // end switch
      } // end for

      System.out.println( "Face\tFrequency" ); // output headers
      System.out.printf( "1\t%d\n2\t%d\n3\t%d\n4\t%d\n5\t%d\n6\t%d\n",
         frequency1, frequency2, frequency3, frequency4,
         frequency5, frequency6 );
   } // end main
} // end class RollDie

/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
