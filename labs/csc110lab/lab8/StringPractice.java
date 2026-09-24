// Hernest Koroli
// StringPractice.java

void main(){
	String email1 = "brian.oneill@quinnipiac.edu";
	String email2 = "this.is.a.long.address@school.bobcat";

	
	emailSplit(email1);
	emailSplit(email2);
	
	String lyric = "Never gonna give you up, never gonna let you down";
	IO.println(charCount(lyric, 'e')); // Should be 6
	IO.println(charCount(lyric, 'N')); // Should be 1
	IO.println(charCount(lyric, ',')); // Should be 1
	IO.println(charCount(email2, '.')); // Should be 5
}

// Put emailSplit here
String[] emailSplit(String email)
{
	String[] secondHalf = email.split("@");
	String[] firstHalf = secondHalf[0].split("\\.");

	for(int i = 0; i < firstHalf.length; i++)
	{
		// brian - first index
		// oniel - second index
		IO.println(firstHalf[i]);
	}
	IO.println(secondHalf[1]);

	return firstHalf;
}

// Put charCount here
int charCount(String sentence, char letter)
{
	int charCounted = 0;

	for(int i = 0; i < sentence.length(); i++)
	{
		if(sentence.charAt(i) == letter)
		{
			charCounted++;
		}
	}
	return charCounted;
}