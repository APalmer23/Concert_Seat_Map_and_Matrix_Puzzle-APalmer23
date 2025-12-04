import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Venue {
    private Seat[][] seats;
    public Venue(int row, int col, double price){
        seats = new Seat[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                seats[i][j]=new Seat(false,"R",price);
            }
        }
    }
    public boolean buyTicket(int row, int col){
        if (!seats[row][col].isSold()){
            seats[row][col].setSold(false);
            return true;
        }
        else return false;
    }
    private boolean isAvailable(int row, int col){
        if (seats[row][col].isSold())
            return false;
        else return true;
    }
    public void setPremium(int row, double price){
        for (int i=0;i<seats[row].length;i++){
            seats[row][i].setType("P");
            seats[row][i].setPrice(price);
        }
    }
    public void setPremium(int row, int colStart, int colEnd, double price){
        for (int i=colStart;i<colEnd;i++){
            seats[row][i].setType("P");
            seats[row][i].setPrice(price);
        }
    }
    public void setGA(int row, double price){
        for (int i=0;i<seats[row].length;i++){
            seats[row][i].setType("G");
            seats[row][i].setPrice(price);
        }
    }
    public boolean importTickets(String filename) throws IOException {
        File file=new File(filename);
        Scanner scan = new Scanner(file);
        String[] line = new String[2];
        while (scan.hasNextLine()){
            line=scan.nextLine().split(",");
            seats[Integer.valueOf(line[0])][Integer.valueOf(line[1])].setSold(true);
        }
        return true;
    }
    public double totalRevenue(){
        double total=0;
        for (Seat[] r:seats){
            for (Seat c:r){
                if (c.isSold())
                    total+=c.getPrice();
            }
        }
        return total;
    }
    public double totalRevenue(int col){
        double total=0;
        for (Seat[] r:seats){
            if (r[col].isSold())
                total+=r[col].getPrice();
        }
        return total;
    }
    public int totalSold(){
        int ts=0;
        for (Seat[] r:seats){
            for (Seat c:r){
                if (c.isSold())
                    ts++;
            }
        }
        return ts;
    }
    public int totalSold(int row){
        int ts=0;
        for (Seat r:seats[row]){
            if (r.isSold())
                ts++;
        }
        return ts;
    }
    public void printVenue(){
        for (Seat[] r:seats){
            for (Seat c:r){
                System.out.print(c.isSold()+" ");
            }
            System.out.println();
        }
    }
    public void printVenueType(){
        for (Seat[] r:seats){
            for (Seat c:r){
                System.out.print(c.getType()+" ");
            }
            System.out.println();
        }
    }
    public void printVenuePrice(){
        for (Seat[] r:seats){
            for (Seat c:r){
                System.out.print(c.getPrice()+" ");
            }
            System.out.println();
        }
    }
    public double maxPrice(int rowStart, int rowEnd, int colStart, int colEnd){
        double max=0;
        for (int r=rowStart;r<rowEnd;r++){
            for (int c=colStart;c<colEnd;c++){
                if (seats[r][c].getPrice()>max)
                    max=seats[r][c].getPrice();
            }
        }
        return max;
    }
    public boolean containsGA(int row){
        for (Seat i:seats[row]){
            if (i.getType().equals("G"))
                return true;
        }
        return false;
    }
    public boolean allPremium(int col){
        for (Seat[] row:seats) {
            if (!row[col].getType().equals("P"))
                return false;
        }
        return true;
    }
}
