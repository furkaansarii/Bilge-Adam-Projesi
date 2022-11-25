import axios from "axios";

const HOME_API_BASE_URL = "http://localhost:9090/api/homes";
const HOME_API_BASE_URL_DELETE = "http://localhost:9090/api/homes/{id}";
class HomeService{

    getHomes(){
        return axios.get(HOME_API_BASE_URL);
    }
    createHome(home){
        return axios.post(HOME_API_BASE_URL,home)
    }
    deleteHome(){
        return axios.delete(HOME_API_BASE_URL_DELETE)
    }
    
}

export default new HomeService()