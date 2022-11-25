import React, { Component } from 'react';
import HomeService from '../services/HomeService';

class CreateHomeComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
    city:'',
	district:'',
	neighborhood:'',
	status:'',
	ownerName:'',
	ownerSurname:'',
	ownerPhone:'',
	price:''
        }
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeDistrictHandler = this.changeDistrictHandler.bind(this);
        this.changeNeighborhoodHandler = this.changeNeighborhoodHandler.bind(this);
        this.changeStatusHandler = this.changeStatusHandler.bind(this);
        this.changeOwnerNameHandler = this.changeOwnerNameHandler.bind(this);
        this.changeOwnerSurnameHandler = this.changeOwnerSurnameHandler.bind(this);
        this.changeOwnerPhoneHandler = this.changeOwnerPhoneHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);
        this.saveOrUpdateHome = this.saveOrUpdateHome.bind(this);
    }

    saveOrUpdateHome = (e) =>{
        e.preventDefault();
        let home = {city: this.state.city, district: this.state.district, neighborhood: this.state.neighborhood, 
            status:this.state.status,ownerName:this.state.ownerName,ownerSurname:this.state.ownerSurname,
            ownerPhone:this.state.ownerPhone,price:this.state.price};
        console.log('home => ' + JSON.stringify(home));

        HomeService.createHome(home, this.state.id).then( res => {
            this.props.history.push('/homes');
        });

    }

    changeCityHandler=(event) =>{
        this.setState({city: event.target.value});
    }
    changeDistrictHandler=(event) =>{
        this.setState({district: event.target.value});
    }
    changeNeighborhoodHandler=(event) =>{
        this.setState({neighborhood: event.target.value});
    }
    changeStatusHandler=(event) =>{
        this.setState({status: event.target.value});
    }
    changeOwnerNameHandler=(event) =>{
        this.setState({ownerName: event.target.value});
    }
    changeOwnerSurnameHandler=(event) =>{
        this.setState({ownerSurname: event.target.value});
    }
    changeOwnerPhoneHandler=(event) =>{
        this.setState({ownerPhone: event.target.value});
    }
    changePriceHandler=(event) =>{
        this.setState({price: event.target.value});
    }
    cancel(){
        this.props.history.push('/homes');
    }
    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md3 offset-md-3">
                        <h3 className="text-center">Ev Ekle/Güncelle</h3>
                        <div className="card-body">

                            <form>
                               <div className="form-group">
                                   <label>İl</label>
                                   <input placeholder="City" name="city" className="form-control" 
                                                value={this.state.city} onChange={this.changeCityHandler}/>
                                        
                                </div> 
                                <div className="form-group">
                                   <label>İlçe</label>
                                   <input placeholder="District" name="district" className="form-control" 
                                                value={this.state.district} onChange={this.changeDistrictHandler}/>
                                        
                                </div>
                                <div className="form-group">
                                   <label>Mahalle</label>
                                   <input placeholder="Neighborhood" name="neighborhood" className="form-control" 
                                                value={this.state.neighborhood} onChange={this.changeNeighborhoodHandler}/>
                                        
                                </div>
                                <div className="form-group">
                                   <label>Durum</label>
                                   <input placeholder="Status" name="status" className="form-control" 
                                                value={this.state.status} onChange={this.changeStatusHandler}/>
                                        
                                </div>
                                <div className="form-group">
                                   <label>Ev Sahibi Adı</label>
                                   <input placeholder="OwnerName" name="ownerName" className="form-control" 
                                                value={this.state.ownerName} onChange={this.changeOwnerNameHandler}/>
                                        
                                </div>
                                <div className="form-group">
                                   <label>Ev Sahibi Soyadı</label>
                                   <input placeholder="OwnerSurname" name="ownerSurname" className="form-control" 
                                                value={this.state.ownerSurname} onChange={this.changeOwnerSurnameHandler}/>
                                        
                                </div>
                                <div className="form-group">
                                   <label>Ev Sahibi Numarası</label>
                                   <input placeholder="OwnerPhone" name="ownerPhone" className="form-control" 
                                                value={this.state.ownerPhone} onChange={this.changeOwnerPhoneHandler}/>
                                        
                                </div>
                                <div className="form-group">
                                   <label>Fiyat</label>
                                   <input placeholder="Price" name="price" className="form-control" 
                                                value={this.state.price} onChange={this.changePriceHandler}/>
                                        
                                </div>
                                <button className="btn btn-success" onClick={this.saveOrUpdateHome}>Kaydet</button>
                                <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>İptal</button>
                                

                            </form>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateHomeComponent;