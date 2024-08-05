// https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/

import java.util.Map;

public void printDups(String str)
{
  Map<Character, Integer> count = new HashMap<>();
  for (char ch: str.toCharArray()) {
     count.put(ch, count.getOrDefault(ch,0)+1);
  }

  for (char ch : count.keySet()) {   //iterating through the unordered map 
    if (count.get(ch) > 1)   //if the count of characters is greater than 1 then duplicate found
      System.out.println(ch + ", count = " + count.get(ch));
  }
}