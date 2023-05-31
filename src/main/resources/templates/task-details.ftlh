<!DOCTYPE html>
<html>
<head>
    <title>Подробности задачи</title>
    <meta name="_csrf" content="${_csrf.token}" />
    <meta name="_csrf_header" content="${_csrf.headerName}" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>Подробности задачи</h1>

<h2>Задача:</h2>
<p>Название: ${task.title}</p>
<p>Статус: ${task.status}</p>

<h2>Список вложений:</h2>
<ul>
    <#list attachments as attachment>
        <li>${attachment.filename}</li>
    </#list>
</ul>

<h2>Список отчетов о работе:</h2>
<ul>
    <#list worklogs as worklog>
        <li>${worklog.timeSpent} - ${worklog.description}</li>
    </#list>
</ul>

<h2>Изменить статус задачи:</h2>
<form id="changeStatusForm">
    <input type="hidden" id="taskId" value="${task.id}">
    <div>
        <label for="status">Изменить статус:</label>
        <select id="status" name="status" required>
            <option value="CREATED">CREATED</option>
            <option value="IN_PROGRESS">IN_PROGRESS</option>
            <option value="COMPLETED">COMPLETED</option>
            <option value="FAILED">FAILED</option>
        </select>
    </div>
    <button type="submit">Изменить статус</button>
</form>

<h2>Добавить отчет о работе:</h2>
<form id="addWorklogForm">
    <input type="hidden" id="taskId" value="${task.id}">
    <div>
        <label for="time">Время:</label>
        <input type="text" id="time" name="time" required>
    </div>
    <div>
        <label for="description">Описание:</label>
        <textarea id="description" name="description" required></textarea>
    </div>
    <button type="submit">Добавить отчет</button>
</form>

<script src="/changeStatus.js"></script>
</body>
</html>
