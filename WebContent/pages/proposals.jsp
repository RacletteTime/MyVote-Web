<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="common/head.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <h1>MyVote</h1>
    <div class="list-group">
    <c:forEach items="${onGoingProposals}" var="prop">
        <a href="proposal?id=${prop.id}" class="list-group-item">
            <h4 class="list-group-item-heading">${prop.libelle}</h4>
            <p class="list-group-item-text">
            <c:forEach items="${prop.choiceItems}" var="choice">
                <li>${choice.libelle}</li>
            </c:forEach>
            </p>
        </a>
    </c:forEach>
    </div>
    <br/>
    <div class="list-group">
        <c:forEach items="${endedProposals}" var="prop">
            <div class="list-group-item">
                <h4 class="list-group-item-heading">${prop.libelle}</h4>
                <p class="list-group-item-text">
                <c:forEach items="${prop.choiceItems}" var="choice">
                    <li>${choice.libelle} - ${choice.percentage}%</li>
                </c:forEach>
                </p>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>