<!DOCTYPE html>
<html>
<head>
    <title>Создание задачи</title>
</head>
<body>
<h1>Создание задачи</h1>

<form action="/tasks/create" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">

    <div>
        <label for="name">Название:</label>
        <input type="text" id="name" name="name" required>
    </div>

    <div>
        <label for="status">Статус:</label>
        <select id="status" name="status" required>
            <option value="TODO">TODO</option>
            <option value="IN_PROGRESS">IN_PROGRESS</option>
            <option value="COMPLETED">COMPLETED</option>
        </select>
    </div>

    <div>
        <label for="developer">Разработчик:</label>
        <select id="developer" name="developer" required>
            <#list developers as developer>
                <option value="${developer.id}">${developer.name}</option>
            </#list>
        </select>
    </div>

    <button type="submit">Создать</button>
</form>

</body>
</html>
