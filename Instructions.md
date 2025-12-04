# Lab 15

## Concert Seat Map 

A new concert venue has opened in Denver and you will design a program to manage their seating chart. 

First, create the class `Seat`. Each `Seat` object has the following private instance variables, appropriate getters/setters, along with a constructor. 
- `boolean sold` - a true/false value representing if the ticket has been sold
- `String type` - type "R" represents a regular ticket, "P" represents a premium ticket, and "G" represents a general admission ticket
- `double price` - the price of the ticket

Then, create a class `Venue`. 
- `Venue`  has one instance variables, a 2D array of `Seat` representing each seat. 
- `Venue` has one constructor:  `Venue(int row, int col, double price)` - `row` represents the number of rows in the venue, and `col` represents the number of seats in each row and `price` represents the price of a regular ticket. When creating each seat, assume each is a regular ticket.

Venue has the following methods:

| Method Header                                                              | Description                                                                                                       |
| -------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------- |
| public boolean buyTicket(int row, int col)                                 | If the ticket is available, mark the ticket as sold and return true. Otherwise, return false.                     |
| private boolean isAvailable(int row, int col)                              | Returns true if the ticket is available, and false if it is sold                                                  |
| public void setPremium(int row, double price)                              | Designates a row of seats as "premium" and updates Seat values appropriately, increasing the price of the tickets |
| public void setPremium(int row, int colStart, int colEnd, double price)    | Designates a row of seats as "premium" and updates Seat values appropriately, increasing the price of the tickets |
| public void setGA(int row, double price)                                   | Designates a row of seats as "general admission" and updates Seat values appropriately                            |
| public boolean importTickets(String filename) throws IOException           | Given a file of tickets sold and updates seats accordingly                                                        |
| public double totalRevenue()                                               | Calculates the total price of all the sold tickets                                                                |
| public double totalRevenue(int col)                                        | Calculates the total price of all the sold tickets in a given column                                              |
| public int totalSold()                                                     | Calculates the number of tickets that have been sold                                                              |
| public int totalSold(int row)                                              | Calculates the total number of tickets that have been sold in a given row                                         |
| public void printVenue()                                                   | Prints each seat and the venue's sold value                                                                       |
| public void printVenueType()                                               | Prints each seat and the venue's type value                                                                       |
| public void printVenuePrice()                                              | Prints each seat and the venue's price value                                                                      |
| public double maxPrice(int rowStart, int rowEnd, int colStart, int colEnd) | Returns the maximum ticket price in the region (inclusive)                                                        |
| public boolean containsGA(int row)                                         | Returns true if the row contains general admission tickets                                                        |
| public boolean allPremium(int col)                                         | Returns true if every ticket in the column is a premium ticket                                                    |
`sold.txt`
```
10,34  
15,30  
16,29  
1,40  
5,1  
18,35  
19,0  
8,9  
10,6  
17,21  
4,30  
14,40  
6,2  
14,49  
7,10  
6,20  
18,19  
13,35  
18,28  
7,28  
19,2  
12,27  
0,7  
12,36  
6,4  
7,3  
8,32  
7,12  
1,26  
15,25  
2,25  
16,24  
8,41  
18,30  
16,42  
11,0  
0,0  
15,46  
13,12  
10,22  
8,34  
16,17  
1,28  
0,30  
18,23  
11,39  
17,0  
0,48  
3,19  
5,16  
6,45  
16,1  
7,7  
1,21  
19,36  
18,16  
2,29  
1,39  
12,15  
15,41  
5,18  
10,8  
15,13  
19,38  
19,47  
0,43  
9,0  
3,14  
13,9  
18,2  
7,2  
1,16  
0,27  
2,24  
5,41  
11,36  
0,45  
12,10  
6,24  
13,39  
3,16  
6,33  
4,15  
15,45  
10,3  
1,0  
19,15  
11,11  
17,36  
2,17  
0,29  
5,43  
12,3  
12,12  
15,29  
1,48  
10,5  
1,11  
10,23  
0,31  
12,5  
4,1  
3,11  
7,27  
15,40  
6,37  
8,1  
5,20  
16,2  
2,12  
3,41  
2,21  
19,37  
15,15  
9,45  
7,20  
1,34  
10,0  
10,9  
9,29  
0,26  
15,8  
15,35  
6,32  
7,40  
8,5  
0,1  
9,13  
13,13  
14,45  
6,7  
9,40  
6,16  
7,15  
13,31  
6,25  
4,7  
7,33  
1,47  
18,33  
16,45  
8,7  
2,0  
8,16  
2,9  
19,25  
9,24  
15,3  
14,47  
16,11
```

