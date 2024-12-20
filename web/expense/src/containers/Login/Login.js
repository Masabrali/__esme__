import React, { Component } from 'react';
import classes from './Login.module.css';
import {Link} from 'react-router-dom';
import { connect } from 'react-redux';
import * as actions from '../../store/actions/index';
import 'react-toastify/dist/ReactToastify.css';
import md5 from 'crypto-js/md5';
import { validateEmail } from '../../store/validators/validators';

class Login extends Component {
    state = {
        email: {
            value: "",
            valid: true
        },
        password: "",
        valid: false
    }
    checkValidity = (email, password) => {
        let isValid = true;
        isValid = isValid && email;
        isValid = isValid && password!=="";
        this.setState({valid: isValid});
    }
    updateEmail = (event) => {
        const val = event.target.value;
        this.setState({email: {
            ...this.state.email, 
            value: val, valid: 
            validateEmail(val)
        }});
        this.checkValidity(validateEmail(val), this.state.password);
    }
    updatePassword = (event) => {
        const val = event.target.value;
        this.setState({password: val});
        this.checkValidity(this.state.email.valid, val);
    }
    loginHandler = () => {
        const logindata = {
            email: this.state.email.value,
            password: md5(this.state.password).toString()
        }
        this.props.onLogin(logindata);
    }
    render() { 
        return (
            <div>
                <div className={classes.header}>
                    <h1>Expense And Receipt Manager</h1>
                </div>
                <div className={classes.Login}>
                    <div className={classes.logincard}>
                        <h1>Authentification</h1>
                        <input type="email" placeholder="Enter Email"
                                onChange={this.updateEmail}
                                value={this.state.email.value}
                                className={this.state.email.valid ? classes.normal : classes.red} />
                        <input type="password" placeholder="Enter Password"
                                onChange={this.updatePassword}
                                value={this.state.password} />
                        <button disabled={!this.state.valid} type="button"
                            onClick={this.loginHandler}>Log In</button>
                        <p>New User? <Link to="/signup">Register</Link></p>
                    </div>
                </div>
            </div>
        );
    }
}

const mapDispatchtoProps = dispatch => {
    return {
        onLogin: (logindata) => dispatch(actions.onLogin(logindata))
    }
}
 
export default connect(null, mapDispatchtoProps)(Login);