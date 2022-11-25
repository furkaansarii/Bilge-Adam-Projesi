import React, { Component } from 'react';
import HomeService from '../services/HomeService';

class ListHomeComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            homes: []
        }
        this.addHome = this.addHome.bind(this);
        this.deleteHome = this.deleteHome.bind(this);
    }
    componentDidMount(){
        HomeService.getHomes().then((res) => {
            this.setState({homes: res.data});
        });
    }

    addHome(){
        this.props.history.push('/add-home');
    }

    deleteHome(id){
        HomeService.deleteHome(id).then( res => {
            this.setState({homes: this.state.homes.filter()});
        });
    }
    render() {
        return (
            <div>
                <h2 className="text-center">Ev Listesi</h2>
                
                <div className="row%20">
                    <button className="btn btn-primary" onClick={this.addHome}>Ev Ekle</button>
                </div>
                
                
                <div className="row">
                       <table className= "table table-striped table-bordered">
                           <thead>
                              <tr>
                                  <th>Şehir</th>
                                  <th>İlçe</th>
                                  <th>Mahalle</th>
                                  <th>Durum</th>
                                  <th>Sahip Adı</th>
                                  <th>Sahip Soyadı</th>
                                  <th>Sahip Telefon</th>
                                  <th>Fiyat</th>
                                  <th>Actions</th>
                                  
                              </tr>  

                           </thead>    

                           <tbody>
                               {
                                   this.state.homes.map(
                                       home => 
                                       <tr key = {home.id}>
                                           <td>{home.city}</td>
                                           <td>{home.district}</td>
                                           <td>{home.neighborhood}</td>
                                           <td>{home.status}</td>
                                           <td>{home.ownerName}</td>
                                           <td>{home.ownerSurname}</td>
                                           <td>{home.ownerPhone}</td>
                                           <td>{home.price}</td>
                                           <td>
                                                 <button onClick={ () => this.addHome(home.id)} className="btn btn-info">Güncelle  </button> &nbsp;
                                                 <button onClick={ () => this.deleteHome(home.id)} className="btn btn-danger"> Sil </button>
                                                 
                                             </td>
                                       </tr>
                                       
                                      
                                   )
                               }
                               
                           </tbody>                       
                        </table>                    
                </div>
            </div>
        );
    }
}

export default ListHomeComponent;