import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import ListHomeComponent from './components/ListHomeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateHomeComponent from './components/CreateHomeComponent';

function App() {
  return (
    <div>
      
      <HeaderComponent/>
        <div className="container">
        <Router>
          
            <Route exact path="/" component={ListHomeComponent} />
            <Route exact path="/homes" component={ListHomeComponent} />
            <Route exact path="/add-home" component={CreateHomeComponent} />
            
        
      </Router>
          
        </div>
        <FooterComponent/>
    </div>
    
  );
}

export default App;
