# Take users name and age
name = input("Enter your name: ")
age = int(input("Enter your age: "))


# Tell when they turn 100

year_turn_100 = 2025 + (100-age)

#print the result

print(name + " will turn 100 years old in years {}".format(year_turn_100))
print (name + " will turn 100 years old in years " + str(year_turn_100))