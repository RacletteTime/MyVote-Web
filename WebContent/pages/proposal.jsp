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
    <h2>${proposal.libelle}</h2>
    <h4>${proposal.type} - ${proposal.state}</h4>

    <c:if test="${proposal.isOnGoing()}">
        <s:form action="vote">
            <input type="hidden" name="proposal" value="${proposal.id}"/>
            <c:forEach items="${proposal.choices}" var="choice">
                <div class="form-group">
                    <input type="radio" name="choice" value="${choice.id}"> ${choice.libelle} </input>
                </div>
            </c:forEach>
            <s:submit/>
        </s:form>
    </c:if>
    <c:if test="${proposal.isEnded()}">
        <c:forEach items="${proposal.choices}" var="choice">
            <a class="list-group-item">
                <h4 class="list-group-item-heading">${choice.libelle} - ${choice.percentage}</h4>
            </a>
        </c:forEach>
    </c:if>
</div>
</body>
</html>