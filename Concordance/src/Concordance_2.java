import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Concordance_2 
{
    private static final Pattern PATTERN_IDENTIFIER = Pattern.compile("[A-Za-z][A-Za-z0-9]* ");
//defines what an identifier can begin with in the first [] the second [] contains what can come after the first []
//the * means include the second [] 0 or more times, making it optional. The empty space at the end is a delimeter.
    
    public static void main(String[] args) 
    {
        //Store the file path of the file that will be read.
        String userFile;
     
      //Used in combination to read the file.
        //Opens a connection to the hard drive.
        FileInputStream file = null;
        
        //Reads characters from the FileInputStream.
        BufferedReader reader = null;
 
        
        //Used to read the keyboard from the command line.
        Scanner scan = new Scanner(System.in);
       
        //Stores each word and the number of times the word appears.
        HashMap<String, Integer> numberOfOcurrences = new HashMap();
        //The line numbers of the line in which the word was found.
        HashMap<String, List<Integer>> linesInWhichAppear = new HashMap();
        
        //User prompt.
        System.out.println("Welcome to Concordance_2\nPlease enter a valid file path");
        //Reads keyboard.
        userFile = scan.nextLine();
        
        try
        {
            //Opens up the file in the hard drive.
            file = new FileInputStream(userFile);
            //Prepare to read the file.
            reader = new BufferedReader(new InputStreamReader(file));
            
            //Text of the line to be read.
            String line;
            //Keeps track of the current line number.
            int lineCounter = 0;
            
            //Valid words found in current line.
            HashSet identifiersInLine;
            //Regular expression matcher.
            Matcher matcher;
            
            //Read every line until the end of the file.
            while((line = reader.readLine()) != null)
            {
                //Get set ready to store the words that are found.
                identifiersInLine = new HashSet();
                //Prepare the regular expression to find the words on the line.
                matcher = PATTERN_IDENTIFIER.matcher(line);
                
                //For every match found in the line.
                while(matcher.find()) 
                {
                    //Get the next word that was found.
                    String identifierThatWasFound = matcher.group();
                    
                    //If the word had not been found before. / If the word is not in the map.
                    if(numberOfOcurrences.containsKey(identifierThatWasFound) == false)
                    {
                        //Start the count at one and put that identifierThatWasFound into the map. 
                        numberOfOcurrences.put(identifierThatWasFound, 1);
                    } 
                    //If the word had been found on this line before. / If the word is in the map. 
                    else 
                    {
                        //Find out how many times this word has already been found.
                        int currentNumberOfOccurrences = numberOfOcurrences.get(identifierThatWasFound);
                        //We found it one more time so add one to its numberOfOccurrences.
                        currentNumberOfOccurrences++;
                        //Store the new number of times the word occured in the map.
                        numberOfOcurrences.put(identifierThatWasFound, currentNumberOfOccurrences);
                    }
                    //Last check is so duplicates are not added to the set of all identifiers in the file.
                    //If the word has not been found in this line. / If the word is not in the HashSet.
                    if(identifiersInLine.contains(identifierThatWasFound) == false)
                    {
                        //Save the word that was found in the HashSet of the words in this line.
                        identifiersInLine.add(identifierThatWasFound);
                    }
                }
                
                //Prepare to iterate through all the words found.
                Iterator<String> iterator = identifiersInLine.iterator();
              
                //for (String identifier : numberOfOcurrences.keySet())
                
                //For every word found.
                while(iterator.hasNext())
                {
                    //Get the current word that was found.
                    String identifier = iterator.next();
                    //Get the number of occurences
                    List<Integer> lineNumbers = linesInWhichAppear.get(identifier);
                    
                    //If this word has not been found.
                    if(lineNumbers == null) 
                    {
                        //Initialize the line counter.
                        lineNumbers = new ArrayList();
                    }
                    //Keep track of the current line in the line counter.
                    lineNumbers.add(lineCounter);
                    //Save the line counter for THIS word. Stores results.
                    linesInWhichAppear.put(identifier, lineNumbers);
                }
                //Advances to the next line.
                lineCounter++;
            }
        }
        
        catch(FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
        } 
        
        catch(IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        finally
        {
            try 
            {
            	scan.close();
                reader.close();
                file.close();
            } 
            catch(IOException ex)
            {
                Logger.getLogger(Concordance_2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Get the list of the words found and store it in an iterator.
        Iterator<String> identifiersIt = numberOfOcurrences.keySet().iterator();
        
        //For every word in the iterator.
        while(identifiersIt.hasNext())
        {
            //Store the next word in the found word list.
            String identifier = identifiersIt.next();
            
            //Print the word and the number of occurrences of that word.
            System.out.println(identifier + " appears >>" + numberOfOcurrences.get(identifier));
            
            //Prepare to print the lines in which the word appears.
            List<Integer> inLines = linesInWhichAppear.get(identifier);
            //Store the printout of the list of line numbers.
            StringBuilder sb = new StringBuilder();
            
            //For every line number.
            for (int i = 0; i < inLines.size(); i++)
            {
                //Builds the string containing the list of line numbers.
                sb.append(inLines.get(i)).append(" ");
            }
            //Print the list of line numbers.
            System.out.println(identifier + " in lines >>" + sb.toString());
        }
    }
}
