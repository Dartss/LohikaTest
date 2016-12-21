import FilesReader.FilesDataReader;
import FilesReader.FilesDataReaderImpl;

import java.util.*;

public class WordsCounter
{
    public void printTopRpeatedWords(String filePath,int sizeOfTop) {
	FilesDataReader filesDataReader = new FilesDataReaderImpl();

	String[] words = filesDataReader.readFile(filePath).split(" ");

	HashMap<String, Integer> occurrencesCount = countWords(words);

	List<String> sortedByOccurList = getMostRepeatedWords(occurrencesCount);

	printTopOccurrences(sortedByOccurList, sizeOfTop);
    }

    private HashMap<String, Integer> countWords(String[] words)
    {
	HashMap<String, Integer> occurrencesCount = new HashMap<>();

	for (String word : words) {
	    if (occurrencesCount.containsKey(word)) {
		occurrencesCount.put(word, occurrencesCount.get(word) + 1);
	    } else {
		occurrencesCount.put(word, 1);
	    }
	}

	return occurrencesCount;
    }

    private List<String> getMostRepeatedWords(final Map<String, Integer> map) {
	Set<String> set = map.keySet();
	List<String> keys = new ArrayList<>(set);

	Collections.sort(keys, (s1, s2) -> Double.compare(map.get(s2), map.get(s1)));

	return keys;
    }

    private void printTopOccurrences(List<String> sortedList, int sizeOfTop) {
	System.out.println("Top " + sizeOfTop + " occurrences: ");
	if (sizeOfTop > sortedList.size()) {
	    sizeOfTop = sortedList.size();
	}

	for (int i = 0; i < sizeOfTop; i++) {
	    System.out.println(sortedList.get(i));
	}
    }
}
