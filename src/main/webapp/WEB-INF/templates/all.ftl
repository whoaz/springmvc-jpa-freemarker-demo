<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Country</td>
    </tr>
    <#list cities.content as city>
        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
            <td>${city.countryCode}</td>
        </tr>
    </#list>

</table>

</body>
</html>