class hello_class:
    data = 0.0

    def __init__(self, greet1, greet2):
        self.greet1 = greet1
        self.greet2 = greet2

    def greeter1(self): #don't name it same as any memember name, for eg greet1 won't work
        return self.greet1
    
    def greeter2(self):
        return self.greet2

#------------------------

hello = hello_class('Good','Morning')
print(hello.greeter1())
print(hello.greeter2())
print(hello.data)

helloHindi = hello_class('Shubh','prabhat')
helloHindi.data = 1.0
print(helloHindi.greeter1())
print(helloHindi.greeter2())
print(helloHindi.data)

print(hello.data)