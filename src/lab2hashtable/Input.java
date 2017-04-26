////////////////////////////////////////////////////////////////
package lab2hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
/**
 *
 * @author Jared Kamp
 * CSCI 232 Spring 2016
 */
class hashApp
{
	public static void main(String[] args) throws IOException
	{
		HashTable hash = null;
		int arraySize;
		String str;
                int choice;
		while(true)
		{
                    if(hash == null) //we must enter an array size first.
                    {
                        System.out.println("Welcome to Lab 1 - Hash Table Example.");
                        System.out.println("Please begin by entering the size of the array.");
                        choice = 'e';
                    }
                    else
                    {
			System.out.print("Enter first letter of ");
			System.out.print("enter, showtable, displaytrees, insert, or find: ");
			choice = getChar();
                    }
                    switch(choice)
                    {
                        case 'e':
                            System.out.println("Enter size of hash table:");
                            arraySize = getSize();
                            hash = new HashTable(arraySize);
                            System.out.println("Enter initial number of items:");
                            int items = getInt();
                            Random generator = new Random();
                            for(int i = 0; i < items; i++)
                            {
                                int rand = generator.nextInt(20);
                                hash.insert(rand);
                            }
                            break;
                        case 's':
                            hash.showTable();
                            break;
                        case 'd':
                            hash.displayTree();
                            break;
                        case 'i':
                            System.out.println("Enter key value to insert:");
                            hash.insert(getInt());
                            break;
                        case 'f':
                            System.out.println("Enter key value to find:");
                            int input = getInt();
                            Node find = hash.find(input);
                            if(find != null)
                                System.out.println("Found " + find.dData + ".\n");
                            else
                                System.out.println("Did not find " + input + ".\n");
                            break;
                        default:
                            System.out.print("Invalid Entry.\n");
                    }  // end switch
		}  // end while
	}  // end main()
	// -------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	// -------------------------------------------------------------
	public static int getSize() throws IOException
	{
		int size = 0;
		size = getInt();
                return size;
        }
	// -------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
	// -------------------------------------------------------------
} 