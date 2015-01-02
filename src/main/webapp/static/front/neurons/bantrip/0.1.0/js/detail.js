(function(){
function mix(a,b){for(var k in b){a[k]=b[k];}return a;}
var _0 = "bantrip@0.1.0/js/detail.js";
var _1 = "bantrip@0.1.0/js/index.js";
var _2 = "bantrip@0.1.0/js/list.js";
var _3 = "jquery@^1.9.1";
var entries = [_0,_1,_2];
var asyncDepsToMix = {};
var globalMap = asyncDepsToMix;
define(_0, [_3], function(require, exports, module, __filename, __dirname) {
var $ = require('jquery'),

	initImg = function() {
		var img = $('.J_main-img');

		$('.J_trigger-img').on('click', 'li', function() {
			var self = $(this);

			self.addClass('on').siblings('li').removeClass('on');
			img.attr('src', self.attr('data-url'));
		});
	},
	
	updateAmount = function(value) {
		var input = $('.J_amount-input'),
			reduceBtn = $('.J_amount-reduce'),
			amount = parseInt(input.val()) + value;

		input.val(amount);
		if(amount > 1) {
			reduceBtn.removeClass('disable');
		} else {
			reduceBtn.addClass('disable');
		}
	},

	initAmount = function() {
		$('.J_amount-reduce').on('click', function() {
			if($(this).hasClass('disable')) {
				return;
			}
			updateAmount(-1);
		});

		$('.J_amount-add').on('click', function() {
			updateAmount(1);
		});
	},

	initLike = function() {
		$('.J_btn-like').on('click', function() {
			var self = $(this);
			
		});
	};


exports.init = function() {
	initImg();
	initAmount();
};
}, {
    entries:entries,
    map:globalMap
});
})();