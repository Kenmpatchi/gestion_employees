

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <div style="display: flex">
        <form action="addTask" method="get">
          <table>
            <tr><td>
              put name of the task
            </td><td>
              <input type="text" name="name">
            </td></tr>
            <tr><td>
              put title of the task
            </td><td>
              <input type="text" name="title">
            </td></tr>
            <tr><td>
              put description:
            </td><td>
              <input type="text" name="description">
            </td></tr>
            <tr><td>
              put the content of the task :
            </td><td>
              <textarea name="main_content"></textarea>
            </td></tr>
            <tr><td rowspan="2">
              <input type="hidden" name="group_id" value=<%=request.getParameter("group_id")%>>
              <input type="submit" value="add">
            </td><</tr>
        </table>
      </form>
    </div>
  </body>
</html>
