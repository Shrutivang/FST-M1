# enter user names
user1 = input("Player1 please enter your name  ")
user2 = input("Player2 please enter your name  ")

# check the player's choices
valid_moves = ['rock','paper','scissors']
user1_ans = input("{} what do you choose: rock,paper or scissors  ".format(user1) )
user2_ans = input("{} what do you choose: rock,paper or scissors  ".format(user2) )

#check for valid inputs

if user1_ans not in valid_moves or user2_ans not in valid_moves:
    print("Invalid input. Please enter rock, paper or scissors.")
else:
# play the game
    if user1_ans == user2_ans:
        print("Its is a tie")
    elif user1_ans == 'rock': 
        if user2_ans =='scissors':
            print("{} Wins!".format(user1))
        elif user2_ans == 'paper':
            print("{} Wins!".format(user2))

    elif  user1_ans == 'paper': 
        if user2_ans == 'scissors':
            print("{} Wins!".format(user2))  
        elif user2_ans == 'rock':
            print("{} Wins!".format(user1))

    elif  user1_ans == 'scissors': 
        if  user2_ans == 'rock':
            print("{} Wins!".format(user2)) 
        elif   user2_ans == 'paper':
            print("{} Wins!".format(user1))
