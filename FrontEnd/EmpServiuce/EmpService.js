import axios from 'axios'

const EMPLOYEE_SAPI_BASE_URL = "http://localhost:8080/employees"

class EmpService{
    saveEmployee(employee){
        return axios.post(EMPLOYEE_SAPI_BASE_URL , employee)
    }

    getEmployee(){
        return axios.get(EMPLOYEE_SAPI_BASE_URL)
    }

    getEmployeebyid(id)
    {
        return axios.get(EMPLOYEE_SAPI_BASE_URL+"/"+id)
    }

    deleteEmployee(id)
    {
        return axios.delete(EMPLOYEE_SAPI_BASE_URL+"/"+id)
    }

    updateEmployee(employee , id)
    {
        return axios.put(EMPLOYEE_SAPI_BASE_URL+"/"+id , employee)
    }
}

export default new EmpService();