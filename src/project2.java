package aakgul13Project2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class project2 {

	public static void main(String[] args) throws IOException {


		BufferedReader rd = new BufferedReader (new FileReader ("input.txt"));
		HashTable Table=new HashTable(53);
		while(true){
			String line = rd.readLine();
			if (line.length()==0) break;
			StringTokenizer tokenizer=new StringTokenizer(line);
			String key=tokenizer.nextToken();
			String value=tokenizer.nextToken();
			while(tokenizer.hasMoreTokens()){
				value+=" "+tokenizer.nextToken();
			}
			Table.put(key,value);
		}
		BufferedWriter wr=new BufferedWriter (new FileWriter("output.txt"));
		String writeLine=null;
		for(int i=0; i<Table.table_size; i++){
			if(Table.hashtable[i]!=null){
				Node current=Table.hashtable[i].head;
				while(current!=null){
					String key=current.getKey();
					String value=current.getValue();
					current=current.getNext();
					writeLine=i+":"+key+" "+value;
					wr.write(writeLine+"\n");	
				}
			}
		}		
		wr.newLine();
		while(true){
			String line=rd.readLine();
			if (line==null) break;
			StringTokenizer tokenizer=new StringTokenizer(line);
			String command=tokenizer.nextToken();
			if(command.equalsIgnoreCase("size")){
				wr.write("Size of the table is: "+Table.size()+"\n");
				wr.newLine();
			}else if(command.equalsIgnoreCase("put")){
				String key=tokenizer.nextToken();
				String value=tokenizer.nextToken();
				while(tokenizer.hasMoreTokens()){
					value+=" "+tokenizer.nextToken();
				}
				Table.put(key,value);
				writeLine=null;
				for(int i=0; i<Table.table_size; i++){
					if(Table.hashtable[i]!=null){
						Node current=Table.hashtable[i].head;
						while(current!=null){
							String keywr=current.getKey();
							String valuewr=current.getValue();
							current=current.getNext();
							writeLine=i+":"+keywr+" "+valuewr;
							wr.write(writeLine+"\n");	
						}
					}
				}		
				wr.newLine();
			}else if(command.equalsIgnoreCase("remove")){
				String key=tokenizer.nextToken();
				if(Table.containsKey(key)){
				String removing=Table.remove(key);
				wr.write(removing+" removed from the table.\n");
				}else{
				wr.write("There is no "+key+" in the table to remove.\n");
				}
				wr.newLine();
			}else if(command.equalsIgnoreCase("containskey")){
				String key=tokenizer.nextToken();
				wr.write(""+Table.containsKey(key)+"\n");
				wr.newLine();
			}else if(command.equalsIgnoreCase("keyset")){
				LinkedList keyList=Table.keySet();
				while(keyList.isthereNext()){
					String writing=keyList.Next();
					wr.write(writing+"\n");
				}
				wr.newLine();
			}else if(command.equalsIgnoreCase("empty")){
				Table.Empty();
				wr.write("HashTable is empty now.\n");
				wr.newLine();
			}

		}
		rd.close();
		wr.close();
	}


}

