interface shape {
}

export class Point {
    private x: number;
    private y: number;

    /*
        ? makes it optional, and all params should have ? after first use of ?
    */
    constructor(x?: number, y?: number) {
        this.x = x;
        this.y = y;
    }

    // to make it concise  we can remove line 6 to 15 with below code
    /*constructor(private x? number, private y?: number) { 
        //compiler will create members and assign them values
    }*/

    draw() {
        console.log('X: ' + this.x + ', Y: ' + this.y);
    }

    get X() {
        return this.x;
    }

    set X(value) {
        if (value < 0)
            throw new Error('value cannot be less than 0.');

        this.x = value;
    }
}