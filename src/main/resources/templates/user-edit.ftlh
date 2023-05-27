<!DOCTYPE html>
<html>
<head>
    <title>Редактирование пользователя</title>
</head>
<body>
<h1>Редактирование пользователя</h1>

<form action="/users/${userDto.id}/edit" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">

    <div>
        <label for="name">Имя:</label>
        <input type="text" id="name" name="name" value="${userDto.name}" required>
    </div>

    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${userDto.email}" required>
    </div>

    <button type="submit">Сохранить</button>
</form>

</body>
</html>
