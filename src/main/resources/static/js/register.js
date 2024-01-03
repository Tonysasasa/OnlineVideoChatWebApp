function handlerRegister(event) {
    event.preventDefault();

    // Get user input
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const username = document.getElementById("username").value;
    const question = document.getElementById("question").value;

    const user = {
        email: email,
        password: password,
        username: username,
        question: question
    };

    function sendRequest(url, method, body) {
        fetch(url, {
            method: method,
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(body),
        }).then(response => {
            if (!response.ok) {
                alert('Email has been registered.');
            }
            return response.json();
        }).then(() => {
            localStorage.setItem('connectedUser', JSON.stringify(user));
            window.location.href = 'index.html'
        }).catch(error => {
            console.error('POST request error', error);
        });

    };
    sendRequest('http://localhost:8080/api/v1/users/register', 'POST', user);
}

const loginForm = document.getElementById("registration");
loginForm.addEventListener("submit", handlerRegister);