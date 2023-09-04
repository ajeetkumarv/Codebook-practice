function provideId(id: string | null) {
    if (!id) {
        console.log("Provide id pls");
        return
    }

    return id.toLowerCase();
}


provideId(null);
console.log(provideId("SAMPLE"));

// in operator

type Fish = {swim: () => 'Swimming' };
type Bird = {fly: () => void };

function move(animal: Fish | Bird) {
    if ("swim" in animal) {
        return animal.swim();
    }

    return animal.fly();
}

let fish: Fish = {
    swim: () => 'Swimming'
};


console.log(move(fish));

function logValue(x: Date | string) {
    if (x instanceof Date) {
        console.log(x.toUTCString());
    } else {
        console.log(x.toUpperCase());
    }
}

logValue('a string');
logValue(new Date());
