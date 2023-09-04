function addTwo(num: number): number {
    return num + 2;
    //return "hello"; // this is an error bcz we said : number in function definition
}

// same function with arrow

const addTwoArrow = (n: number): number => n + 2;

console.log(addTwoArrow(5));

function handleError(errmsg: string): never { // this function 'never' returns a value. 
    throw new Error(errmsg);
}