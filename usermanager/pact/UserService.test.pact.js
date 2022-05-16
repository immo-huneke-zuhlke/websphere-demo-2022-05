import * as Pact from '@pact-foundation/pact';
import UserService from "../src/UserService";

describe('UserService API', () => {
    const newUser = {"name": "maria", "email": "maria@gmail.com"};
    const savedUser = {"id": 3};
    Object.assign(savedUser, newUser);
    const hostUrl = require('./jest.config.js').testURL;
    const userService = new UserService(hostUrl + "/restdemo");
    const contentTypeJsonMatcher = Pact.Matchers.term({
        generate: "application/json",
        matcher: "application/json",
    });

    it('requests all users', (done) => {
        global.provider.addInteraction({
            state: 'database contains two users',
            uponReceiving: 'a GET request to list users',
            withRequest: {
                method: 'GET',
                path: '/restdemo/api/user',
                headers: {
                    Accept: 'application/json, text/plain, */*'
                }
            },
            willRespondWith: {
                status: 200,
                headers: {
                    "Content-Type": contentTypeJsonMatcher
                },
                body: Pact.Matchers.somethingLike(
                    [{"email": "gpotawad@gmail.com", "id": 1, "name": "Gayatri"}, {"id": 2, "name": "Immo"}]
                )
            }
        }).then(() => {
            userService.getUsers()
                .then(response => {
                    // eslint-disable-next-line jest/no-conditional-expect
                    expect(response.length).toBeGreaterThanOrEqual(2);
                })
                .then(done)
                .catch(done)
        });
    });

    it('requests an existing user', (done) => {
        global.provider.addInteraction({
            state: 'database contains two users',
            uponReceiving: 'a GET request to obtain user details',
            withRequest: {
                method: 'GET',
                path: '/restdemo/api/user/1',
                headers: {
                    Accept: 'application/json, text/plain, */*'
                }
            },
            willRespondWith: {
                status: 200,
                headers: {
                    "Content-Type": contentTypeJsonMatcher
                },
                body: Pact.Matchers.somethingLike(
                    {"email": "gpotawad@gmail.com", "id": 1, "name": "Gayatri"}
                )
            }
        }).then(() => {
            userService.getUserDetails("1")
                .then(response => {
                    // eslint-disable-next-line jest/no-conditional-expect
                    expect(response.name).toEqual("Gayatri");
                })
                .then(done)
                .catch(done);
        });
    });

    //_______________________ save user api ___________________
    it('saves a new user', (done) => {
        global.provider.addInteraction({
            state: 'database contains two users',
            uponReceiving: 'a POST request to save a new user',
            withRequest: {
                method: 'POST',
                path: '/restdemo/api/user',
                body: newUser,
                headers: {
                    Accept: 'application/json, text/plain, */*'
                }
            },
            willRespondWith: {
                status: 201,
                headers: {
                    "Content-Type": contentTypeJsonMatcher
                },
                body: Pact.Matchers.somethingLike(savedUser)
            }
        }).then(() => {
            userService.saveUser(newUser)
                .then(response => {
                    // eslint-disable-next-line jest/no-conditional-expect
                    expect(response.name).toEqual(newUser.name);
                    // eslint-disable-next-line jest/no-conditional-expect
                    expect(response.id).toBeGreaterThan(0);
                })
                .then(done)
                .catch(done);
        });
    });
});
