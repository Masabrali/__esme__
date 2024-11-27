import React from 'react';
import UserDashboard from './DashBoard/DashBoard';
import UserHeader from './Header/Header';
import {Routes, Route} from 'react-router-dom';
import AddExpense from '../../containers/Expense/Expense';

const User = () => {
    return (
        <div>
            <UserHeader />
            <Routes>
                <Route path="/add-expense" component={AddExpense} />
                <Route path="/" component={UserDashboard} />
            </Routes>
        </div>
    );
}
 
export default User;