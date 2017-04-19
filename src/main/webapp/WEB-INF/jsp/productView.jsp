<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
                <!DOCTYPE html>
                <html lang="en">

                <head>

                    <meta charset="utf-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <meta name="description" content="">
                    <meta name="author" content="">

                    <title>Product Form</title>

                    <!-- Bootstrap Core CSS -->
                    <link href="resources/lib/bootstrap/bootstrap.css" rel="stylesheet">
                    <link href="resources/lib/jquery-ui/jquery-ui.min.css" rel="stylesheet">
                    <!-- Custom CSS -->
                    <style>
                    body {
                        padding-top: 70px;
                        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
                    }
                    </style>

                    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
                    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
                    <!--[if lt IE 9]>
                        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
                        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
                    <![endif]-->

                </head>

                <body>

                    <!-- Navigation -->
                    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                        <div class="container">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
                            </div>
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/about">About</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/services">Services</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/contact">Contact</a>
                                    </li>
                                </ul>
                            </div>
                            <!-- /.navbar-collapse -->
                        </div>
                        <!-- /.container -->
                    </nav>

                    <!-- Page Content -->
                    <div class="container">

                            <div class="col-md-8 ">

                                <form:form method="POST" action="${pageContext.request.contextPath}/productlist/addproduct"
                                    commandName="prdt" enctype="multipart/form-data">
                                    <table class="table table-hover">
                                        <tr>
                                            <td>
                                                <form:label path="product_Name"> Enter Product Name</form:label>
                                            </td>
                                            <td>
                                                <form:input type="text" path="product_Name" class="form-control" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="descripction"> Enter Product Descripction</form:label>
                                            </td>
                                            <td>
                                                <form:input type="text" path="descripction" class="form-control" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="category"> Enter Product Category</form:label>
                                            </td>
                                            <td>
                                                <form:select path="category">
                                                    <c:forEach var="x" items="${catg}">
                                                        <form:option value="${x.category_id}" label="${x.category_name}" />
                                                    </c:forEach>
                                                </form:select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="price"> Enter Product Price</form:label>
                                            </td>
                                            <td>
                                                <form:input type="text" path="price" placeholder=" Enter Product Price" class="form-control" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="mfg_Date"> Enter Manufacture Date</form:label>
                                            </td>
                                            <td>
                                                <form:input path="mfg_Date"  maxlength="10" size="10"  cssClass="form-control installDatePicker"/>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td>
                                                <label> Choose Image</label>
                                            </td>
                                            <td>
                                                <form:input type="file" path="image" class="form-control" />
                                            </td>
                                        </tr>

                                    </table>
                                    <input type="submit" class="btn btn-primary" value="Submit" class="form-control" />
                                    <input type="button" id="addBtn" class="btn btn-secondary" value="Add" class="form-control" />
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <script src="resources/lib/jquery/jquery.min.js"></script>
                    <script src="resources/lib/jquery-ui/jquery-ui.min.js"></script>
                    <script src="resources/js/index.js"></script>
                    <script>
                        $(function () {
                            $(".installDatePicker").datepicker();
                        });
                    </script>
                </body>

                </html>