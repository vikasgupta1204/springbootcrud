let obj = {
    greetingMessage:"Welcome to Scaler Academy",
    funOne(){
        console.log(this);
    },
    funTwo:()=>{
        console.log(this);
    }
}

obj.funOne();
let fun = obj.funOne;
fun();
obj.funTwo();
let a = obj.funTwo
a();