Use the class below to test your program: 

```
public class Main {  
    public static void main(String[] args) {  
        System.out.println("Create new venue with 20 rows of 50 columns with default price of 50.00.");  
        Venue venue = new Venue(20, 50, 50.0);  
  
        System.out.println("Set first 4 rows to premium with price 100.00.");  
        int row = 0;  
        while(row < 5){  
            venue.setPremium(row, 100.00);  
            row++;  
        }  
  
        System.out.println("Set center 9 seats in rows 5 through 10 as premium with price 75.00.");  
        row = 5;  
        while(row < 11){  
            venue.setPremium(row, 20, 29, 75.00);  
            row ++;  
        }  
  
        System.out.println("Set last 5 rows to general admission with price 25.00.");  
        row = 14;  
        while(row < 20){  
            venue.setGA(row, 25.00);  
            row++;  
        }  
  
        if(venue.importTickets("sold_150.csv")){  
            System.out.println("\nTotal Revenue: " + venue.totalRevenue()); // 8650.0  
            System.out.println("Total Revenue, Column 27: " + venue.totalRevenue(27)); // 225.0  
  
            System.out.println("\nTotal Sold: " + venue.totalSold()); // 150  
            System.out.println("Total Sold, Row 10: " + venue.totalSold(10)); // 9  
  
            System.out.println("\nMax Ticket Price, Row 0-19, Column 0-49: " + venue.maxPrice(0,19,0,29)); // 100.0  
            System.out.println("Max Ticket Price, Row 5-16, Column 20-27: " + venue.maxPrice(5,16,20,27)); // 75.0  
  
            System.out.println("\nContains GA, Row 7: " + venue.containsGA(7)); // false  
            System.out.println("Contains GA, Row 18: " + venue.containsGA(18)); // true  
  
            System.out.println("\nAll are Premium, Col 24: " + venue.allPremium(24)); // false  
        }  
  
  
//        venue.printVenue();  
//        venue.printVenueType();  
//        venue.printVenuePrice();  
    }  
}
```

## Matrix Puzzle Board 

First, use `Random.random()` to generate a 5 by 5 integer array of random integers between 1 - 15.

Then, create the static method `detectEquivalentAdjacentPairs(int[][] arr)` which counts the number of equivalent adjacent pairs are in the list.

For example in:
```
5, 13, 7, 7, 9
2, 12, 10, 12, 5
6, 8, 9, 9, 10
11, 15, 15, 4, 7
2, 1, 1, 1, 4
```

There are 5 consecutive adjacent pairs.

Now, create the static method `checkDuplicates(int[][] arr)` which finds the number of duplicate entries in the list. For the array above, the method would print:

```
1: 3
2: 2
4: 2
5: 2
7: 3
9: 3
10: 2
12: 2
15: 2
```

Create a static method `shiftRight(int[][] arr, int shift, int row)` which shifts the elements in row `row` right `shift` times.

For example, if we called the method with a shift of 2 on row 3, we would get: 

```
5, 13, 7, 7, 9
2, 12, 10, 12, 5
6, 8, 9, 9, 10
4, 7, 11, 15, 15
2, 1, 1, 1, 4
```

Create a static method `shiftUp(int[][] arr, int shift, int col)` which shifts the elements in row `row` right `shift` times.

For example, if we called the method with a shift of 3 on col 1, we would get: 

```
5, 7, 7, 7, 9
2, 1, 10, 12, 5
6, 13, 9, 9, 10
4, 12, 11, 15, 15
2, 8, 1, 1, 4
```

Create a static method `reverseRow(int[][] arr, int row)` which reverses the elements in row `row`. Create another method `reverseColummn(int[][] arr, int col)` which does the same but for columns instead.
