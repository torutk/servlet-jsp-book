<%--
  Created by IntelliJ IDEA.
  User: TTakahashi
  Date: 2024/05/08
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../header.html" %>

<p>bigdataテーブルから検索します。</p>

<table>
    <thead>
    <tr>
        <th>No.</th>
        <th>処理内容</th>
        <th>実行開始</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>1</th>
        <td>レコード数を取得</td>
        <td>
            <form action="bigdataselect" method="get">
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    <tr>
        <th>2</th>
        <td>指定したidの行を表示</td>
        <td>
            <form action="bigdataselect2" method="post">
                <p>id<input type="text" name="id"></p>
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    <tr>
        <th>3</th>
        <td>指定した文字列を含む名前の行を表示</td>
        <td>
            <form action="bigdataselect3" method="post">
                <p>nameに含まれる文字列<input type="text" name="name"></p>
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    <tr>
        <th>4</th>
        <td>指定した文字列を含む名前の行を表示（非同期Servlet）</td>
        <td>
            <form action="bigdataselect4" method="post">
                <p>nameに含まれる文字列<input type="text" name="name"></p>
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    </tbody>
</table>
<p>



<%@ include file="../../footer.html" %>
