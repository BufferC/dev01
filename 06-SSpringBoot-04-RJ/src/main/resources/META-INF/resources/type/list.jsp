<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title">
            <span class="glyphicon glyphicon-list"></span>&nbsp;类型列表
            <span class="noteType_add">
			<button class="btn btn-sm btn-success" type="button" id="addBtn">添加类别</button>
		</span>

        </div>
        <div id="myDiv">
            <%-- 通过JSTl的if标签，判断类型集合是否存在 --%>
            <%--  如果不存在，则显示对应的提示信息（暂未查询到类型数据！） --%>
            <c:if test="${empty list}" >
                <h2>暂未查询到类型数据！</h2>
            </c:if>
            <c:if test="${!empty list}" >
            <%-- 如果存在，通过JSTL的forEach标签进行遍历 --%>
            <table id="myTable" class="table table-hover table-striped">
                <tbody>
                    <tr>
                        <th>编号</th>
                        <th>类型</th>
                        <th>操作</th>
                    </tr>
                    <%-- 遍历类型集合 --%>
                    <c:forEach items="${list}" var="item">
                        <tr id="tr_${item.id}">
                            <td>${item.id}</td>
                            <td>${item.typeName}</td>
                            <td>
                                <button class="btn btn-primary" type="button" onclick="openUpdateDialog(${item.id})">修改</button>&nbsp;
                                <button class="btn btn-danger del" type="button" onclick="deleteType(${item.id})">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </c:if>
        </div>
    </div>

    <%-- 添加/修改的模态框  --%>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="typeName">类型名称</label>
                        <input type="hidden" name="id" id="id">
                        <input type="text" name="typeName" class="form-control" id="typeName" placeholder="类型名称">
                    </div>
                </div>
                <div class="modal-footer">
                    <span id="msg" style="font-size: 12px;color: red"></span>

                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove"></span>关闭</button>
                    <button type="button" id="btn_submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-floppy-disk"></span>保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/statics/js/type.js"></script>
