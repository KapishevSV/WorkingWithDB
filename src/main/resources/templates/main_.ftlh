<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Поиск по имени</div>
        <form method="get" action="main_">
            <input type="text" name="name" value=${name}>
            <button type="submit">Найти</button>
        </form>
    <br>
    <div>Поиск по серийному номеру</div>
        <form method="get" action="main">
            <input type="text" name="sn" value="">
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
        No message
    </#list>
</@c.page>