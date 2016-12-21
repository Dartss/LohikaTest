import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String...arg)
    {
	System.out.println("Enter path to the file and number of most repeated words to print.\n "
			+ "Or enter only word to check whether it's palindrome.\n \"q\" for exit.");
	BufferedReader br = null;

	try {

	    br = new BufferedReader(new InputStreamReader(System.in));

	    while (true) {
		System.out.print(':');
		String input = br.readLine();

		if ("q".equals(input)) {
		    System.out.println("Exit!");
		    System.exit(0);
		}

		if (!input.isEmpty()) {
		    String[] inputArray = input.split(" ");
		    System.out.println("args length " + inputArray.length);
		    if (inputArray.length == 2) {
		    	String path = inputArray[0];
		    	String topRepeatedSize = inputArray[1];

		    	File file = new File(path);
		    	if(file.exists() && !file.isDirectory()) {
				WordsCounter wordsCounter = new WordsCounter();
				wordsCounter.printTopRpeatedWords(path, Integer.valueOf(topRepeatedSize));
		    	}
		    } else {
			try {
			    System.out.println("Checking whether "+input+" is palindrome : ");
			    System.out.println(isPalindrome(input)?"it's palindrome":"it's not palindrome");
			} catch (Exception e) {
			    System.out.println("Arguments were wrong, try again : " + e.getMessage());
			}
		    }
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (br != null) {
		try {
		    br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
    }



    private static boolean isPalindrome(String text) {
	StringBuilder sb = new StringBuilder(text);
	return text.equals(sb.reverse().toString());
    }
}
