import axios from "axios";
function UserService(hostUrl: string) {
    const userEndpoint = "/api/user";
    const userApiGetAll = hostUrl + userEndpoint;

    function getUserDetails (id: string) {
        return axios.get(userApiGetAll + "/" + id)
            .then(res => {
                const usersRes = res.data;
                return usersRes;
            })
    }

    function getUsers() {
        return axios.get(userApiGetAll)
            .then(res => {
                const usersRes = res.data;
                return usersRes;
            })
    }

    return {
        'getUserDetails': getUserDetails,
        'getUsers': getUsers
    }
}
export default UserService