<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
 <%
 Date d = new Date();
 long val = d.getTime();
 %>

    <link href="https://fonts.googleapis.com/earlyaccess/hannari.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css?date='<%= val %>'">
	<link rel="stylesheet" href="css/menu-nav.css?date='<%= val %>'">