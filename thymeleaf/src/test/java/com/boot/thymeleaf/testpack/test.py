try:
  n=int(input("Enter a number"))
  while 100%n==0:
    print("Good")
    
except ValueError:
  print("Invalid")