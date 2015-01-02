(function(){
function mix(a,b){for(var k in b){a[k]=b[k];}return a;}
var _0 = "bantrip@0.1.0/js/detail.js";
var _1 = "bantrip@0.1.0/js/index.js";
var _2 = "bantrip@0.1.0/js/list.js";
var _3 = "jquery@^1.9.1";
var _4 = "tpl@~0.2.1";
var entries = [_0,_1,_2];
var asyncDepsToMix = {};
var globalMap = asyncDepsToMix;

define("1.js",["jquery@^1.9.1"],function($){
	var $ = require('jquery');
	$.ajax($('.search input').data("url"));
});

define(_1, [_3,_4], function(require, exports, module, __filename, __dirname) {
var $ = require('jquery'),
	Tpl = require('tpl'),

	initSearch = function() {

		var listWrap = $('.J_city-list'),
			list = listWrap.find('.con'),
			loading = listWrap.find('.loading'),

			selectList = $('.J_city-select-list'),
			selectIds = [],

			input = $('.J_search-city'),

			tpl = '<?js it.forEach(function(item) { ?><li class="city<?js if(item.selected) { ?> selected<?js } ?>" data-cityid="@{item.id}">\
					<span class="icon-add"></span>\
					<a href="" class="name">@{item.name}</a>\
				<?js if(item.amount) { ?>\
					<span class="rec">@{item.amount}个推荐商品</span>\
				<?js } ?>\
				</li><?js }); ?>',
			tplFn = Tpl.compile(tpl);
		var loc=location,url=$('.J_search-city').data("url");
		input.on('keyup', function() {
			var self = $(this),
				keyword = (self.val() + '').trim();

			list.html('');
			loading.show();

			selectList.find('li').each(function(i, item) {
				selectIds.push($(item).attr('data-cityid'));
			});

			var req=$.ajax({
				url: url,
				data: {
					keyword: keyword
				},
				success: function(r) {
					if(r.code == 200) {
						var data = r.result,
							html;
						data.forEach(function(item) {
							if(selectIds.indexOf(item.id + '') > -1) {
								item.selected = true;
							}
						});

						html = tplFn(data);
						list.html(html);
						loading.hide();
					} else {

					}
				}
			});
			req.success(function(r){
					if(r.code == 200) {
						var data = r.result,
							html;

						data.forEach(function(item) {
							if(selectIds.indexOf(item.id + '') > -1) {
								item.selected = true;
							}
						});

						html = tplFn(data);
						list.html(html);
						loading.hide();
					} else {

					}
			});
			
		});

	},

	initCity = function() {

		var list = $('.J_city-list .con'),
			selectList = $('.J_city-select-list'),
			input = $('.J_search-city');

		list.on('click', '.city .icon-add', function() {
			var self = $(this),
				city = self.parent('.city'),
				cityId = city.attr('data-cityid'),
				cityName = city.find('.name').text();

			city.addClass('selected');

			$('<li class="city" data-cityid="' + cityId + '"><span class="icon-del">X</span>' + cityName + '</li>').appendTo(selectList);
		});

		selectList.on('click', '.icon-del', function() {
			var self = $(this),
				city = self.parent('.city'),
				cityId = city.attr('data-cityid');

			city.remove();
			list.find('.city[data-cityid= ' + cityId + ']').removeClass('selected');

		});
		var btn = $('#J_to-list'),url=btn.data("url");
		btn.on('mousedown',function(){
			btn.attr('href',url+'?'+selectList.find("li").map(function(index,item){
				var id=$(item).data('cityid');
				if(id){
					return "dest="+$(item).data('cityid');
				}
			}).get().join('&'));
		});
	};

	function jumper(){
		
	}
	
exports.init = function() {
	initSearch();
	initCity();
};
}, {
    entries:entries,
    map:globalMap
});
})();