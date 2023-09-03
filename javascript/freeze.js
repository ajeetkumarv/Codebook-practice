const MATH_CONST = {
    PI: 3.14
};

Object.freeze(MATH_CONST);

MATH_CONST.PI = 99;

console.log('output ' + MATH_CONST.PI)