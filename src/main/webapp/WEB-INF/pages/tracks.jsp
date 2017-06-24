<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Tracks Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg  {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Track List</h1>
<c:if test="${!empty listTracks}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Author</th>
            <th width="180">Play</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTracks}" var="track">
            <tr>
                <td>${track.id}</td>
                <td>${track.trackTitle}</td>
                <td>${track.trackAuthor}</td>
                <td> <audio src="/music/${track.play}" controls></audio>
                </td>
                <td><a href="<c:url value='/edit/${track.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${track.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Edit track</h1>

<c:url var="editAction" value="/tracks/edit"/>

<form:form action="${editAction}" commandName="track">
    <table>
        <c:if test="${!empty track.trackTitle}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="trackTitle">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="trackTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="trackAuthor">
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <form:input path="trackAuthor"/>
            </td>
        </tr>
        <c:if test="${!empty track.trackTitle}">
            <tr>
                <td>
                    <form:label path="play">
                        <spring:message text="Play Link"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="play" readonly="true" disabled="true"/>
                    <form:hidden path="play"/>
                </td>
            </tr>
        </c:if>
            <td colspan="1">
                <c:if test="${!empty track.trackTitle}">
                    <input type="submit"
                           value="<spring:message text="Edit Track"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
