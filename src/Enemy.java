public class Enemy{
    private int x;
    private int y;
    
    Enemy(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    @Override
    public String toString(){
        return "Enemy" + Util.objectStr(x, y, true);
    }
}