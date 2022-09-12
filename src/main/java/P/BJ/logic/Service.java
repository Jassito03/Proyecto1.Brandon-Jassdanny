package P.BJ.logic;

import P.BJ.data.Data;

public class Service {
    private Data data;
    private static Service theInstance;
    private Service(){ data = new Data(); }

    public static Service instance(){
        if(theInstance == null){
            theInstance = new Service();
        }
        return theInstance;
    }
}
