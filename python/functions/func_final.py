values=list()

def add_to_list(data):
	values.append(data)

print(values)
add_to_list("one")
print(values)

print("Trying to reassign values will not have an effect on outer variable.")

def reassign_value(newList):
	values = newList

reassign_value(list())
print(values)

e = 5

def change_prim():
	e = 55
	print("withing function:", e)

change_prim()
print("after change_prim()",e)

def try_use():
	e = 10
	e = e + 55
	print("withing function:", e)

try_use()
print("after try_use()",e)