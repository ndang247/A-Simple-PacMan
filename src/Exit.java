public class Exit{
    private int x;
    private int y;
    private boolean closed;
    
    Exit(int x, int y){
        this.x = x;
        this.y = y;
        this.closed = true;
    }
    
    public boolean isNotOpen(){
        return closed;
    }
    
    public void openExit(){
        closed = false;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    @Override
    public String toString(){
        return "Exit" + Util.objectStr(x, y, closed);
    }
}