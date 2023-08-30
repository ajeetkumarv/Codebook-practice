class Fruit:
    color ="Not mentioned"
    name ="Not mentioned"
    def __init__(self, color, name):
        self.color= color
        self.name = name
    
    def describe(self):
        print("I'm ", self.name, "my color is", self.color)


mango = Fruit('Yellow','Mango')

def test():
    mango = Fruit('yellow','Mango')
    mango.describe()
    apple = Fruit('red','Apple')
    apple.describe()

if __name__ == '__main__':
    test()