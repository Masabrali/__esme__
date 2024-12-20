import React from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import '../node_modules/font-awesome/css/font-awesome.min.css';
import { createStore, applyMiddleware, compose ,combineReducers } from 'redux';
import { Provider } from 'react-redux';
import { thunk } from 'redux-thunk';
import userReducer from './store/reducers/user';
import voucherReducer from './store/reducers/voucher';
import adminReducer from './store/reducers/admin';
import managerReducer from './store/reducers/manager';
import dashboardReducer from './store/reducers/dashboard';
import axios from 'axios';

axios.defaults.baseURL = "http://localhost:8888";


const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const rootReducer = combineReducers({
  user: userReducer,
  voucher: voucherReducer,
  admin: adminReducer,
  manager: managerReducer,
  dashboard: dashboardReducer
});

const store = createStore(rootReducer, composeEnhancers(applyMiddleware(thunk)));

const root = createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Provider store={store}><App /></Provider>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
