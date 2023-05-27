<!DOCTYPE html>
<html>
<head>
    <title>Создание пользователя</title>
</head>
<body>
<h1>Создание пользователя</h1>

<form action="/users/create" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">

    <div>
        <label for="name">Имя:</label>
        <input type="text" id="name" name="name" required>
    </div>

    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>

    <div>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required autocomplete="current-password">
    </div>

    <button type="submit">Создать</button>
</form>

</body>
</html>
