<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
<head>
    <title>Регистрация</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Регистрация</h1>
<form action="<@spring.url '/registration'/>" method="post">
    <div>
        <label for="username">Имя пользователя:</label>
        <input type="text" id="username" name="username"
               value="${(user.username)!''}" required/>
    </div>
    <div>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required/>
    </div>
    <button type="submit">Зарегистрироваться</button>
</form>

<#if RequestParameters.error??>
    <div style="color: red;">
        Пользователь с таким именем уже существует!
    </div>
</#if>
</body>
</html>