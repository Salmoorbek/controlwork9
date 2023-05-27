<!DOCTYPE html>
<html>
<head>
    <title>Подробности задачи</title>
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
<form action="/tasks/${task.id}/status" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <select name="status" required>
        <option value="TODO">TODO</option>
        <option value="IN_PROGRESS">IN_PROGRESS</option>
        <option value="COMPLETED">COMPLETED</option>
    </select>
    <button type="submit">Изменить статус</button>
</form>

<h2>Добавить отчет о работе:</h2>
<form action="/tasks/${task.id}/worklogs" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
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

</body>
</html>
