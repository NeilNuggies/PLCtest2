//the program takes a c++ file and anaylze their lexical and syntax
package PLCAssingment2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LexicalandSyntaxAnaylzer {
	public static void main(String[]args) throws IOException{
		//read C++ code from file
		Path fileName= Paths.get("C:/", "Users", "nn576", "Desktop", "C++File", "HelloWorld.txt");
		String actual= Files.readString(fileName);


		//tokenize string
		String[]tokens= actual.split("");


		//regex
		String keyword= "asm|auto|break|case|catch|char|class|const|continue|defualt|delete|do|double|else|enum|extern|float|for|friend|goto|new|operator|private|protected|public|register|return|short|signed|sizeof|if|inline|int|long|new|operator|private|protected|public|register|return|short|sizedof|signed|static|struct|switch|template|this|throw|try|typedef|union|unsigned|virtual|void|volatile|while";
		String special ="[|]|{|}|<<|>|()|(|)|;|.|:"+"/"+"\\";
		String operator ="=|+|-|*|/|%|=|>|<|&|^|!|||?|,|~";
		String numbers = "[\\d\s]";
		String identifier= "[a-zA-Z]";


		//iterate through tokens 
		for(int i=0; i<tokens.length; i++) {
			//find string inside string
			Pattern pattern = Pattern.compile(tokens[i]);
			Matcher matcher1= pattern.matcher(keyword);
			Matcher matcher2= pattern.matcher(special);
			Matcher matcher3= pattern.matcher(operator);
			Matcher matcher4= pattern.matcher(numbers);
			Matcher matcher5= pattern.matcher(identifier);

			//match to regex, if the token contains the regex strings then it will print the token
			if(matcher1.find()) {
				System.out.println("Keyword: "+ tokens[i]);

			}
			else if(matcher2.find()) {
				System.out.println("special: "+ tokens[i]);
			}
			else if(matcher3.find()) {
				System.out.println("operator: "+ tokens[i]);
			}
			else if(matcher4.find()) {
				System.out.println("numbers: "+ tokens[i]);
			}
			else if(matcher5.find()) {
				System.out.println("identifiers: "+ tokens[i]);
			}else {
				System.out.println("invalid statment"); //check for correctness, if token does not match any regex then it must be incorrect
			}
		}
		//read the file once again
		Path fileName2= Paths.get("C:/", "Users", "nn576", "Desktop", "C++File", "HelloWorld.txt");
		String actual2= Files.readString(fileName2);
		//this time split file by lines
		tokens= actual2.split("\n");

		//check if line starts with a loop or token
		String FORLoop= "For|{|}";
		String IFState= "if";
		String ElseState= "else";
		String WhileLoop= "while";
		String DOCode= "do";
		String IntCode= "int";
		String FloatCode= "float";
		//statement has to be in this format, I know this will not check for all correctness, but it will require the statment will at least have the necessary elements
		String switchstate= "switch"+"{"+"}";
		String foreachstate= "foreach"+"("+":"+")"+"{"+"}";
		String dowhile= "do"+"{"+";"+"}"+"while"+"("+")"+"{"+"}";
		String blockstate= "{"+";"+"}";
		String returnstate= "return";
		String assignment= "="+";";
		String [] tokenstate= actual.split("\n");
		for(int i=0; i<tokenstate.length; i++) {

			//find string inside string
			Pattern pattern = Pattern.compile(tokenstate[i]);
			Matcher matcher1= pattern.matcher(FORLoop);
			Matcher matcher2= pattern.matcher(IFState);
			Matcher matcher3= pattern.matcher(ElseState);
			Matcher matcher4= pattern.matcher(WhileLoop);
			Matcher matcher5= pattern.matcher(DOCode);
			Matcher matcher6= pattern.matcher(IntCode);
			Matcher matcher7= pattern.matcher(FloatCode);
			Matcher matcher8= pattern.matcher(switchstate);
			Matcher matcher9= pattern.matcher(foreachstate);
			Matcher matcher10= pattern.matcher(dowhile);
			Matcher matcher11= pattern.matcher(blockstate);
			Matcher matcher12= pattern.matcher(returnstate);
			Matcher matcher13= pattern.matcher(assignment);

			//since the program token along the lines, if the programmer writes
			for(int j=0; i<tokens.length; j++) {
				//skip the lines with curly braces or space
				while(tokens[j]!= "{"||tokens[j]!="}"||tokens[j]!=" ") {

					//match to regex, if the line starts with one of these words it will output the line, 
					//this is assuming the loops or words statements are writtin in a single line
					// if the token starts with a keyword, it will assume that the line is a statment and print the appropriate one
					if(matcher1.find()) {
						System.out.println("FORLoop "+ tokenstate[j]);	
					}
					else if(matcher2.find()) {
						System.out.println("IFState "+ tokenstate[j]);
					}
					else if(matcher3.find()) {
						System.out.println("ElseState "+ tokenstate[j]);
					}
					else if(matcher4.find()) {
						System.out.println("WhileLoop "+ tokenstate[j]);
					}
					else if(matcher5.find()) {
						System.out.println("IntCode"+ tokenstate[j]);
					}
					else if(matcher6.find()) {
						System.out.println("DOCode "+ tokenstate[i]);
					}
					else if(matcher7.find()) {
						System.out.println("FloatCode "+ tokenstate[i]);
					}	
					else if(matcher8.find()) {
						System.out.println("switchstate "+ tokenstate[i]);
					}
					else if(matcher9.find()) {
						System.out.println("foreachstate "+ tokenstate[i]);
					}
					else if(matcher10.find()) {
						System.out.println("dowhile "+ tokenstate[i]);
					}
					else if(matcher11.find()) {
						System.out.println("blockstate "+ tokenstate[i]);
					}
					else if(matcher12.find()) {
						System.out.println("returnstate "+ tokenstate[i]);
					}
					else if(matcher13.find()) {
						System.out.println("returnstate "+ tokenstate[i]);
					}
					else {
						System.out.println("no statment"); //if the statment does not match any token then it is not a statment, this furthers help with correctness
					}
				}
			}
		}
	}

}
//I am not quite sure how to implement this correctly but this was my idea.
