package homeWork;

	import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;

	public class homeWork {

	    public static void main(String[] args) throws IOException  {

	String InputDir = "c:\\java\\aa";
	
	File folder = new File(InputDir);
	
	int fwCnt=1;
	
	for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            //listFilesForFolder(fileEntry);
	        } else {
	            //System.out.println(fileEntry.getName());
	        	
	        	String fileName=InputDir+"\\"+fileEntry.getName();
	            
	            FileReader fr=new FileReader(fileName);
	            BufferedReader bfr=new BufferedReader(fr);
	            String str;
	            
	            FileReader fr1=new FileReader("c:\\Java\\stopWord.txt");       
	 	       BufferedReader bfr1=new BufferedReader(fr1);
	 	     
	 	       String bfrFileName="c:\\Java\\aa_WordCnt\\2016_Parse_WordCnt_"+fwCnt+".txt";
	 	      FileWriter fw=new FileWriter(bfrFileName);
		       BufferedWriter bfw=new BufferedWriter(fw);
		       
		       fwCnt++;
	 	      
	 	       String str1;
	 	       
	 	  	   HashMap<String, Integer> WordCnt = new HashMap <String, Integer>();
	 	       HashMap<String, Integer> stopWord = new HashMap <String, Integer>();
	            
	 	      while((str1=bfr1.readLine())!=null) {
		    	   String[] Items1 = new String(str1.toLowerCase()).trim().split(",");
		    	   for(int j=0;j<Items1.length;j++) {
		    		   stopWord.put(Items1[j], 0);
		    	   }
	 	      }
	 	    		  
	            while((str=bfr.readLine())!=null) {
	            	
	            	   String[] Items = new String(str.toLowerCase()).trim().split("##");
	      	         
	            	   if (Items.length >3) {
	            		   
		            		 String str2=Items[2]+" "+Items[3];
		            		   
		      		       	 String[] Items_Word = new String(str2.replaceAll("[\\pP\\p{Punct}]","")).trim().split("\\s+");
		      		
		      		       	 for (int i=0;i<Items_Word.length;++i) {
		      		       		 
		      		       		 if(stopWord.containsKey(Items_Word[i])){
		      		       			 continue;
		      		       		 }else {
		      		       			
		      		       	 	if (WordCnt.containsKey(Items_Word[i])){
		      		       	 		
		      		       	 		int temp = (int) WordCnt.get(Items_Word[i]);
		      		       	 		temp++;
		      		       	 		WordCnt.put(Items_Word[i],temp);
		      		       	 		
		      		       	 	}
		      		       	 	else {
		      		       	 		
		      		       	 		WordCnt.put(Items_Word[i],1);
		      		       	 	}
		      		       		 }
		      		       	 } 
		            	   }else if(Items.length >2) {
		            			 String[] Items_Word = new String(Items[2].replaceAll("[\\pP\\p{Punct}]","")).trim().split("\\s+");
		     		      		
			      		       	 for (int i=0;i<Items_Word.length;++i) {
			      		       		 
			      		       		 if(stopWord.containsKey(Items_Word[i])){
			      		       			 continue;
			      		       		 }else {
			      		       			
			      		       	 	if (WordCnt.containsKey(Items_Word[i])){
			      		       	 		
			      		       	 		int temp = (int) WordCnt.get(Items_Word[i]);
			      		       	 		temp++;
			      		       	 		WordCnt.put(Items_Word[i],temp);
			      		       	 		
			      		       	 	}
			      		       	 	else {
			      		       	 		
			      		       	 		WordCnt.put(Items_Word[i],1);
			      		       	 	}
			      		       		 }
			      		       	 }
		            	   }
		            	   
		      				 continue;
	            	}
	            
	            fr.close();
	            fr1.close();
	            
	            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
	  			 
	   			//Use Comparator.reverseOrder() for reverse ordering
	   		   WordCnt.entrySet()
	   			    .stream()
	   			    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	   			    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
	   		   
	   		   int cont=0;
	 		  for (Object key : sortedMap.keySet()) {
	 			  
	 			  if(cont==50-1) break;
	 			  
	 	            System.out.println(key + " : " + sortedMap.get(key));
	 	            bfw.write(key + "\t" +sortedMap.get(key));  
	 	         	bfw.newLine(); 
	 	         	cont++;
	 	       }
	 		   
	 		  
	 	       bfw.flush();      
	 	       fw.close();
	   		   
	            }
	        System.out.println("--------------------------------"+fileEntry.getName());
	           
	        }

	} 
}
