<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>密码确认</title>
</head>
<body>
    <div class="container-fluid">
        <form class="form-horizontal" method="post" action="/auth/checkPassword">
            <fieldset>
                <legend>
                    请输入您的密码
                </legend>
                <c:if test="${not empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}">
                    <div class="alert">
                        <button type="button" class="close" data-dismiss="alert">
                            &times;
                        </button>
                            ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
                    </div>
                </c:if>
                <div class="control-group">
                    <label class="control-label" for="password">
                        密码:
                    </label>

                    <div class="controls">
                        <input type="password" name="password" placeholder="请输入密码"/>
                        <button type="submit" class="btn btn-primary">
                            提交
                        </button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</body>