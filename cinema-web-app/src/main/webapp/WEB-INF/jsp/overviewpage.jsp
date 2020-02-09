<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <title>Films information page</title>
</head>
<body style="margin: 60px;">
<main role="main" class="container">
    <h5 style="margin: 0;">Films information:</h5>
    <table class="table table-bordered table-hover">
        <thead class="thead-light">
        <tr>
            <th scope="col">Film name</th>
            <th scope="col">Release date</th>
            <th scope="col">Genre</th>
            <th scope="col">Director's name</th>
            <th scope="col">Director's birthday</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="filmDto" items="${film_list}">
            <tr>
                <th scope="row">${filmDto.filmName}</th>
                <td>${filmDto.filmReleaseDate}</td>
                <td>${filmDto.filmGenre}</td>
                <td>${filmDto.directorFirstName} ${filmDto.directorLastName}</td>
                <td>${filmDto.directorBirthDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/cinema-information" class="btn btn-primary">Back to the
        form</a>
</main>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>