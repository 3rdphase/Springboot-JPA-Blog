<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>

<div class="container-fluid mt-3">

<form action="/action_page.php">
  <div class="mb-3 mt-3">
    <label for="username" class="form-label">UserName:</label>
    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
  </div>
    <div class="mb-3">
    <label for="password" class="form-label">Password:</label>
    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
  </div>

  <div class="form-check mb-3">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox" name="remember"> Remember me
    </label>
  </div>
</form>

<button id="btn-login" class="btn btn-primary">로그인</button>

</div>

<script src="/blog/js/user.js"></script>
<%@include file="../layout/footer.jsp" %>