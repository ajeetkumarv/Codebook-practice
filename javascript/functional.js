const numArray = [4, 5.6, 9.8, -2];

const squareInts = (arr) => {
    return arr.filter(n => Number.isInteger(n) && n > 0).map(n => n * n);
}

console.log(squareInts(numArray));

// creating copy of numArray
const arr2 = [...numArray]
numArray[0] = 444;
console.log('Copy ' + arr2[0]);