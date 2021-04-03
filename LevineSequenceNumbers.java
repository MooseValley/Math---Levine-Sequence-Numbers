/*
Math - Levine Sequence Numbers

The Levine Sequence - Numberphile
https://www.youtube.com/watch?v=KNjPPFyEeLo

Levine's sequence on the OEIS:
https://oeis.org/A011784

:::
1 1
1 2
1 1 2
1 1 2 3
1 1 1 2 2 3 4
1 1 1 1 2 2 2 3 3 4 4 5 6 7
1 1 1 1 1 1 1 2 2 2 2 2 2 3 3 3 3 3 4 4 4 4 5 5 5 5 6 6 6 7 7 7 8 8 9 9 10 10 11 12 13 14

Sum the integers in each row up:
1
2
2
3
4
7
14
42
213
2837
175450
139759600
6837625106787
266437144916648607844
508009471379488821444261986503540
37745517525533091954736701257541238885239740313139682
5347426383812697233786139576220450142250373277499130252554080838158299886992660750432


*/
import java.util.ArrayList;
import java.math.BigInteger;


class LevineTriangleRow
{
   ArrayList<Integer> levineTriangleRow = new ArrayList<Integer> ();

   public LevineTriangleRow ()
   {
      levineTriangleRow.add (2);
   }

   public LevineTriangleRow (LevineTriangleRow priorLevineTriangleRow)
   {
      int currentVal = 0;

      //System.out.println ("Prior row size: " + priorLevineTriangleRow.rowSize() );

      for (int k = priorLevineTriangleRow.rowSize() - 1; k >= 0; k--)
      {
         int count = priorLevineTriangleRow.getVal(k);
         currentVal++;

         //System.out.println ("-> " + count + " x " + currentVal);

         for (int c = 0; c < count; c++)
         {
            levineTriangleRow.add (currentVal);
         }
      }

      System.out.println ("Adding new row, size: " + rowSize() );
   }

   public int rowSize()
   {
      return levineTriangleRow.size();
   }

   public int getVal(int index)
   {
      return levineTriangleRow.get(index);
   }

   @Override
   public String toString()
   {
      StringBuilder sb    = new StringBuilder();

      for (int k = 0; k < levineTriangleRow.size(); k++)
      {
         sb.append (levineTriangleRow.get(k) );

         if (k < levineTriangleRow.size() - 1)
            sb.append (", ");
      }

      return sb.toString();
   }

   public BigInteger getTotal()
   {
      //long total = 0;
      BigInteger total     = new BigInteger("0");

      for (int k = 0; k < levineTriangleRow.size(); k++)
      {
         //total += levineTriangleRow.get(k);
         BigInteger nextVal     = new BigInteger("" + levineTriangleRow.get(k) );
         //System.out.print (nextVal.toString() + " + ");
         total = total.add (nextVal);
      }
      //System.out.println (" = " + total.toString() );

      return total;
   }

} // class LevineTriangleRow



public class LevineSequenceNumbers
{

   public static void main (String[] args)
   {
      System.out.println("java.version:    " + System.getProperty("java.version"));
      System.out.println("32/64 bit:        x" + System.getProperty ("sun.arch.data.model") );
      System.out.println("java.vendor:     " + System.getProperty("java.vendor"));
      System.out.println("java.vendor.url: " + System.getProperty("java.vendor.url"));


      //ArrayList<LevineTriangleRow> levineTriangleRows = new ArrayList<LevineTriangleRow> ();
      ArrayList<LevineTriangleRow> levineTriangleRows = new ArrayList<LevineTriangleRow> ();

      levineTriangleRows.add (new LevineTriangleRow () );

      //System.out.println (levineTriangleRows.size () );
      //System.out.println (levineTriangleRows.get (0) );

      for (int k = 0; k < 15; k++)
      {
         levineTriangleRows.add (new LevineTriangleRow (levineTriangleRows.get (k) ) );
      }
/*
      for (int k = 0; k < levineTriangleRows.size(); k++)
      {
         System.out.println (//(k + 1) + ". " +
                             levineTriangleRows.get (k) );
      }
*/
      System.out.println ("\nRow Totals: ");
      for (int k = 0; k < levineTriangleRows.size(); k++)
      {
         System.out.println ((k + 1) + " = " +  levineTriangleRows.get(k).getTotal().toString() );
      }

   }

} // public class LevineSequenceNumbers