import { Point } from "./point";

let emptyPoint: Point = new Point(); // works bcz we have x? and y?
let point = new Point(5, 6);
point.draw();

point.X = 10; // setter is called here
console.log('Point: ' + JSON.stringify(point));
