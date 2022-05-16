import * as Pact from '@pact-foundation/pact';
import UserService from "../src/UserService";

const hostUrl = require('./jest.config.js').testURL;

describe('UserService API', () => {
    const userService = new UserService(hostUrl + "/restdemo");
    const contentTypeJsonMatcher = Pact.Matchers.term({
        generate: "application/json",
        matcher:  "application/json",
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
                status: 202,
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
                status: 202,
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
                    expect(response.name).toEqual("Gayatri");
                })
                .then(done)
                .catch(done);
        });
    });
});
