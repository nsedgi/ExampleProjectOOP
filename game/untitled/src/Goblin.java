public class Goblin {
    private int x;
    private int y;
    private boolean isAlive;
    private boolean isFacingRight;

    public Goblin(int x){
        this.y=270;
        this.setAlive(true);
        if(x==0){
            this.x =-100;
            this.isFacingRight=true;
        }
        else{
            this.x=700;
            this.isFacingRight=false;
        }
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean facingRight) {
        isFacingRight = facingRight;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public void MoveRight(){
        this.x+=3;
    }
    public void MoveLeft(){
        this.x-=3;
    }
}
