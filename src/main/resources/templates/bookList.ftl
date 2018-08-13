<!DOCTYPE html>
<html lang="en">
<body>
<#if bookList??>
    <#list bookList as book>
        序号：${book_index+1}<br>
        图书ID：${book.bookId}<br>
        图书名称：${book.bookName}<br><br>
    </#list>
<#else>
没有查到图书数据！
</#if>

</body>
</html>