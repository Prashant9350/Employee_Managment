import React from 'react'

const Navbar = () => {
    return (
        <div className=' flex px-16 h-16 bg-slate-800 items-center '>
        <h1 className="text-3xl font-bold text-green-500">
            🧑‍💻 Em Service
        </h1>
        <div className='space-x-4  ml-auto'>
            <a  className="hover:text-blue-400" href='/'>Home</a>
            <a className="hover:text-blue-400" href='/'>Profile</a>
            <a className="hover:text-blue-400" href='/'>Logout</a>
        </div>
        </div>
    )
}

export default Navbar
