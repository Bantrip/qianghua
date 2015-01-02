define(function(require, exports) {

    // require('uploadify');

    var detail = $('.J_detail'),
        UPLOAD_IMG_ID = 'uploadDesImg',

        uploadItemTpl = function() {
            return '<div class="item">\
                        <img class="img" />\
                        <div class="status">上传成功<span class="glyphicon glyphicon-trash" title="删除"></span></div>\
                    </div>';
        },

        detailTextTpl = function() {
            var tpl = '<div class="item">\
                    <textarea class="form-control detail-text" cols="30" rows="3" style="display: inline-block; width: 80%; margin-top: 5px; vertical-align: top;"></textarea>\
                    <span class="glyphicon glyphicon-remove" style="cursor: pointer"></span>\
                </div>';
            return tpl;
        },

        detailImgTpl = function(id) {
            var tpl = '<div class="item">\
                    <div class="con clearfix">\
                        <div class="upload"><input type="text" id="' + UPLOAD_IMG_ID + id + '" /></div>\
                        <span class="glyphicon glyphicon-remove" style="cursor: pointer"></span>\
                    </div>\
                    <div class="J_img-list"></div>\
                </div>';
            return tpl;
        },

        selectedLocTpl = function(cityList) {
            var tpl = '';
            cityList.forEach(function(item) {
                tpl += ('<li><span class="name" data-cityid="' + item.cityId + '">' + item.cityName + '</span><span class="glyphicon glyphicon-remove"></span></li>');
            });
            return tpl;
        },

        tagRtTpl = function(data) {
            var tpl = '';

            data.forEach(function(item, index) {
                tpl += ('<p>' + item.group + '：');
                item.tags.forEach(function(item) {
                    tpl += ('<span class="tag"  data-tagid="' + item.tagId + '">' + item.tag + '</span>');
                });
                tpl += '</p>';
            });

            return tpl;
        },

        locationListTpl = function(data) {
            var tpl = '',
                selectedList = $('.J_list-selected-loc .name'),
                cityIdArr = [];

            selectedList.each(function() {
                cityIdArr.push(parseInt($(this).attr('data-cityid')));
            });

            data.forEach(function(item, index) {
                var selected = (cityIdArr.indexOf(item.cityId) > -1);
                tpl += ('<li><a href="javascript:;" data-cityid="' + item.cityId + '" class="' + (selected ? 'disable' : '') + '">' + item.cityName + '</a></li>');
            });

            return tpl;
        },

        initAddDetal = function() {
            var imgId = 0;
            $('.J_add-text').on('click', function() {
                detail.append(detailTextTpl());
            });

            $('.J_add-img').on('click', function() {
                detail.append(detailImgTpl(imgId));

                $("#" + UPLOAD_IMG_ID + imgId).uploadify({
                    buttonText: '上传',
                    height: 30,
                    uploader: '/bidoushi/upload',
                    width: 120,
                    onUploadSuccess: function(file, data, res) {
                        var wrap = $('#' + this.movieName).parents('.con').next('.J_img-list');
                        data = JSON.parse(data)
                        if(data.code == 200) {
                            wrap.append('<img style="margin-top: 10px;" src=' + data.result + '>')
                        } else {
                            alert(data.msg);
                        }
                    }
                });

                imgId++;
            });

            $('.J_detail').on('click', '.glyphicon-remove', function() {
                $(this).parents('.item').remove();
            });
        },

        initPrice = function() {
            $('.J_price').on('keyup', function() {
                this.value = this.value.replace(/\D/g, '');
            });
        },

        initUpload = function() {
            $("#uploadProductImg").uploadify({
                buttonText: '上传',
                height: 30,
                swf: '/uploadify/uploadify.swf',
                uploader: '/bidoushi/upload',
                width: 120,
                itemTemplate: uploadItemTpl(),
                queueID:'uploadProductImg-queue',
                onUploadSuccess: function(file, data, res) {
                    data = JSON.parse(data);
                    if(data.code == 200) {
                        var queue = $('#uploadProductImg-queue'),
                            id = file.id.split('_')[2];console.log(id)
                        queue.find('.img').eq(id).attr('src', data.result);
                        queue.find('.status').eq(id).css('visibility', 'visible');
                    } else {
                        alert(data.message);
                    }
                }
            });

            $('.J_product-img-upload').on('click', '.glyphicon-trash', function() {
                $(this).parents('.item').remove();
            });
        },

        initSelectTag = function() {
            var tagGroup = $('.J_tag-group'),
                tagGroups = tagGroup.find('li'),
                tagCon = $('.J_tag-con'),
                tagCons = tagCon.find('.tab-pane'),
                tagRtCon = $('.J_tag'),
                tagArr = [],

                setCatStatus = function(index) {
                    tagGroups.eq(index).find('.glyphicon-ok').removeClass('Hide');
                };
               // $('#modalTag').modal();
            $('.J_btn-edit-tag').on('click', function() {
                var tagIdList = tagRtCon.find('.tag').map(function(i, item) {
                    return $(item).attr('data-tagid');
                }).get();

               
                tagCon.find('.input-tag').each(function(i, item) {
                    var self = $(item);
                    if(tagIdList.indexOf(self.attr('data-tagid')) > -1) {
                        self.attr('checked', 'checked');
                    }
                });

                tagCons.each(function(index) {
                    var self = $(this),
                        tag = $(this).find('.input-tag:checked');
                    if(tag.length > 0) {
                        setCatStatus(self.index());
                    }
                });

            });

            tagCon.on('change', '.input-tag', function() {
                var self = $(this),
                    container = self.parents('.tab-pane'),
                    index = container.index();

                setCatStatus(index);

            });

            $('.J_submit-tag').on('click', function() {
            	var tagArr=[];
                tagCons.each(function(index) {
                    var tag = $(this).find('.input-tag:checked'),
                        data = {
                            group: tagGroups.eq(index).find('.name').text(),
                            tags: []
                        };
                    
                    tag.each(function(i, item) {
                        var self = $(item);
                        data.tags.push({
                            tagId: self.attr('data-tagid'),
                            tag: self.parent().text().trim()
                        });
                    });
                    
                    tagArr.push(data);
                });
                if(tagArr.length > 0) {
                    var html = tagRtTpl(tagArr);
                    tagRtCon.removeClass('Hide').children('dd').html(html);
                }
            });
        },

        searchLocation = function() {
            var list = $('.J_list-loc');

            $.ajax({
                url: '/ajax/searchlocation',
                data: {
                    keyword: $('.J_input-search').val(),
                    type: $('input[name=searchType]:checked').attr('data-type')
                },
                success: function(rt) {
                    if(rt.code == 200) {
                        list.html(locationListTpl(rt.msg.list));
                    }
                }
            });
        },

        initSelectLocation = function() {

            var locWrap = $('.J_loc'),
                list = $('.J_list-loc'),
                selectedList = $('.J_list-selected-loc');

            $('.J_btn-edit-loc').on('click', function() {

                var cityList = locWrap.find('dd span').map(function(i, item) {
                        var self = $(item);
                        return {
                            cityId: self.attr('data-cityid'),
                            cityName: self.text()
                        };
                    }).get(),
                    cityIdList = cityList.map(function(item) {
                        return item.cityId;
                    });

               
                list.find('a').each(function(i, item) {
                    var self = $(this);
                    if(cityIdList.indexOf(self.attr('data-cityid')) > -1) {
                        self.addClass('disable');
                    }
                });

                selectedList.html(selectedLocTpl(cityList));
            });
        
            $('input[name=searchType]').on('change', function() {
                searchLocation();
            });

            $('.J_input-search').on('keyup', function() {
                searchLocation();
            });

            list.on('click', 'a', function() {
                var self = $(this),
                    cityId = self.attr('data-cityid'),
                    cityName = self.text();

                if(self.hasClass('disable')) {
                    return;
                }

                selectedList.append(selectedLocTpl([{
                    cityId: cityId,
                    cityName: cityName
                }]));
                self.addClass('disable');
            });

            selectedList.on('click', '.glyphicon-remove', function() {
                var item = $(this).parent(),
                    loc = item.find('.name'),
                    cityId = loc.attr('data-cityid');

                list.find('a').each(function(i, item) {
                    var self = $(this);
                    if(self.attr('data-cityid') == cityId) {
                        self.removeClass('disable');
                    }
                });
                item.remove();

            });

            $('.J_submit-loc').on('click', function() {
            	var cityArr=[];
                selectedList.find('.name').each(function(i, item) {
                    var self = $(item),
                        cityId = self.attr('data-cityid'),
                        cityName = self.text();
                    	cityArr.push({id:cityId,name:cityName});
                });
                var html="";
                cityArr.forEach(function(item){
                	html+='<span data-cityid="' + item.id + '">' + item.name + '</span>';
                });
                locWrap.find('dd').html(html);
                if(cityArr.length){
                	locWrap.removeClass('Hide');
                }else{
                	locWrap.addClass('Hide');
                }
            });
        },

        getValue = function(item) {
            return (item.val() + '').trim();
        },

        checkedFormData = function(data) {
            var checked = true;

            for(var i in data) {
                var dataI = data[i];
                if((typeof dataI == 'string' && dataI == '') || ($.isArray(dataI) && dataI.length == 0)) {
                    checked = false;
                    break;
                }
            }

            return checked;
        },

        initSubmit = function() {
            $('.J_submit').on('click', function() {
                var data = {};
                
                
                data.id=getValue($('[name="id"]'));
                data.name = getValue($('.J_name'));
                data.images = [];
                data.descInfos = [];
                data.price = getValue($('.J_price'));
                data.recommand = getValue($('.J_rcmd-reason'))
                data.tagIds = [];
                data.destIds = [];
                data.url = getValue($('.J_buy-url'));
                $('.J_product-img-upload img').map(function(i, item) {
                    data.images.push(item.src);
                });

                $('.J_detail .item').each(function(i, item) {
                    var self = $(item),
                        textarea = self.find('textarea');
                    if(textarea.length > 0) {
                        var value = getValue(textarea);
                        if(value != '') {
                            data.descInfos.push(value);
                        }
                    } else {
                        self.find('img').each(function(i, item) {
                            data.descInfos.push(item.src);
                        });
                    }

                });

                $('.J_tag .tag').map(function(i, item) {
                    data.tagIds.push($(item).attr('data-tagid'));
                });

                $('.J_loc dd span').map(function(i, item) {
                    data.destIds.push($(item).attr('data-cityid'));
                });

                //if(!checkedFormData(data)) {
                //    alert('请把信息填写完整！');
                //    return false;
               // }

                $.ajax({
                    url: $('form').prop('action'),
                    data: data,
                    type: 'post',
                    dataType:'json',
                    success: function(r) {
                        if(r.code == 200) {
                            alert('提交成功！');
                           window.location = $('meta[name="basePath"]').attr('content')+'/product/list';
                        } else {
                            alert(r.msg);
                        }
                    },
                    traditional:true
                });
                return false;
            });
        };

    initAddDetal();
    initPrice();
    initUpload();
    initSelectTag();
    initSelectLocation();
    initSubmit();

});