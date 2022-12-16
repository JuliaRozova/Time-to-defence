package TimeToDefence;

public class Camp {
    int wood;

    Camp(){
        this(0);
    }
    Camp(int wood){
        this.wood = wood;
    }

    public void addWood(int wood){
        this.wood += wood;
    }
}
