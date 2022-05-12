// ./pact/jest-wrapper.js
beforeAll((done) => {
    global.provider.setup().then(() => done());
});

afterEach((done) => {
    global.provider.verify().then(() => done());
});

afterAll((done) => {
    global.provider.finalize().then(() => done());
});



/*beforeAll(() => provider.setup()); // Create mock provider
afterEach(() => provider.verify()); // Ensure the mock provider verifies expected interactions for each test
afterAll(() => provider.finalize());*/