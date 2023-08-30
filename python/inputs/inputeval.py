data = 55
modified = eval('data + 45') # will break if data is not defined

print(modified)





comm = '''
print("This print is from string command:", input("Enter a numb: "))
'''
modified = eval(comm) # will break if data is not defined

print(modified)