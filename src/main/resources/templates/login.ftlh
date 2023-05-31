<!DOCTYPE html>
<html>
<head>
    <title>Страница входа</title>
</head>
<body>
<h1>Страница входа</h1>

<form class="login-form" method="POST" action="/login">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="text" placeholder="email" name="username" value=""/>
    <input type="password" placeholder="password" name="password" value=""/>
    <button>login</button>
</form>
</body>
</html>