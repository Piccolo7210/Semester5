function Player(name,marker){
    this.name= name;
    this.marker=marker;
    this.showsName = function(){
        //console.log("Player name is "+ this.name);
        return this.name+this.marker;
    }
}
Player.prototype.sayhello = function(){
    console.log("Hello i am "+this.name);
};
const player1 = new Player("Mustakim","O");
//console.log(player1.showsName());
player1.sayhello();
console.log(player1.valueOf());