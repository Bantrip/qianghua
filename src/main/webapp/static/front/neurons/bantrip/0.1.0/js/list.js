(function(){
function mix(a,b){for(var k in b){a[k]=b[k];}return a;}
var _0 = "bantrip@0.1.0/js/detail.js";
var _1 = "bantrip@0.1.0/js/index.js";
var _2 = "bantrip@0.1.0/js/list.js";
var _3 = "jquery@^1.9.1";
var _4 = "mbox@^1.0.1";
var _5 = "tpl@~0.2.1";
var _6 = "bantrip@0.1.0/js/tpl/loc.html.js";
var entries = [_0,_1,_2];
var asyncDepsToMix = {};
var globalMap = asyncDepsToMix;
define(_2, [_3,_4,_5,_6], function(require, exports, module, __filename, __dirname) {
var $ = require('jquery'),
	Mbox = require('mbox'),
	Tpl = require('tpl'),
	template = require('./tpl/loc.html.js'),
	
	initEditLoc = function() {
		$('.J_btn-edit').on('click', function() {
			new Mbox({
				winCls: 'pop-box pop-edit-loc',
                content: Mbox.dialog('更改目的地', Tpl.compile(template)())
            }).open();
		});
	};

exports.init = function() {
	initEditLoc();
};
}, {
    entries:entries,
    map:mix({"./tpl/loc.html.js":_6},globalMap)
});

define(_6, [], function(require, exports, module, __filename, __dirname) {
module.exports='<div class="section-search Fix"><div class="result"><h3 class="tit"><span class="icon-dot"></span>搜索目的地</h3><div class="block"><div class="search"><span class="icon-search"></span><input type="text" placeholder="搜索国家、城市、景点" class="input J_search-city"><!-- <div class="nav"><a href="javascript:;">北美</a><span>></span><a href="javascript:;">北美</a><span>></span><span>美国</span></div> --></div><div class="list J_city-list"><ul class="con"><li class="city" data-cityid="1"><span class="icon-add"></span><a href="" class="name">曼谷 Bangkok</a><span class="rec">11111个推荐商品</span></li><li class="city" data-cityid="2"><span class="icon-add"></span><a href="" class="name">香港 Hongkong</a><span class="rec">11111个推荐商品</span></li></ul><div class="loading"></div></div></div></div><div class="select"><h3 class="tit"><span class="icon-dot"></span>已选择目的地</h3><ul class="list J_city-select-list"></ul><a href="list.html" class="btn-view">查看商品</a></div></div>';
}, {
    entries:entries,
    map:globalMap
});
})();