<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询所有学生</title>
</head>
<body>
    <table align="center" border="1px">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>信息</th>
        </tr>

        <c:if test="${not empty pageInfo.list}">
            <c:forEach var="student" items="${pageInfo.list}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.gender}</td>
                    <td>${student.info}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <form action="page" method="get">
        <table align="center">
            <tr>
                <td>
                    <c:if test="${pageInfo.pageNo == 1}">
                        <a style="color: red">首页</a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo != 1}">
                        <a href="page?pageNo=1">首页</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${pageInfo.pageNo == 1}">
                        <a style="color: red">上一页</a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo != 1}">
                        <a href="page?pageNo=${pageInfo.pageNo - 1}">上一页</a>
                    </c:if>
                </td>
                <c:forEach var="pageNo" step="1" begin="1" end="${pageInfo.pageCount}">
                    <td>
                        <c:if test="${pageNo == pageInfo.pageNo}">
                            <input disabled type="submit" value="${pageNo}">
                        </c:if>

                        <c:if test="${pageNo != pageInfo.pageNo}">
                            <input type="submit" name="pageNo" value="${pageNo}">
                        </c:if>

                    </td>
                </c:forEach>
                <td>
                    <c:if test="${pageInfo.pageNo == pageInfo.pageCount}">
                        <a style="color: red">下一页</a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo != pageInfo.pageCount}">
                        <a href="page?pageNo=${pageInfo.pageNo + 1}">下一页</a>
                    </c:if>
                </td>
                <td>
                    <c:if test="${pageInfo.pageNo == pageInfo.pageCount}">
                        <a style="color: red">尾页</a>
                    </c:if>

                    <c:if test="${pageInfo.pageNo != pageInfo.pageCount}">
                        <a href="page?pageNo=${pageInfo.pageCount}">尾页</a>
                    </c:if>
                </td>
                <td>共${pageInfo.totalCount}条内容</td>
                <td>共${pageInfo.pageCount}页</td>
            </tr>
        </table>
    </form>
</body>
</html>
