# Tic-Tac-Toe Game

## Overview

This is a simple command-line Tic-Tac-Toe game implemented in Java. The game follows the **Factory Design Pattern** to create playing pieces dynamically. It allows for an extensible design where additional playing pieces and players can be added easily.

## Features

- Supports up to 2 players with customizable names.
- Implements a **Factory Design Pattern** for playing pieces.
- Uses a **queue-based turn management** system for smooth gameplay.
- Checks for winning conditions including rows, columns, and diagonals.
- Handles invalid moves and prevents overwriting existing board positions.
- Can be easily extended to support:
  - More players
  - Additional playing pieces
  - Different board sizes.

## Class Structure

### 1. **Main.java**

- Controls the game flow, manages player turns, and handles user input.

### 2. **Board.java**

- Represents the game board and provides methods to get the board state.

### 3. **PieceType.java**

- Enum defining the different types of playing pieces (X, O).

### 4. **PlayingPiece.java**

- Abstract class representing a playing piece.

### 5. **PlayingPieceFactory.java**

- Implements the **Factory Pattern** to create playing pieces dynamically based on user input.

### 6. **PlayingPieceX.java & PlayingPieceO.java**

- Concrete implementations of playing pieces X and O.

## How to Run

1. Clone the repository:
   ```sh
   git clone https://github.com/VamsiMakke87/tic-tac-toe.git
   ```
2. Navigate to the project directory:
   ```sh
   cd tic-tac-toe
   ```
3. Compile the Java files:
   ```sh
   javac Main.java
   ```
4. Run the game:
   ```sh
   java Main
   ```

## Extensibility

This project is designed to be **easily extensible**:

- **More Players**: You can increase the number of players by modifying the set of available playing pieces.
- **New Playing Pieces**: Just create a new class extending `PlayingPiece` and update the `PlayingPieceFactory`.
- **Different Board Sizes**: Can be configured in the `Main` class to support various grid sizes.


