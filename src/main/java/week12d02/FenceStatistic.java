package week12d02;

public class FenceStatistic {
    private Fence fence;
    private int count;

    public FenceStatistic(Fence fence) {
        this.fence = fence;
        count = 1;
    }

    public Fence getFence() {
        return fence;
    }

    public int getCount() {
        return count;
    }

    public void increase(){
        count++;
    }
}
