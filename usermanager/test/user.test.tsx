/*const { pactWith } = require("jest-pact")
const { Matchers } = require("@pact-foundation/pact")

pactWith(
    { consumer: "User Jest Consumer Example", provider: "User Jest Provider Example" },
    provider => {
        describe("User list API", () => {
            const USERS_DATA = [
                {
                },
            ]

            const usersSuccessResponse = {
                status: 200,
                headers: {
                    "Content-Type": "application/json",
                },
                body: USERS_DATA,
            }

            const usersListRequest = {
                uponReceiving: "a request for users",
                withRequest: {
                    method: "GET",
                    path: "/api/user",
                    headers: {
                        Accept: "application/json",
                    },
                },
            }

            beforeEach(() => {
                const interaction = {
                    state: "i have a list of users",
                    ...usersListRequest,
                    willRespondWith: usersSuccessResponse,
                }
                return provider.addInteraction(interaction)
            })

            // add expectations
            it("returns a successful body", () => {
                return getUsers({
                    url: provider.mockService.baseUrl,
                }).then(users => {
                    expect(users).toEqual(USERS_DATA)
                })
            })
        })
//___________________________________________________________________
        describe("User details API", () => {
            const USER_DATA = {}

            const userSuccessResponse = {
                status: 200,
                headers: {
                    "Content-Type": "application/json",
                },
                body: USER_DATA,
            }

            const userDetailRequest = {
                uponReceiving: "a request for cats with given catId",
                withRequest: {
                    method: "GET",
                    path: "/api/user/1",
                    query: {
                        "id[]": Matchers.eachLike("1"),
                    },
                    headers: {
                        Accept: "application/json",
                    },
                },
            }

            beforeEach(() => {
                return provider.addInteraction({
                    state: "i have user details",
                    ...userDetailRequest,
                    willRespondWith: userSuccessResponse,
                })
            })

            it("returns a successful body", () => {
                return getUSER({
                    url: provider.mockService.baseUrl,
                }).then(user => {
                    expect(user).toEqual(USER_DATA)
                })
            })
        })
    }
)
*/