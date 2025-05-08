import React, { useEffect, useState } from 'react'
import {useNavigate} from 'react-router-dom'
import EmpService from '../EmpServiuce/EmpService';

const EmployeeList = () => {

        const [loading, setloading] = useState(true);
        const [employees , setemployees] = useState(null);

        useEffect(()=>{
            setloading(true);
            const fechdata = async() => {
                try{
                    const response =await EmpService.getEmployee();
                    setemployees(response.data);
                }
                catch(error){
                    console.log(error);
                };
                setloading(false)
            };
            fechdata();
        }, []);

        const deleteEmployee = (e,id) =>{
            e.preventDefault();
            EmpService.deleteEmployee(id)
            .then(()=>{
                if(employees)
                {
                    setemployees((prevElements) => {
                        return prevElements.filter((employee)=> employee.id !== id);
                    })
                }
            });
        }

        const editEmployee = (e,id) =>{
            e.preventDefault();
            navigate(`/editemployee/${id}`)
        };

    const navigate = useNavigate();
    return (
    <div className='container mx-auto my-8'>
    <div>
        <button onClick={() => navigate("/addEmployee")} 
        className='bg-slate-600  hover:text-blue-400  my-10 font-semibold px-20 py-2 rounded items-center'>
            Add 🧑‍💻 Employee 
        </button>
    </div>

    <div>
        <table className='shadow'>
        <thead className='bg-slate-600'>
            <th className='px-6 py-3 uppercase tracking-wide'>Name</th>
            <th className='px-6 py-3 uppercase tracking-wide'>Phone</th>
            <th className='px-6 py-3 uppercase tracking-wide'>Email</th>
            <th className='px-6 py-3 uppercase tracking-wide'>Action</th>
        </thead>
        {!loading && (
            <tbody>
                    {employees.map((employee) => (
                    <tr className='hover:bg-white hover:text-black'>
                    <td className='text-left px-6 py-4 whitespace-nowrap' >{employee.name}</td>
                    <td className='text-left px-6 py-4 whitespace-nowrap' >{employee.phone}</td>
                    <td className='text-left px-6 py-4 whitespace-nowrap' >{employee.email}</td>
                    <td className='text-left px-6 py-4 whitespace-nowrap space-x-2' >
                    <a onClick={(e,id) => editEmployee(e,employee.id)}
                    className='hover:text-green-500 hover:cursor-pointer'>
                        Edit 📝</a>
                    <a onClick={(e,id) => deleteEmployee(e,employee.id)}
                    className='hover:text-red-500 hover:cursor-pointer'
                    >Delete 🗑️</a>
                    </td>
                    </tr>
                ))}
            </tbody>
        )}
        
        </table>
    </div>
    </div>
    )
}

export default EmployeeList
