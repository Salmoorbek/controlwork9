<!DOCTYPE html>
<html>
<head>
    <title>Страница регистрации</title>
</head>
<body>
<h1>Страница регистрации</h1>

<form method="POST" action="/registration">
    <input type="hidden" name="_csrf.token" value="${_csrf.token}" />
    <input type="text" name="name" placeholder="Имя" required /><br>
    <input type="email" name="email" placeholder="Email" required /><br>
    <input type="password" name="password" placeholder="Пароль" required /><br>
    <button type="submit">Зарегистрироваться</button>
</form>

<p>Уже есть аккаунт? <a href="/login">Войти</a></p>
</body>
</html>
