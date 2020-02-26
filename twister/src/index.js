
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import MainPage from './MainPage';
import App from './App';
import Login from './Login';
import SignUp from './SignUp';
import Test2 from './Test2';
import Friend from './Friend';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<MainPage />, document.getElementById('root'))
//ReactDOM.render(<App />, document.getElementById('root'));
//ReactDOM.render(<Test2 />, document.getElementById('root'));
////ReactDOM.render(<Login />, document.getElementById('root'));
//ReactDOM.render(<SignUp />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
