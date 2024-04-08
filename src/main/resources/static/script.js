function editTask(taskId) {
    let editButton = document.querySelector('#edit_' + taskId);
    let descriptionText = document.getElementById('descriptionText_' + taskId);
    let descriptionInput = document.getElementById('descriptionInput_' + taskId);
    let statusText = document.getElementById('statusText_' + taskId);
    let statusSelect = document.getElementById('status_' + taskId);

    descriptionText.style.display = 'none';
    descriptionInput.style.display = 'block';
    statusText.style.display = 'none';
    statusSelect.style.display = 'block';

    editButton.innerHTML = 'Save';
    editButton.onclick = function () {
        saveTask(taskId);
    };
}

function saveTask(taskId) {
    let description = document.getElementById('descriptionInput_' + taskId).value;
    let status = document.getElementById('status_' + taskId).value;

    updateTask(taskId, description, status);
    document.querySelector('#description_' + taskId).disabled = true;
    document.querySelector('#status_' + taskId).disabled = true;

    let editButton = document.querySelector('#edit_' + taskId);
    editButton.innerHTML = 'Edit';
    editButton.onclick = function () {
        editTask(taskId);
    };
}

function updateTask(taskId, description, status) {
    let xhr = new XMLHttpRequest();
    xhr.open("PUT", taskId);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.send(JSON.stringify({"description": description, "status": status}));

    xhr.onload = function () {
        if (xhr.status === 200) {
            window.location.reload();
        } else {
            console.error("Помилка оновлення завдання:", xhr.responseText);
        }
    };
}

function deleteTask(taskId) {
    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", "/" + taskId);
    xhr.send();

    xhr.onload = function () {
        if (xhr.status === 200) {
            window.location.reload();
        } else {
            console.error("Помилка видалення завдання:", xhr.responseText);
        }
    };
}

let modal = document.getElementById("taskModal");
let span = document.getElementsByClassName("close")[0];

function openModal(taskDetails) {
    let taskDetailsDiv = document.getElementById("taskDetails");
    taskDetailsDiv.innerHTML = taskDetails;
    modal.style.display = "block";
}

function searchTasks(taskId) {
    fetch('/search?id=' + taskId)
        .then(response => response.json())
        .then(data => {
            let resultString = `
                <div class="task-details-container">
                    <h3 class="task-details-header">Task Details</h3>
                    <div class="task-details">
                        <p><span class="details-label">ID:</span> ${data.id}</p>
                        <p><span class="details-label">Description:</span> ${data.description}</p>
                        <p><span class="details-label">Status:</span> ${data.status}</p>
                    </div>
                </div>`;
            openModal(resultString);
        })
        .catch(error => console.error('Error:', error));
}

span.onclick = function () {
    modal.style.display = "none";
    window.location.reload();
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
        window.location.reload();
    }
}

let searchForm = document.getElementById('searchForm');
searchForm.addEventListener('submit', function (event) {
    event.preventDefault();
    let taskId = document.getElementById('taskId').value;
    searchTasks(taskId);
});
function toggleSearchButton() {
    var input = document.getElementById("taskId");
    var button = document.getElementById("searchButton");
    button.disabled = input.value === "";
}

