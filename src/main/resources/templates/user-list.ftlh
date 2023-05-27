<!DOCTYPE html>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<h1>Список пользователей</h1>

<table>
    <thead>
    <tr>
        <th>Имя</th>
        <th>Email</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>
                <a href="/users/${user.id}">Просмотреть</a>
            </td>
        </tr>
    </#list>
    </tbody>
</table>

</body>
</html>
