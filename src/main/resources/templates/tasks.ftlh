<!DOCTYPE html>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<h1>Добро пожаловать на главную страницу! <span id="userEmail">${userEmail}</span></h1>

<p>Здесь вы можете найти информацию о задачах и другие детали.</p>

<h2>Список задач:</h2>

<form action="/tasks/filter" method="get">
    <label for="status">Filter by Status:</label>
    <select name="status" id="status">
        <option value="CREATED">Created</option>
        <option value="IN_PROGRESS">In Progress</option>
        <option value="COMPLETED">Completed</option>
        <option value="FAILED">Failed</option>
    </select>
    <input type="submit" value="Filter">
</form>
<#if status?has_content>
    <a href="/tasks">Вернуть все таски</a>
</#if>
<table>
    <thead>
    <tr>
        <th>Название</th>
        <th>Статус</th>
        <th>Действия</th>
        <th>Дата</th>
    </tr>
    </thead>
    <tbody>
    <#list tasks.content as task>
        <tr>
            <td>${task.title}</td>
            <td>${task.status}</td>
            <td>
                <a href="/tasks/${task.id}">Просмотреть</a>
            </td>
            <td>${task.creationDate}</td>
        </tr>
    </#list>
    </tbody>
</table>

<div class="pagination">
    <div>
        <#if tasks.hasPrevious()>
            <#assign previousPageable = tasks.previousPageable()>
            <a href="?page=${previousPageable.pageNumber}&size=${previousPageable.pageSize}&status=${status!}">Previous</a>
        </#if>

        <#if tasks.hasNext()>
            <#assign nextPageable = tasks.nextPageable()>
            <a href="?page=${nextPageable.pageNumber}&size=${nextPageable.pageSize}&status=${status!}">Next</a>
        </#if>
    </div>
</div>

<h2><a href="/tasks/create">Добавить задачу</a></h2>

<p>Выйти из аккаунта: <a href="/logout">Выйти</a></p>
</body>
</html>
