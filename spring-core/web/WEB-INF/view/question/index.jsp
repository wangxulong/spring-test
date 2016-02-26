<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/include/common.jsp"%>
<html>
<head>

    <title></title>
</head>
<body>
<table id="sample-table-1" class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <th class="center">
            <label class="position-relative">
                <input type="checkbox" class="ace" />
                <span class="lbl"></span>
            </label>
        </th>
        <th>标题</th>
    </tr>
    </thead>

    <tbody>

        <c:forEach items="${questions}" var="question">
            <tr>
                <td class="center">
                    <label class="position-relative">
                        <input type="checkbox" class="ace" />
                        <span class="lbl"></span>
                    </label>
                </td>
                <td>
                    ${question.title}
                </td>

         </tr>
        </c:forEach>




    </tbody>

</table>
<script>
    $(function(){
        $(".addSysUser").on("click",function(){
            $("#modal-form .modal-content").load("${ctx}/sys/user/add",{},function(){
                $("#modal-form").modal("show");
            });
        });
        $(".addRole").on("click",function(){
            var userId = $(this).attr("data");
            $("#modal-form .modal-content").load("${ctx}/sys/user/addRole",{id:userId},function(){
                $("#modal-form").modal("show");
            });
        });

    });
</script>
</body>
</html>
