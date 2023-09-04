function identity(arg: number) : number {
    return 5;
}

function identityGeneric<Type>(arg: Type): Type {
    return arg;
}

function identityGenShort<T, R>(arg: T): R {
    return <R>5;
}