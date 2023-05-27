<!DOCTYPE html>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
<h1>Добро пожаловать на главную страницу!</h1>

<p>Здесь вы можете найти информацию о задачах и другие детали.</p>

<h2>Список задач:</h2>

<table>
    <thead>
    <tr>
        <th>Название</th>
        <th>Статус</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <#list tasks as task>
        <tr>
            <td>${task.title}</td>
            <td>${task.status}</td>
            <td>
                <a href="/task/${task.id}">Просмотреть</a>
            </td>
        </tr>
    </#list>
    </tbody>
</table>

<h2>Другие детали:</h2>

<p>Выйти из аккаунта: <a href="/logout">Выйти</a></p>
</body>
</html>
