# Variables

> _Note: All these variables are declared and initialised in `main()` itself. The variables used in other parts of the program are for local calculations only._
>

- `int x, y, z` : They are used to input and store the 3-d coordinates where the player enters the `X` or the `O` on his or her turn.
- `int winner` : It stores the winner and is outputted after the game ends.
- `int[][] z0, z1, z2` : These arrays are used to store the positions of all the `X`s and the `O`s. Basically, all three of them together make up the game board.

# Functions

```
public static void main()
```
Most of the program code is in the `main()` function. It does not return any value. It calls the other functions when and where necessary. All the important variables and arrays are declared in this method, and passed to other methods at the time of calling, if required. This is also the only method which is `public` in the entire program, so that abstraction is implemented and the user does not get confused as to which program he has to run.


```
private void instructions()
```
Is used to display the rules and instructions for playing the game, at the beginning. It does not return any value.


```
private void ifinvalid(int x, int y, int z)
```
Checks if all of the three coordinates that the user has entered are valid or not. If they are invalid, exits the program.


```
private int[][] update0(int[][] z0, int x, int y, int player)
```
Updates the array `z0[][]` with the coordinates entered by the player, by placing the player number at that coordinate. This only happens if there is no value previously at those coordinates. If that is the case, the player has to skip a turn as punishment. `update1()` and `update2()` modify arrays `z1[][]` and `z2[][]` respectively, also checking for the same condition as this method.


```
private boolean check(int[][] z0, int[][] z1, int[][] z2)
```
It checks whether the game has ended. This is done by a whole bunch of `ifs`, checking for diagonals, rows or columns in 3 dimensions of the same player.
