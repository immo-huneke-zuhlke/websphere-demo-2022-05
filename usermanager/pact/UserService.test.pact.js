import * as Pact from '@pact-foundation/pact';
import UserService from "../src/UserService";
const hostUrl = require('./jest.config.js').testURL;

describe('UserService API', () => {
    const userService = new UserService(hostUrl+"/restdemo");

    describe('getUsers()', () => {

        beforeEach((done) => {
            const contentTypeJsonMatcher = Pact.Matchers.term({
                matcher: "application\\/json; *charset=utf-8",
                generate: "application/json; charset=utf-8"
            });

            global.provider.addInteraction({
                state: 'provider allows list of users',
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
                        'Content-Type': contentTypeJsonMatcher
                    },
                    body: Pact.Matchers.somethingLike(
                        [{"email":"gpotawad@gmail.com","id":1,"name":"Gayatri"},{"id":2,"name":"Immo"}]
                    )
                }
            }).then(() => done());

        });

        it('sends a request according to contract', (done) => {
            userService.getUsers()
                .then(response => {
                    expect(response.length).toBeGreaterThanOrEqual(2);
                })
                .then(() => {
                    global.provider.verify()
                        .then(() => done(), error => {
                            done.fail(error)
                        })
                });
        });

    });

});