import React from 'react';
import calendar from '../static/img/calendar.png';
import cash from '../static/img/cash.png';
import person from '../static/img/person.png';


export default function Home({ auth }) {

    const redirect = (url) => {
        location.href = url + `?access_token=${ auth.access_oken }`;
    }

    return (
        <div className="d-flex flex-column justify-content-center align-items-center">
            <div className="bg-light rounded-4 shadow-bg p-5 mb-4 d-flex flex-column justify-content-center align-items-center align-self-stretch">
                <img src={ person } width="72" height="72" />
                <h3 className="fw-medium mt-2">Hello, { auth.user?.profile?.sub ||  'Friend' }!</h3>
                <p class="fs-6">Get Started below. Enjoy your journey to success.</p>
            </div>
            <div className="d-flex flex-row justify-content-center align-items-center">
                <div className="bg-light rounded-4 shadow-bg p-5 me-3 d-flex flex-column justify-content-center align-items-center home-option" onClick={ () => { redirect(process.env.GATEWAY_URL + '/calender') } }>
                    <img src={ calendar } width="48" height="48" />
                    <h3 className="fw-medium mt-2">Calendar Task Manager</h3>
                    <p class="fs-6">Manage your schedule efficiently</p>
                </div>
                <div className="bg-light rounded-4 shadow-bg p-5 ms-3 d-flex flex-column justify-content-center align-items-center home-option" onClick={ () => { redirect(process.env.GATEWAY_URL + '/expenses') } }>
                    <img src={ cash } width="48" height="48" />
                    <h3 className="fw-medium mt-2">Finance Expense Manager</h3>
                    <p class="fs-6">Track and Manage your expenses</p>
                </div>
            </div>
        </div>
    );
}