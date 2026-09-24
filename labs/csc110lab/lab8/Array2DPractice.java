// Hernest Koroli
// Array2DPractice.java

void main()
{
	int rows = 4;
	int columns = 9;
	int[][] table = makeRandomTable(rows , columns);
	printTable(table);

	// loop here
	for(int i = 0; i < rows; i++)
	{
		IO.println("Highest number in row " + (i + 1) +  ": "  + getHighestInRow(table, i));
	}
}

// Write your getHighestInRow function here
// gets highestNum in the row specified.
int getHighestInRow(int[][] array, int row)
{
	int highestNum = Integer.MIN_VALUE;
	int rowLength = array[row].length; 

	for(int i = 0; i < rowLength; i++)
	{
		if(array[row][i] > highestNum)
		{
			highestNum = array[row][i];
		}
	}
	return highestNum;
}

int[][] makeRandomTable(int rows, int cols)
{
	int[][] array = new int[rows][cols];
	for(int i = 0; i < rows; i++)
    {
		for(int j = 0; j < cols; j++)
        {
			array[i][j] = (int) (Math.random() * 1000);
		}
	}
	
	return array;
}

void printTable(int[][] table)
{
	for(int row = 0; row < table.length; row++)
    {
		for(int col = 0; col < table[row].length; col++)
        {
			IO.print(String.format("%5d", table[row][col]));
		}
		IO.println();
	}
}
