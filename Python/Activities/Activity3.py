# enter user names
user1 = input("Player1 please enter your name  ")
user2 = input("Player2 please enter your name  ")

# check the player's choices

user1_ans = input("{} what do you choose: rock,paper or scissors  ".format(user1) )
user2_ans = input("{} what do you choose: rock,paper or scissors  ".format(user2) )

# play the game

if user1_ans == user2_ans:
    print("Its is a tie")
else:
    if user1_ans == 'rock' and user2_ans =='scissors':
        print("{} Wins!".format(user1))
    elif user2_ans == 'paper':
        print("{} Wins!".format(user2))

    if  user1_ans == 'paper' and  user2_ans == 'scissors':
        print("{} Wins!".format(user2))  
    elif   user2_ans == 'rock':
        print("{} Wins!".format(user1))

    if  user1_ans == 'scissors' and  user2_ans == 'rock':
        print("{} Wins!".format(user2)) 
    elif   user2_ans == 'paper':
        print("{} Wins!".format(user1))



      
                  
          