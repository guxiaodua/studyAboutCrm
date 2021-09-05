<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/12
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>

        <%--
            aname = "1"
            clueId = "5b655feeb29d4eb4b6cb823213cc920f"
        --%>

    $.ajax({
    
        url : "",
        data : {

        },
        type : "",
        dataType : "json",
        success : function (data) {

        }
    })
    //创建时间,当前系统时间
    String createTime = DateTimeUtil.getSysTime();
    //创建人,当前登录用户
    String createBy = ((User)request.getSession().getAttribute("user")).getName();

    $(".time").datetimepicker({
    minView: "month",
    language:  'zh-CN',
    format: 'yyyy-mm-dd',
    autoclose: true,
    todayBtn: true,
    pickerPosition: "bottom-left"
    });


</body>
</html>
