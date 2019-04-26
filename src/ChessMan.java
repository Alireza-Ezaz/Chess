public abstract class ChessMan {
    private String color;
    private String name = "";
    private int currentx;
    private int currenty;

    public ChessMan(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return name + color;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentx(int currentx) {
        this.currentx = currentx;
    }

    public void setCurrenty(int currenty) {
        this.currenty = currenty;
    }

    public int getCurrentx() {
        return currentx;
    }

    public int getCurrenty() {
        return currenty;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    abstract boolean move(int x,int y);




}
