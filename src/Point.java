public class Point {
    private boolean live = false;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    @Override
    public String toString() {
        if(live == false)
            return " ";
        if(live == true)
            return "*";
    return null;
    }
}
