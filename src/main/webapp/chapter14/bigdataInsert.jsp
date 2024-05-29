<%--
  Created by IntelliJ IDEA.
  User: TTakahashi
  Date: 2024/05/08
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<p>bigdataテーブルに30億件のデータをインサートします。
インサートに使用する方法を複数用意しました。</p>

<table>
    <thead>
    <tr>
        <th>No.</th>
        <th>処理内容</th>
        <th>自動コミット有無</th>
        <th>JDBC更新API</th>
        <th>実行開始</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>1</th>
        <td>1件毎にinsert実行</td>
        <td>あり</td>
        <td>executeUpdate</td>
        <td>
            <form action="bigdatainsert" method="post">
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    <tr>
        <th>2</th>
        <td>1件毎にinsert実行</td>
        <td>なし</td>
        <td>executeUpdate</td>
        <td>
            <form action="bigdatainsert2" method="post">
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    <tr>
        <th>3</th>
        <td>複数件のinsertをバッチ実行</td>
        <td>あり</td>
        <td>executeBatch</td>
        <td>
            <form action="bigdatainsert3" method="post">
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    <tr>
        <th>4</th>
        <td>複数件のinsertをバッチ実行</td>
        <td>なし</td>
        <td>executeBatch</td>
        <td>
            <form action="bigdatainsert4" method="post">
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    <tr>
        <th>5</th>
        <td>指定した行数を1つのinsert文で実行</td>
        <td>あり</td>
        <td>executeUpdate</td>
        <td>
            <form action="bigdatainsert5" method="post">
                <p>1回のinsertあたりの行数:<input type="text" name="rows"></p>
                <input type="hidden" name="autocommit" value="true">
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    <tr>
        <th>6</th>
        <td>指定した行数を1つのinsert文で実行</td>
        <td>なし</td>
        <td>executeUpdate</td>
        <td>
            <form action="bigdatainsert5" method="post">
                <p>1回のinsertあたりの行数:<input type="text" name="rows"></p>
                <input type="hidden" name="autocommit" value="false">
                <input type="submit" value="実行">
            </form>
        </td>
    </tr>
    </tbody>
</table>
<p>



<%@ include file="../footer.html" %>
