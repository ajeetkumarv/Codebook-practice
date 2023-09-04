let myNumbers: Array<number> = [1,2,3];

let score: number | string = 33;

score = "finished. lost";

//----------------------------

type User = {
    name: string,
    id: number
}

type Admin = {
    username: string,
    id: number
}

let ajeet: User | Admin = { name: 'ajeet', id: 123 } // as User
ajeet = { username: 'ajeet', id: 123 } // as Admin

const data1: number[] = [1,2,3];
const data2: string[] = ["1", "2", "3"];
const data3: number[] | string[] = [1,2,3]; // this means either number array or string array
const data4: number | string[] = 5; // this means either a number or a string array
const data5: (number | string)[] = [1,2,3, "4"]; // array of elements that can be number or a string

//useless but possible 
let pi:3.14 = 3.14; // can only have 3.14 as value

//restricting to only these values
let seatAllotment: "aisle" | "middle" | "window";

seatAllotment = "middle";
//seatAllotment = "crewSeat"; // not possible

export {}