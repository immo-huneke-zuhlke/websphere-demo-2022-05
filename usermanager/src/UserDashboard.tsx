import React, {useEffect, useState} from 'react';
import UserService from './UserService';

export default function UserDashboard() {
    const [users, setUsers] = useState<any[]>([])
    const [userDetails, setUserDetails] = useState({id: "", name: "", email: ""});
    const hostUrl = "http://localhost/restdemo";
    const userEndpoint = "api/user/";
    const userService = UserService(hostUrl);
    const userApiGetAll = hostUrl + userEndpoint;
    var loaded = false;
    useEffect(() => {
        if (!loaded) {
            userService.getUsers().then(setUsers);
            loaded = true;
        }
    }, []);

    const getUserDetails = (id: string) => {
        userService.getUserDetails(id).then(setUserDetails);
    }

    // @ts-ignore
    return (
        <>
            <h1>USER LIST</h1>
            <table id="users">
                <thead>
                <tr>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                {users.map(user => {
                    return <tr>
                        <td><a onClick={() => getUserDetails(user.id)} href="#"> {user.name}</a></td>
                    </tr>
                })}
                </tbody>
            </table>

            <hr/>
            <h1>User Details</h1>
            <table id="users">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>{userDetails.id}</td>
                    <td>{userDetails.name}</td>
                    <td>{userDetails.email}</td>
                </tr>
                </tbody>
            </table>
        </>

    );
}
