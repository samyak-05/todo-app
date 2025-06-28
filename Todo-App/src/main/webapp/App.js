function deleteTodo(todoId) {
    if (!confirm("Are you sure you want to delete this todo?")) {
        return;
    }
    fetch("deleteTodo", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: "id=" + todoId
    })
    .then(response => {
        if (response.ok) {
            document.getElementById(`row-${todoId}`).remove();
        } else {
            alert("Error deleting todo.");
        }
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Something went wrong.");
    });
}
