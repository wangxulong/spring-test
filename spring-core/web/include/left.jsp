<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%@include file="common.jsp"%>
</head>
<body>
<div id="sidebar" class="sidebar  responsive">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <!-- #section:basics/sidebar.layout.shortcuts -->
            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>

            <!-- /section:basics/sidebar.layout.shortcuts -->
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li class="">
            <a href="${ctx}/sys/user/index">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> 首页面 </span>
            </a>

            <b class="arrow"></b>
        </li>

        <li class="active">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								系统管理
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">


                <li class="">
                    <a href="${ctx}/sys/user/index">
                        <i class="menu-icon fa fa-caret-right"></i>
                         系统用户
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href="${ctx}/sys/role/index">
                        <i class="menu-icon fa fa-caret-right"></i>
                        系统角色
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="active">
                    <a href="${ctx}/sys/res/index">
                        <i class="menu-icon fa fa-caret-right"></i>
                        系统资源
                    </a>

                    <b class="arrow"></b>
                </li>



            </ul>
        </li>


    </ul><!-- /.nav-list -->

    <!-- #section:basics/sidebar.layout.minimize -->
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <!-- /section:basics/sidebar.layout.minimize -->
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
    </script>
</div>
</body>
</html>
