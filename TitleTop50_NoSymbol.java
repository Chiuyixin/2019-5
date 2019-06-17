package C_107021027_TitleTop50_NoSymbol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class TitleTop50_NoSymbol {

	public static void main(String[] args) throws IOException {
		 String str,str1;
	       int count=0;
	      
	       FileReader fr=new FileReader("c:\\Java\\2013-02_Parsed.txt");       
	       BufferedReader bfr=new BufferedReader(fr);
	       
	  
		   FileWriter fw=new FileWriter("c:\\Java\\2013-02_Parsed_wordCount.txt");
	       BufferedWriter bfw=new BufferedWriter(fw);
	       
	       FileReader fr1=new FileReader("c:\\Java\\stopWord.txt");       
	       BufferedReader bfr1=new BufferedReader(fr1);
	       
	       HashMap WordCnt = new HashMap <String, Integer>();
	       
	       
	       while((str=bfr.readLine())!=null) 
	       {
	        
	         String[] Items = new String(str.toLowerCase()).trim().split("##");
	         
	       
		       	//String obj = Items[2] + "." + Items[3];
		       	 String[] Items_Word = new String(Items[2]).trim().split("[,.¡P;'():/\\s]+");
		         boolean flag=true;
		    	   
		    	   while((str1=bfr1.readLine())!=null) {
			    	   String []stopWord= new String(str1.toLowerCase()).trim().split(",");
		
		       	 for (int i=0;i<Items_Word.length;++i) {
		       	   for(int j=0;j<stopWord.length;j++) {
	    			   if(Items_Word[i].equals(stopWord[j])) {
	    				   flag=false;
	    				   break;
	    			   }else {      
	    				   flag=true;  
	    			   } 
	    		   }
	    		   if(flag==true) {
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
	       } 
		   fr.close();   
		   fr1.close();

		  for (Object key : WordCnt.keySet()) {
	            System.out.println(key + " : " + WordCnt.get(key));
	            bfw.write(key + "\t" + WordCnt.get(key));  
	         	bfw.newLine(); 
	       }
	       bfw.flush();      
	       fw.close();     


	}

}
