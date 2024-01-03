function loadAndDisplayUsers() {

    // check if the user is connected
    const currentUser = localStorage.getItem('currentUser');

    if (!currentUser) {
        window.location = 'login.html';
        return;
    }

    const userListElement = document.getElementById("userList");

    // Clear any existing content in the userListElement
    userListElement.innerHTML = "Loading...";
    // Retrieve the userList from Local Storage
    fetch('http://localhost:8080/api/v1/users')
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            displayUsers(data, userListElement, currentUser);
        });
}


function displayUsers(userList, userListElement, currentUser) {
    userListElement.innerHTML = "";

    // Loop through the userList and create list items to display each user
    userList.forEach(user => {
        if (user.status == "online") {
            var icon = "fa fa-check-square"
        } else {
            var icon = "fa fa-close"
        }

        const listItem = document.createElement("li");

        if (currentUser.includes(user.email)) {
            listItem.innerHTML = `
                <div>
                    <i class="fa fa-child"></i>
                    ${user.username} <i class="user-email">(${user.email})</i>
                </div>
                <i class="${icon} ${user.status}"></i>
            `;
        } else {
            listItem.innerHTML = `
                <div>
                <i class = "break"></i>
                    ${user.username} <i class="user-email">(${user.email})</i>
                </div>
                <i class="${icon} ${user.status}"></i>
            `;
        };

        userListElement.appendChild(listItem);
    });
}

// Call the loadAndDisplayUsers function when the page loads
window.addEventListener("load", loadAndDisplayUsers);



function handleLogout() {
    fetch('http://localhost:8080/api/v1/users/logout', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: localStorage.getItem('currentUser')
    })
        .then((response) => {
            return response;
        })
        .then((data) => {
            localStorage.removeItem('currentUser');
            window.location.href = "login.html";
        });
}

const logoutBtn = document.getElementById("logoutBtn");
logoutBtn.addEventListener("click", handleLogout);

function handleNewChat() {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    window.open(`chat.html?username=${currentUser.username}`, "_blank");
}

function handleNewMeeting() {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    //window.open(`videopage.html?username=${currentUser.username}`, "_blank");
    //window.open(`videopage.html`, "_blank");
    window.open("http://localhost:3000", "_blank")
}

// Attach the handleNewMeeting function to the "Create a New Meeting" button
const newMeetingBtn = document.getElementById("newMeetingBtn");
newMeetingBtn.addEventListener("click", handleNewMeeting);


function handleJoinMeeting() {
    const roomId = document.getElementById("meetingName").value;
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));

    const url = `videopage.html?roomID=${roomId}&username=${currentUser.username}`;

    window.open(url, "_blank");
}

//const joinChatBtn = document.getElementById("joinChatBtn");
//joinChatBtn.addEventListener("click", handleNewChat);

const joinMeetingBtn = document.getElementById("joinMeetingBtn");
joinMeetingBtn.addEventListener("click", handleJoinMeeting);
