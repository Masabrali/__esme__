import React, { useEffect } from "react";
import { useAuth } from "react-oidc-context";
import Base from './Base';
import Home from './Home';


function Loader({ message }) {
    message = message || 'Redirecting to Login...';
    return (
        <div class="d-flex flex-column justify-content-center align-items-center p-5">
            <div class="spinner-border text-light mb-4" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>
            <h1 class="fw-medium text-white shadow">{ message }</h1>
        </div>
    );
}

export default function App() {

    const auth = useAuth();

    useEffect( () => {
        setTimeout(auth.signinRedirect, 3000);
    }, []);

    const logout = () => {
        sessionStorage.clear();
        location.href = process.env.WEBSITE_URL;
    }

    return (
        <Base
            renderNav={
                () => (
                    auth.isAuthenticated?
                        <a className="btn btn-outline-primary rounded-5 me-4 px-4 text-transform-none text-capitalize fw-medium" onClick={ logout }>Log out</a>
                    : <></>
                )
            }
        >
            {
                ((auth.activeNavigator == "signinSilent") && <Loader message='Logging you in...' />) ||
                    ((auth.activeNavigator == "signoutRedirect") && <Loader message='Logging you out...' />)
            }
            { (auth.isLoading) && <Loader /> }
            { (auth.error) && <h1 class="fw-medium text-white shadow">Oops... { auth.error.message }.</h1> }
            { (auth.isAuthenticated) && <Home auth={ auth } /> }
            { (!auth.isLoading && !auth.isAuthenticate && !auth.error && !auth.activeNavigator) && <Loader /> }
        </Base>
    );

}