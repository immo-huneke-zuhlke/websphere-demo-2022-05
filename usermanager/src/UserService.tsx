import axios from "axios";
function UserService(hostUrl: string) {
    const userEndpoint = "/api/user";
    const userApi = hostUrl + userEndpoint;

    function getUserDetails (id: string) {
        return axios.get(userApi + "/" + id)
            .then(res => {
                const usersRes = res.data;
                return usersRes;
            })
    }

    function getUsers() {
        return axios.get(userApi)
            .then(res => {
                const usersRes = res.data;
                return usersRes;
            })
    }

    function saveUser(user : Map<string, any>){
        return axios.post(userApi, user)
            .then(res => {
                const usersRes = res.data;
                return usersRes;
            })
    }

    return {
        'getUserDetails': getUserDetails,
        'getUsers': getUsers,
        'saveUser': saveUser
    }
}
export default UserService