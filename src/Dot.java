public class Dot{
    private int x;
    private int y;
    private boolean exists;
    
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
        exists = true;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void disappear(){
        exists = false;
    }
    
    @Override
    public String toString(){
        return "Dot" + Util.objectStr(x, y, exists);
    }
}