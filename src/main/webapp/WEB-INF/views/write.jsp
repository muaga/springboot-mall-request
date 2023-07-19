<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Mall</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">shop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">상품목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/write">상품등록</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-3">
    <form action="/product" method="post" enctype="application/x-www-form-urlencoded">
        <%--
        form : 안에 데이터를 한 방에 전송하는 것
        action : 데이터를 한 번에 전송(받는) 식별자
        method : 기능
        enctype : 인코딩 타입 : MIME타입으로!
        --%>
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" placeholder="Enter 상품명" value="바나나" name="name">
        </div>
        <div class="mb-3">
            <input type="text" class="form-control" placeholder="Enter 상품가격" value="1000" name="price">
        </div>
        <div class="mb-3">
            <input type="text" class="form-control" placeholder="Enter 상품재고" value="50" name="qty">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <%--        input를 하게 하는 장치--%>
    </form>
</div>

</body>
</html>