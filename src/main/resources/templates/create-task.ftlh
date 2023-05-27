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
        <label for="title">Название:</label>
        <input type="text" id="title" name="title" required>
    </div>

    <div>
        <label for="status">Статус:</label>
        <select id="status" name="status" required>
            <option value="CREATED">CREATED</option>
            <option value="IN_PROGRESS">IN_PROGRESS</option>
            <option value="COMPLETED">COMPLETED</option>
        </select>
    </div>

    <div>
        <label for="developerId">Разработчик:</label>
        <select id="developerId" name="developerId" required>
            <#if developers??>
                <#list developers as developer>
                    <option value="${developer.id}">${developer.name}</option>
                </#list>
            </#if>
        </select>
    </div>

    <button type="submit">Создать</button>
</form>

</body>
</html>
