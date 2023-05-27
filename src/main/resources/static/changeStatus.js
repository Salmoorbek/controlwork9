function addWorklog(taskId) {
    var time = $("#time").val();
    var description = $("#description").val();
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");

    $.ajax({
        url: "/tasks/" + taskId + "/worklogs",
        type: "POST",
        data: { time: time, description: description },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
        },
        success: function(response) {

        },
        error: function(xhr, status, error) {

        }
    });
}

function changeTaskStatus(taskId) {
    var status = $("#status").val();
    var csrfToken = $("meta[name='_csrf']").attr("content");
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");

    $.ajax({
        url: "/tasks/" + taskId + "/status",
        type: "POST",
        data: { status: status },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
        },
        success: function(response) {

        },
        error: function(xhr, status, error) {

        }
    });
}

$("#addWorklogForm").submit(function(event) {
    event.preventDefault();
    var taskId = $("#taskId").val();
    addWorklog(taskId);
});

$("#changeStatusForm").submit(function(event) {
    event.preventDefault();
    var taskId = $("#taskId").val();
    changeTaskStatus(taskId);
});
