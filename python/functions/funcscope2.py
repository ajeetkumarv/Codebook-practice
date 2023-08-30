d = 'something'

def afunc():
	print("A function accessing value:", d)

afunc()

def overrider():
	d = 'local data'
	print("A function accessing value:", d)

overrider()

def globalaccess():
	global d
	d = 'locally modified global data'
	print("A function accessing value:", d)

globalaccess()

print("Global variable:", d)