# Cruise Ship Boarding System - Java Console Application

I designed this Java console application to simulate a cruise ship boarding management system for a university coursework project. The system handles 12 cabins with two implementations:

**Array-based solution featuring:**
- Interactive menu (add/view passengers, find cabins, display empty cabins)
- File I/O operations to save/load data
- Custom alphabetical sorting algorithm

**Object-oriented version using:**
- `Cabin` and `Passenger` classes
- Expense tracking per passenger
- Queue-based waiting list (with circular queue implementation)

Key features include robust error handling, data persistence, and efficient passenger management. The project demonstrates core Java concepts including arrays, OOP principles, collections, and file handling. Developed according to strict academic requirements with comprehensive testing documentation.

This was created for the University of Westminster's Software Development module (2022), showcasing my ability to implement complex requirements in clean, maintainable Java code. The dual implementations highlight different programming paradigms for solving the same problem.

## Technologies Used

- Java (console application)
- Basic file I/O

## Getting Started

1. **Clone the repository:**
   ```sh
   git clone https://github.com/YOUR_USERNAME/Cruise_Ship_Boarding_System.git
   ```
2. **Navigate to the project directory:**
   ```sh
   cd Cruise_Ship_Boarding_System
   ```
3. **Compile the Java files:**
   ```sh
   javac classes/CruiseShip/Main.java
   ```
4. **Run the application:**
   ```sh
   java classes.CruiseShip.Main
   ```

## Usage

Follow the on-screen menu to:
- Add new passengers to cabins
- View all cabins and their occupancy
- Delete passengers from cabins
- Find cabins by passenger name
- Store/load data to/from a file
- View passengers in alphabetical order

## Project Structure

```
Cruise Ship Boarding System/
│
├── .vscode/
│
├── array_only/
│   └── w1804929_arrays_only.java
│
├── classes/
│   └── CruiseShip/
│       ├── Cabin.java
│       ├── Main.java
│       └── Passenger.java
│
├── .gitignore
├── LICENSE
└── README.md
```
- **.vscode/**: VS Code workspace settings.
- **array_only/**: Contains an alternative implementation using only arrays.
- **classes/CruiseShip/**: Main Java source files for the Cruise Ship Boarding System.
- **.gitignore**: Git ignore rules.
- **LICENSE**: Project license.
- **README.md**: Project documentation.

 ```

## License

This project is open source and available under the [MIT License](LICENSE).
