<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Поиск счетчика</div><br>
        <form method="get" action="search_count">
            Номер: <input type="text" name="sn" value=${sn!""}>
            <br><br>
            Имя: <input type="text" name="name" value=${name!""}>
            <br><br>
            <button type="submit">Найти</button>
        </form>
    <br>
    <div>Список приборов учета</div>
    <#list snModels as model>
        <div>
            <b>${model.id}</b>
            <span>${model.sn}</span>
            <i>${model.name}</i>
        </div>
    <#else>
        Not found
    </#list>
    <br>
    <div>Добавление новой записи</div>
    <br>
    <div>
        <form method="post">
            Номер: <input type="text" name="addSn"/>
            <br><br>
            Имя: <input type="text" name="addName"/>
            <br><br>
            <button type="submit">Добавить</button>
        </form>
    </div>
</@c.page>