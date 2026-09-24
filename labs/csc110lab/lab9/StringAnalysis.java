// StringAnalysis.java
// Hernest Koroli

void main()
{
    boolean userInteracts = true;
    while(userInteracts)
    {
        String userText = IO.readln("Please enter some text: ");
        IO.println(printMenu());
        String userLetter = IO.readln("Please enter a letter to do one of the actions specifed above: ");
        executeMenu(userLetter, userText);

        if(userLetter.equals("q"))
        {
            userInteracts = false;
        }
    } 
}

String printMenu()
{
    String textLength = "l - Length of text";
    String wordCount = "w - Count words";
    String vowelCount = "v - count vowels";
    String reverse = "r - Reverse string";
    String quit = "q - Quit";

    return textLength + "\n" + wordCount + "\n" + vowelCount + "\n" + reverse + "\n" + quit;
}

String executeMenu(String letter, String text)
{   
    switch(letter)
    {
        case "l":
            IO.println("Text Length (including spaces if applied): " + text.length());
                break;
            case "w":
                IO.println("Word Count: " + countWords(text));
                break;
            case "v":
                IO.println("Vowel Count: " + countVowels(text));
                break;
            case "r":
                IO.println("Reverse Text: " + reverseText(text));
            case "q":
                return "The program has ended";
            default:
                return "Invalid character or letter. Try again.";
        }
    return "what";
}

int countWords(String text)
{
    String[] words = text.split(" ");
    int wordsCounted = 0;

    for(int i = 0; i < words.length; i++)
    {
        wordsCounted++;
    }
    return wordsCounted;
}

int countVowels(String text)
{
    int vowelsCounted = 0;
    for(int i = 0; i < text.length(); i++)
    {

        if(text.charAt(i) == 'A' || text.charAt(i) == 'E' || text.charAt(i) == 'I' || text.charAt(i) == 'O' || text.charAt(i) == 'U')
        {
            vowelsCounted++;
        }

        if(text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'i' || text.charAt(i) == 'o' || text.charAt(i) == 'u')
        {
            vowelsCounted++;
        }
    }
    return vowelsCounted;
}

String reverseText(String text)
{
    String reversedText = "";

    for(int i = text.length() - 1; i >= 0; i--)
    {
        reversedText += text.charAt(i);
    }
    return reversedText;
}