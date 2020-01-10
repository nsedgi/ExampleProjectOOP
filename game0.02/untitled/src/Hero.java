public class Hero {
    private int x;
    private int y;
    private boolean isAlive;
    private boolean isMovingRight;
    private boolean isMovingLeft;
    private boolean isIdle;
    private boolean isFacingRight;
    private boolean isAttacking;
    public Hero(int x, int y){
        this.x = x;
        this.y = y;
        isAlive = true;
        this.isMovingRight = false;
        this.isIdle = true;
        this.isFacingRight = true;
        this.isAttacking = false;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        isMovingLeft = movingLeft;
        this.isFacingRight= false;
        this.isAttacking = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isIdle() {
        return isIdle;
    }

    public void setIdle(boolean idle) {
        isIdle = idle;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.isMovingRight = movingRight;
        this.isFacingRight= true;
        this.isAttacking = false;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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
    } //this method is not used but is reserved for future improvements (jump, teleport, etc).

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void MoveRight () {
        this.x+=5; this.isMovingRight = true;this.isMovingLeft = false;}

    public void MoveLeft () {
        this.x-=5; this.isMovingLeft = true;this.isMovingRight = false;}
     public void StayIdle(){
        this.isMovingLeft=false;
        this.isMovingRight=false;
        this.isIdle=true;
         this.isAttacking = false;
     }

    public boolean isAttacking() { return isAttacking; } //has no use. is still here for aesthetic reasons and future improvements.

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    public void Attack(){
         this.isAttacking = true;

     }
}
