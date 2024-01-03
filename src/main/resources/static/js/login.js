function handleLogin(event) {
    event.preventDefault();

    // Get user input
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const user = {
        email: email,
        password: password
    };

    function sendRequest(url, method, body) {
        fetch(url, {
            method: method,
            headers: { 'content-type': 'application/json' },
            body: JSON.stringify(body),
        }).then(response => {
            if (!response.ok) {
                alert('Email and / or password is incorrect');
            }
            return response.json();
        }).then((response) => {
            localStorage.setItem('currentUser', JSON.stringify(response));
            window.location.href = 'index.html'
        }).catch(error => {
            console.error('POST request error', error);
        });

    };
    sendRequest('http://localhost:8080/api/v1/users/login', 'POST', user);
}


const loginForm = document.getElementById("login");
loginForm.addEventListener("submit", handleLogin);

