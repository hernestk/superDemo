// Hernest Koroli
// Array2DMixup.java

void main()
{
	int rows = 5; // For debugging, try making these values smaller.
	int columns = 8;
	int[][] table = makeRandomTable(rows, columns);
	printTable(table);
	IO.println(getTableAverage(table));
}

double getTableAverage(int[][] table)
{
	// Rearrange the lines below to get the expected behavior. 
	// You will not need every line!
	// Except for curly braces, you should not use any line more than once.
	// Indentation counts!
	
	// for(int j = 0; j < table.length; j++)
	// {
	// 	
	// } 
	// columns = table[i].length;
	// double average = sum / (rows + columns);
	// columns = table[0].length;

	double sum;
	sum = 0;
	
	int rows;
	rows = table.length;
	int columns;
	columns = table.length;
	
	for(int i = 0; i < table.length; i++)
	{
		for(int j = 0; j < table[i].length; j++)
		{
			sum += table[i][j];
		}	
	}
	double average = sum / (rows * columns);
	return average;
}


// DO NOT EDIT BELOW THIS LINE
// I alterd the style to be consistent. Nothing else changed.
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