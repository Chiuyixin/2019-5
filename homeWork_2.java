package homeWork;

import java.util.*;
import java.io.*;

public class homeWork_2 {
	
	  //»s§@¤G¤e·j¯Á¾ð
	  public static <K, V extends Comparable<V>> Map<K, V> 
	    sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator = 
	             new Comparator<K>() {
	      public int compare(K k1, K k2) {
	       // int compare = map.get(k1).compareTo(map.get(k2));
	    	  int compare = map.get(k2).compareTo(map.get(k1));
	        if (compare == 0) 
	          return 1;
	        else 
	          return compare;
	      }
	    };
	 
	    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	  }
	  
	  public static TreeMap f(String x) throws IOException {
		    TreeMap<String,Integer> wordCnt=new TreeMap<>();
			HashMap<String,Integer> noCnt=new HashMap<>();
			
			FileReader fr=new FileReader("c:\\java\\aa"+"\\"+x);
			BufferedReader bfr=new BufferedReader(fr);
			
			FileReader fr1=new FileReader("c://java//stopWord.txt");
			BufferedReader bfr1=new BufferedReader(fr1);
			
			String str,str1;

			while((str1=bfr1.readLine())!=null) {
				String[] stopWord=new String(str1).split(",");
				for(int i=0;i<stopWord.length;i++) {
				noCnt.put(stopWord[i],0);
				}
			}
			
			while((str=bfr.readLine())!=null){
				
				String[] Items=new String(str).split("##");
				if(Items.length>2) {
					String[] Item_word=new String(Items[2].toLowerCase().replaceAll("\\p{P}","")).split("\\s+");
					for(int i=0;i<Item_word.length;i++) {
				   if(noCnt.containsKey(Item_word[i])) {
					continue;
				   }else {
					   if(wordCnt.containsKey(Item_word[i])) {
						   int temp=wordCnt.get(Item_word[i]);
						   temp++;
						   wordCnt.put(Item_word[i],temp);
					   }else {
						   wordCnt.put(Item_word[i],1);
					   }
				   }
			  }
					fr.close();
					fr1.close();
		}
				continue;
	  }
			return wordCnt;
}
	  
	  
	public static void main(String[] args) {
		
		File folder=new File("c:\\java\\aa");
		for(final File fileEntry: folder.listFiles()) {
			
			if(fileEntry.isDirectory()) {
				//listFilesForFolder(fileEntry.getName());
			}else {
				String s=fileEntry.getName();
				 // Calling the method sortByvalues
			    Map sortedMap = sortByValues(f(s));
			 
			    // Get a set of the entries on the sorted map
			    Set set = sortedMap.entrySet();
			 
			    // Get an iterator
			    Iterator i = set.iterator();
			 
			    // Display elements
			    while(i.hasNext()) {
			      Map.Entry me = (Map.Entry)i.next();
			      System.out.print(me.getKey() + ": ");
			      System.out.println(me.getValue());
			    }
			    System.out.println("----------------------");
			break;
			}
		}

	}
}
