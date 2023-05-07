package eren.net.employeeservice.exception.employee;

import eren.net.employeeservice.utils.ResponseStatus;
import lombok.Getter;

@Getter
public class EmployeeAlreadyExist extends RuntimeException {
    private final String message = "Employee already exists";
    private final ResponseStatus status = ResponseStatus.ERROR;
    private final String code = "001";

}
