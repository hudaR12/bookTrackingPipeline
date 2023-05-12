package afn.xloop.booktracker_cnsd23;

import java.util.ArrayList;

public class Response {
    private boolean bool;
    private Book data;
    private String msg;

    public Response(boolean bool, Book data,String msg){
        this.bool = bool;
        this.data = data;
        this.msg = msg;
    }
}
