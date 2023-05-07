package eren.net.employeeservice.handler;

import eren.net.employeeservice.exception.employee.EmployeeAlreadyExist;
import eren.net.employeeservice.exception.employee.EmployeeNotFound;
import eren.net.employeeservice.utils.ResponseMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EmployeeAlreadyExist.class)
    public ResponseMap handleEmployeeAlreadyExist(EmployeeAlreadyExist e) {
        return ResponseMap.builder()
                .message(e.getMessage())
                .code(e.getCode())
                .status(e.getStatus())
                .build();
    }
    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseMap handleEmployeeNotFound(EmployeeNotFound e) {
        return ResponseMap.builder()
                .message(e.getMessage())
                .code(e.getCode())
                .status(e.getStatus())
                .build();
    }
}
