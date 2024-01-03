const buttonclick = document.querySelector(".ButtonClick");

function display() {
    const content = document.querySelector(".Content");
    content.style.display = content.style.display === "flex" ? "none" : "flex";
    const Icon = document.getElementById("button0");
    Icon.src = Icon.src.includes('icon-plus') ? './images/icon-minus.svg' : './images/icon-plus.svg';
};

// For each buttonclick object, enable the even listener since they are defined as div class
buttonclick.addEventListener('click', display);



function chatDisplay() {
    const content1 = document.querySelector(".image-container");
    content1.style.display = content1.style.display === "none" ? "flex" : "none";
    const content2 = document.getElementById("chat-page");
    content2.style.display = content2.style.display === "flex" ? "none" : "flex";
};


const Btn = document.getElementById("newChatBtn");
Btn.addEventListener("click", chatDisplay);