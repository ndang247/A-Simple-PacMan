public class Player{
    private int x;
    private int y;
    private int collectedDots;
    private boolean exists;
    
    Player(int x, int y){
        this.x = x;
        this.y = y;
        this.exists = true;
        collectedDots = 0;
    }
    
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    
    public void collect(Dot dot){
        if (x == dot.getX() && y == dot.getY()){
            collectedDots++;
            dot.disappear();
        }
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getDots(){
        return collectedDots;
    }
    
    public boolean isNotKilled(){
        return exists;
    }
    
    public void killed(){
        exists = false;
    }
    
    @Override
    public String toString(){
        String returnVal = "Player";
        returnVal += "[";
        for (int i = 1; i <= collectedDots; i++)
        {
            returnVal += "*";
        }
        returnVal+= "]" + Util.objectStr(x, y, exists);
        return returnVal;
    }
}