package TimeToDefence;

import java.util.Random;

public class Forest { //common resource
    int wood;

    Forest(){
        this(50000);
    }
    Forest(int wood){
        this.wood = wood;
    }

    Random random = new Random();
    public int takeWood(){
        int value =random.nextInt(1,10);
        if (this.wood - value < 0){
            int res = this.wood;
            this.wood = 0;
            return res;
        }
        else {
            this.wood -= value;
            return value;
        }

    }

}
