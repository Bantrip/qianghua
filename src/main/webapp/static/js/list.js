define(function(require, exports) {

    var opeUrl = {
            del: '/ajax/deleteItem',
            audit: '/ajax/auditItem',
            reject: '/ajax/rejectItem'
        },

        ope = function(id, type) {
            $.ajax({
                    url: opeUrl[type],
                    data: {
                        id: id
                    },
                    success: function(r) {
                        if(r.code == 200) {
                            alert('操作成功！');
                            window.location.reload();
                        } else {
                            alert(r.msg);
                        }
                    }
                });
        },

        initList = function() {
        $('.J_list').on('click', '.J_ope', function() {

            var self = $(this),
                type = self.attr('data-type'),
                id = self.parents('tr').find('.id').text();

            if(type == 'del') {
                if(confirm('确认删除该产品？')) {
                    ope(id, type);
                } else {
                    return;
                }    
            } else {
                ope(id, type);
            }
            

        });
    };

    initList();  
});