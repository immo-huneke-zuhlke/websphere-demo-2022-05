import React, {useEffect, useState} from 'react';
import axios from 'axios';

export default function UserDashboard() {
    const [users, setUsers] = useState<any[]>([])
    const [userDetails, setUserDetails] = useState({id: "", name: "", email: ""});
    const hostUrl = "http://localhost/restdemo/";
    const userEndpoint = "api/user/";
    const userApiGetAll = hostUrl + userEndpoint;
    var loaded = false;
    useEffect(() => {
        if (!loaded) {
            axios.get(userApiGetAll)
                .then(res => {
                    const usersRes = res.data;
                    setUsers(usersRes);
                })
            loaded = true;
        }
    }, []);

    const getUserDetails = (id: string) => {
        axios.get(userApiGetAll + "/" + id)
            .then(res => {
                const usersRes = res.data;
                setUserDetails(usersRes);
            })
    }
    // @ts-ignore
    // @ts-ignore
    // @ts-ignore
    // @ts-ignore
    return (
        <>
            <h1>USER LIST</h1>
            <table id="users">
                <tr>
                    <th>Name</th>
                </tr>
                {users.map(user => {
                    return <tr>
                        <td><a onClick={() => getUserDetails(user.id)} href="#"> {user.name}</a></td>
                    </tr>
                })}

            </table>

            <hr/>
            <h1>User Details</h1>
            <table id="users">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
                <tr>
                    <td>{userDetails.id}</td>
                    <td>{userDetails.name}</td>
                    <td>{userDetails.email}</td>
                </tr>
            </table>
        </>

    );
}
