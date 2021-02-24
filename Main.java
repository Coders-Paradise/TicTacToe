import java.util.Scanner;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);                    //objects
        Main obj = new Main();

        int x , y, z, winner=1;                                 //variables
        boolean game = true;
        int[][] z0 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};         //1 is O and 2 is X. (0 is nothing.)
        int[][] z1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] z2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        obj.instructions();                                     //display instructions

        while(true)                                             //game starts
        {
            System.out.println("Player 1's turn. Enter the coordinates x, y, z to place O:");
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();

            obj.ifinvalid(x,y,z);                               //check if coordinates entered by user are invalid
            if(z == 0)                                          //update array according to coordinates
                z0 = obj.update0(z0, x, y, 1);
            else if(z == 1)
                z1 = obj.update1(z1, x, y, 1);
            else
                z2 = obj.update2(z2, x, y, 1);

            if(obj.check(z0, z1, z2))                           //check if game has ended
            {
                winner = 1;
                break;
            }

            System.out.println("Player 2's turn. Enter the coordinates x, y, z to place X:");
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();

            obj.ifinvalid(x,y,z);
            if(z == 0)
                z0 = obj.update0(z0, x, y, 2);
            else if(z == 1)
                z1 = obj.update1(z1, x, y, 2);
            else
                z2 = obj.update2(z2, x, y, 2);

            if(obj.check(z0, z1, z2))
            {
                winner = 2;
                break;
            }
        }
        System.out.println("The Game has ended. the Winner is " + winner + ".");
    }

    
    private void instructions()
    {
        System.out.println("Welcome to 3D Tic-Tac-Toe!");
        System.out.println("Here are the instructions:\n");
        System.out.println("First, decide who Player 1 and Player 2 is.");
        System.out.println("Second, Enter the coordinates:");
        System.out.println("Coordinates are x, y and z (in that order).");
        System.out.println("x, y and z are integers, from 0 to 2 inclusive.");
        System.out.println("Third, Wait for your turn again. The computer will tell you when the game finishes.\n");
    }

    
    private void ifinvalid(int x, int y, int z)
    {
        if(!(x<3) || !(x>=0) || !(y<3) || !(y>=0) || !(z<3) || !(z>=0))
        {
            System.out.println("You have entered coordinates that are out of bounds in a 3x3 Grid.");
            System.out.println("Game Terminated.");
            System.exit(0);
        }
    }

    
    
    private int[][] update0(int[][] z0, int x, int y, int player)           //update array z0
    {
        if(z0[y][x] == 1)
        {
            System.out.println("An \'O\' is already present where you entered your coordinates. Chance Skipped.");
            return z0;
        }
        if(z0[y][x] == 2)
        {
            System.out.println("An \'X\' is already present where you entered your coordinates. Chance Skipped.");
            return z0;
        }
        z0[y][x] = player;
        return z0;
    }

    private int[][] update1(int[][] z1, int x, int y, int player)           //update array z1
    {
        if(z1[y][x] == 1)
        {
            System.out.println("An \'O\' is already present where you entered your coordinates. Chance Skipped.");
            return z1;
        }
        if(z1[y][x] == 2)
        {
            System.out.println("An \'X\' is already present where you entered your coordinates. Chance Skipped.");
            return z1;
        }
        z1[y][x] = player;
        return z1;
    }

    private int[][] update2(int[][] z2, int x, int y, int player)           //update array z2
    {
        if(z2[y][x] == 1)
        {
            System.out.println("An \'O\' is already present where you entered your coordinates. Chance Skipped.");
            return z2;
        }
        if(z2[y][x] == 2)
        {
            System.out.println("An \'X\' is already present where you entered your coordinates. Chance Skipped.");
            return z2;
        }
        z2[y][x] = player;
        return z2;
    }

    
    
    private boolean check(int[][] z0, int[][] z1, int[][] z2)
    {
        boolean gamedone = false;
        int player = 1;
        for(player=1;player<=2;player++)
        {
            if(z0[0][0] == player && z1[0][0] == player && z2[0][0] == player)      //ALL Z-LEVELS
                gamedone = true;                                                    //straight lines
            if(z0[0][1] == player && z1[0][1] == player && z2[0][1] == player)
                gamedone = true;
            if(z0[0][2] == player && z1[0][2] == player && z2[0][2] == player)
                gamedone = true;
            if(z0[1][0] == player && z1[1][0] == player && z2[1][0] == player)
                gamedone = true;
            if(z0[1][1] == player && z1[1][1] == player && z2[1][1] == player)
                gamedone = true;
            if(z0[1][2] == player && z1[1][2] == player && z2[1][2] == player)
                gamedone = true;
            if(z0[2][0] == player && z1[2][0] == player && z2[2][0] == player)
                gamedone = true;
            if(z0[2][1] == player && z1[2][1] == player && z2[2][1] == player)
                gamedone = true;
            if(z0[2][2] == player && z1[2][2] == player && z2[2][2] == player)
                gamedone = true;
            
            if(z0[0][0] == player && z1[1][1] == player && z2[2][2] == player)      //z-level diagonals
                gamedone = true;
            if(z0[2][0] == player && z1[1][1] == player && z2[0][2] == player)
                gamedone = true;
            if(z0[2][2] == player && z1[1][1] == player && z2[0][0] == player)
                gamedone = true;
            if(z0[0][2] == player && z1[1][1] == player && z2[2][0] == player)
                gamedone = true;

            if(z0[2][2] == player && z1[1][2] == player && z2[0][2] == player)      //up & down diagonals
                gamedone = true;
            if(z0[0][2] == player && z1[1][2] == player && z2[2][2] == player)
                gamedone = true;
            if(z0[2][1] == player && z1[1][1] == player && z2[0][1] == player)
                gamedone = true;
            if(z0[0][1] == player && z1[1][1] == player && z2[2][1] == player)
                gamedone = true;
            if(z0[2][0] == player && z1[1][0] == player && z2[0][0] == player)
                gamedone = true;
            if(z0[0][0] == player && z1[1][0] == player && z2[2][0] == player)
                gamedone = true;
            
            if(z0[2][2] == player && z1[2][1] == player && z2[2][0] == player)      //left & right diagonals
                gamedone = true;
            if(z0[2][0] == player && z1[2][1] == player && z2[2][2] == player)
                gamedone = true;
            if(z0[1][2] == player && z1[1][1] == player && z2[1][0] == player)
                gamedone = true;
            if(z0[1][0] == player && z1[1][1] == player && z2[1][2] == player)
                gamedone = true;
            if(z0[0][2] == player && z1[0][1] == player && z2[0][0] == player)
                gamedone = true;
            if(z0[0][0] == player && z1[0][1] == player && z2[0][2] == player)
                gamedone = true;

            
            for(int i=1;i<4;i++)                                                    //ONE Z-LEVEL ONLY
            {
                if(i == 2)                                                          //check all arrays
                    z0 = z1;
                else if(i == 3)
                    z0 = z2;

                if(z0[0][0] == player && z0[0][1] == player && z0[0][2] == player)  //3 in a row
                    gamedone = true;
                if(z0[1][0] == player && z0[1][1] == player && z0[1][2] == player)
                    gamedone = true;
                if(z0[2][0] == player && z0[2][1] == player && z0[2][2] == player)
                    gamedone = true;

                if(z0[0][0] == player && z0[1][0] == player && z0[2][0] == player)  //3 in a column
                    gamedone = true;
                if(z0[0][1] == player && z0[1][1] == player && z0[2][1] == player)
                    gamedone = true;
                if(z0[0][2] == player && z0[1][2] == player && z0[2][2] == player)
                    gamedone = true;
                    
                if(z0[0][0] == player && z0[1][1] == player && z0[2][2] == player)  //diagonals
                    gamedone = true;
                if(z0[2][0] == player && z0[1][1] == player && z0[0][2] == player)
                    gamedone = true;
            }
        }
        
        return gamedone;
    }
}