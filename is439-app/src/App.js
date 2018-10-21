import React, { Component } from 'react';
import './App.css';
import { Home } from './pages/form';
import {Success} from './pages/success'
import createHistory from 'history/createBrowserHistory';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

const history = createHistory();

class App extends Component {
  render() {
    const application = "M Malls Digital Redemption";
    const description = "This is a pilot test";

    return (
      <Router history={history}> 
        <div className="App">
          <header className="App-header">
            <h1 className="App-title">{application}</h1>
          </header>
          <br></br>
                <Route exact path="/" component={Home}  />
                <Route path="/success" component={Success} />
          
        </div>
        </Router>

    );
  }
}

export default App;
