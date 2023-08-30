try:
	num = int(input("Enter a number:"))
	print("You entered: ",num)
except: # this will handle anything, even control c
	print("Enter a numeric without decimal")

# catch specific error as below

try:
	num = int(input("Enter a number:"))
	print("You entered: ",num)
except ValueError as ve:
	print("Enter a numeric without decimal")
	print("Technical error details:", ve)
except KeyboardInterrupt:
	print("\nYou killed the program")
	quit()

print("Program ends")