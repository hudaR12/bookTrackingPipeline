package afn.xloop.booktracker_cnsd23;

import java.util.Collection;
import java.util.Optional;

// import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Response {
    private boolean bool;
    private String msg;
    private Object data;

    // public Response(boolean bool, Book data, String msg){
    //     this.bool = bool;
    //     this.data = data;
    //     this.msg = msg;
    // }

    public Response(Boolean bool, String msg){
        this.bool = bool;
        this.msg = msg;
    }

}
