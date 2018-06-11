$(function () {
    // $('#tree').tree({
    //     // url: 'tree/list?uuid=0',
    //     animate: true,
    //     checkbox: true
    // });

    $("#grid").datagrid({
        url: 'emp/list',
        columns: [[
            /* {field: "", checkbox: true},  //复选框*/
            {field: 'uuid', title: '编号', width: 100},
            {field: 'name', title: '名称', width: 100}
        ]],
        singleSelect: true,
        onClickRow: function (rowIndex, rowData) {
            $('#tree').tree({
                url: 'empTree/list?uuid=' + rowData.uuid,
                animate: true,
                checkbox: true
            });
        }
    });


    // 更新用户角色信息
    $("#btnSave").bind('click', function () {
        // alert(JSON.stringify($("#tree").tree('getChecked')));
        var nodes = $("#tree").tree('getChecked');
        var ids = new Array();
        $.each(nodes, function (i, node) {
            ids.push(node.id);
        });
        //数组用 , 分割
        var checkedStr = ids.join(',');
        // alert(checkedStr);
        $.ajax({
            url: 'empTree/update',
            data: {
                uuid: $("#grid").datagrid('getSelected').uuid,
                checkedStr: checkedStr
            },
            success: function (rtn) {
                $.messager.alert("提示:", rtn.message, 'info');
                $("#grid").datagrid("reload");
            }


        });
    })
});