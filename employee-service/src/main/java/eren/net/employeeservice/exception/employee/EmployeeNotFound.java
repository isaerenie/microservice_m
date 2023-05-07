package eren.net.employeeservice.exception.employee;

import eren.net.employeeservice.utils.ResponseStatus;
import lombok.Getter;

@Getter
public class EmployeeNotFound extends RuntimeException{
    private final String message = "Employee not found";
    private final ResponseStatus status = ResponseStatus.ERROR;
    private final String code = "002";

}
