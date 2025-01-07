package simple_api.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        return new Result(200, "success", data);
    }

    public static Result serverError(String msg) {
        return new Result(500, msg, null);
    }
}
