<%-- 
    Document   : dsdondathang
    Created on : Jun 21, 2017, 9:54:24 PM
    Author     : Asus
--%>

<%@page import="paingainshop.model.DAO.NhanVienDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paingainshop.model.DonDatHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
         <h1>
            <a href="${pageContext.request.contextPath}/index">Home</a>
            <small>Quản lí hàng hóa</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>Quản lí hàng hóa</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/donhang/danhsach">Danh sách đơn hàng</a></li>
        </ol>
    </section>
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-md-10">
                <div class="box box-primary">

                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Mã Đơn đặt hàng</th>
                                    <th>Nhân viên lập</th>
                                    <th>Ngày lập</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    ArrayList<DonDatHang> list = (ArrayList<DonDatHang>) request.getAttribute("rs");
                                    for (DonDatHang dh : list) {
                                %>
                                <tr>
                                    <td><%=dh.getMaDDH()%></td>
                                    <td><%= new NhanVienDAO().getUserByID(dh.getMaNV()).getHoTen()%></td>
                                    <td><%=dh.getNgay()%></td>
                            
                                <% if (dh.getTrangThai() == 0) {
                                        out.print("<td><a href=\"/donhang/chitiet?madh="+ dh.getMaDDH() +"\">Chưa cập nhật</a></td>");
                                    } else {
                                        out.print("<td><a href=\"/donhang/chitiet?madh="+ dh.getMaDDH() +"\">Đã cập nhật</a></td>");
                                }%>
                            
                            </tr>
                            <%}%>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Mã Đơn đặt hàng</th>
                                    <th>Nhân viên lập</th>
                                    <th>Ngày lập</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
            </div>
            <div class="col-md-2">
                <a href="${pageContext.request.contextPath}/donhang/new"> <button type="button" class="btn btn-primary" > Tạo đơn đặt hàng</button></a>

            </div>
        </div>
    </section>
</div>
<%@include file="frame/footer.jsp"%>
