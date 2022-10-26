package Controller;

public class UserInput {

    String userInput;

    public UserInput(String userInput) {
        this.userInput = userInput;
    }

    public void RollDice(String userInput) {
        if(userInput.equalsIgnoreCase("R")) {
            System.out.println("Add code here to roll the dice!");
        }
    }
    
}
