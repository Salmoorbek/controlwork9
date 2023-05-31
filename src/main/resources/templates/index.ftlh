<!DOCTYPE html>
<html>
<head>
    <title>Task List</title>
</head>
<body>
<h1>Task List</h1>

<form action="/filter" method="get">
    <label for="status">Filter by Status:</label>
    <select name="status" id="status">
        <option value="CREATED">Created</option>
        <option value="IN_PROGRESS">In Progress</option>
        <option value="COMPLETED">Completed</option>
    </select>
    <input type="submit" value="Filter">
</form>

<#if tasks?has_content>
    <table>
        <thead>
        <tr>
            <th>Название</th>
            <th>Статус</th>
            <th>Разработчик</th>
        </tr>
        </thead>
        <tbody>
        <#list tasks.content as task>
            <tr>
                <td>${task.title}</td>
                <td>${task.status}</td>
                <td>${task.developer.name}</td>
            </tr>
        </#list>
        </tbody>
    </table>
<#else>
    <p>There are no tasks.</p>
</#if>

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
</body>
</html>