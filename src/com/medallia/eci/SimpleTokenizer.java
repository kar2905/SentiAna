package com.medallia.eci;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class SimpleTokenizer {
	TokenizerME tokenizer;
	
	public SimpleTokenizer(){
		
InputStream modelIn;
try {
	modelIn = new FileInputStream("lib/en-token.bin");
	try {
		TokenizerModel model = new TokenizerModel(modelIn);
		 tokenizer = new TokenizerME(model);

		}
		catch (IOException e) {
		e.printStackTrace();
		}
		finally {
		if (modelIn != null) {
		try {
		  modelIn.close();
		}
		catch (IOException e) {
		}
		}
		}
} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}





	}
	
	public String[] tokenize(String s){
		//System.out.println(s);
		String tokens[] = tokenizer.tokenize(s);
		return tokens;

	}


}
