package com.itheima.exception;

/**
 * @author niyueyeee
 * @create 2019-03-24 10:20
 */
public class CanNotDeleteException extends Exception {
    public CanNotDeleteException() {
    }

    ;

    public CanNotDeleteException(String message) {
        super(message);
    }
}
