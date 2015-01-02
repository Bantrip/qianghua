(function(){
function mix(a,b){for(var k in b){a[k]=b[k];}return a;}
var _0 = "image-lazyload@0.2.0/index.js";
var asyncDepsToMix = {};
var globalMap = asyncDepsToMix;
define(_0, [], function(require, exports, module, __filename, __dirname) {
'use strict';
var getImgs = function(className) {
    var imgs = document.getElementsByTagName('IMG');
    var res = [];
    for (var i = 0; i < imgs.length; i++) {
        if (imgs[i].className.indexOf(className) >= 0) res.push(imgs[i]);
    }
    return res;
};
module.exports = {
    init: function(opt){
        var _this = this;
        this.triggerLength = opt.triggerLength || 200;
        this.checkInterval = 75;
        this.className = opt.className || 'lazy';
        this.lazyImgs = getImgs(this.className);
        this.attrName = 'data-src';
        this.prevScroll = 0;
        this.finished = false;
        var isTouch = ('ontouchmove' in document) && (typeof document.addEventListener !== 'undefined');
        var scrollListener = function(){
            if (_this.finished) {
                removeListener();
            } else {
                var scroll = window.pageYOffset;
                if (typeof scroll !== 'number') {
                    scroll = document.documentElement.scrollTop;
                }
                if (scroll - _this.prevScroll > _this.checkInterval) {
                    _this.prevScroll = scroll;
                    _this.check();
                }
            }
        };
        var removeListener = function(){
            if (isTouch) {
                document.removeEventListener('touchmove', scrollListener);
            }
            window.removeEventListener('scroll', scrollListener);
        };
        if (isTouch) {
            document.addEventListener('touchmove', scrollListener);
        }
        if (typeof window.addEventListener !== 'undefined') {
            window.addEventListener('scroll', scrollListener);
        } else {
            var oldHandle = null;
            if (typeof window.onscroll === 'function') {
                oldHandle = window.onscroll;
            }
            removeListener = function(){
                window.onscroll = oldHandle;
            };
            window.onscroll = function(){
                oldHandle && oldHandle.call(this);
                scrollListener();
            };
        }
        this.check();
    },
    check: function(){
        var _this = this;
        var legacy = [];
        for (var i = 0; i < this.lazyImgs.length; i++) {
            var el = this.lazyImgs[i];
            var offset = (el.getBoundingClientRect ? el.getBoundingClientRect().top : 0) - document.documentElement.clientHeight;
            if (!(offset >= _this.triggerLength)){  // fallback for NaN
                el.src = el.getAttribute(_this.attrName);
                el.style.visibility="visible";
            } else {
                legacy.push(el);
            }
        }
        this.lazyImgs = legacy;
        if (!legacy.length) {
            this.finished = true;
        }
    }
};
}, {
    main:true,
    map:globalMap
});
})();