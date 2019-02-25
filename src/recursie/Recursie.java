package recursie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Recursie
{

	public static void main(String[] args)
	{
		Recursie r = new Recursie();
		System.out.println("faculteitsfunctieRecursief: " + r.faculteitsfunctieRecursief(5));
		System.out.println("faculteitsfunctieNietRecursief: " + r.faculteitsfunctieNietRecursief(5));
		System.out.println("somfunctieRecursief: " + r.somfunctieRecursief(5));
		System.out.println("somfunctieNietRecursief: " + r.somfunctieNietRecursief(5));
		System.out.println("binaryOnesRecursive 0: " + r.binaryOnesRecursive(0));
		System.out.println("binaryOnesRecursive 1: " + r.binaryOnesRecursive(1));
		System.out.println("binaryOnesRecursive 3: " + r.binaryOnesRecursive(3));
		System.out.println("binaryOnesRecursive 4: " + r.binaryOnesRecursive(4));
		System.out.println("binaryOnesRecursive 8: " + r.binaryOnesRecursive(8));
		System.out.println("binaryOnesRecursive 128: " + r.binaryOnesRecursive(128));
		System.out.println("binaryOnesRecursive 256: " + r.binaryOnesRecursive(256));
		System.out.println("binaryOnesRecursive 255: " + r.binaryOnesRecursive(255));
//		System.out.println("referencedFiles: " + r.referencedFiles("data", null));
		System.out.println("binaryRepresentation 255: " + r.binaryRepresentation(255));
		System.out.println("binaryRepresentation 8: " + r.binaryRepresentation(8));
		System.out.println("binaryRepresentation 0: " + r.binaryRepresentation(0));
		System.out.println("binaryRepresentation 7: " + r.binaryRepresentation(7));
		System.out.println("binaryRepresentation 128: " + r.binaryRepresentation(128));
		System.out.println("binaryRepresentation 512: " + r.binaryRepresentation(512));
		for (int i = 0; i < 1000; i++)
		{
			int a = r.binaryOnesRecursive(i);
			int b = r.binaryRepresentation(i);
			if (a != b)
			{
				System.out.println("Does not match: " + a + " and " + b);
			}
		}
		System.out.println("Done");
	}

	public int binaryOnesRecursive(int n)
	{
		// Write a recursive method that returns the number of 1s in the binary
		// representation of N. Use the fact that this number equals the number
		// of 1s in the representation of N/ 2, plus 1, if N is odd.
		if (n <= 0) { return 0; }
		return n % 2 + this.binaryOnesRecursive(n / 2);
	}

	public int binaryRepresentation(int n)
	{
		if (n == 1)
		{
			return 1;
		} else if (n > 1) { return this.binaryRepresentation((n / 2)) + (n % 2); }
		return 0;
	}

	public int faculteitsfunctieNietRecursief(int n)
	{
		int sum = 1;
		for (int i = 2; i <= n; i++)
		{
			sum *= i;
		}
		return sum;
	}

	public int faculteitsfunctieRecursief(int n)
	{
		if (n <= 1) { return 1; }
		return n * this.faculteitsfunctieRecursief(n - 1);
	}

	public int referencedFiles(String fileName, Set<String> filesRead)
	{
		if (filesRead == null)
		{
			filesRead = new HashSet<>();
		}
		if (filesRead.contains(fileName))
		{
			return 0;
		} else
		{
			filesRead.add(fileName);
		}
		try (FileReader fileReader = new FileReader(this.getClass().getResource(fileName).getFile()))
		{
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			int sum = 0;
			while ((line = bufferedReader.readLine()) != null)
			{
				try
				{
					sum += Integer.parseInt(line);
				} catch (NumberFormatException e)
				{
					sum += this.referencedFiles(line, filesRead);
				}
			}
			return sum;
		} catch (Exception e)
		{
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public int somfunctieNietRecursief(int n)
	{
		int sum = 1;
		for (int i = 2; i <= n; i++)
		{
			sum += i;
		}
		return sum;
	}

	public int somfunctieRecursief(int n)
	{
		if (n <= 1) { return 1; }
		return n + this.somfunctieRecursief(n - 1);
	}
}
