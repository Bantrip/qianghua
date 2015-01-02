(function(){
function mix(a,b){for(var k in b){a[k]=b[k];}return a;}
var _0 = "bantrip@0.1.0/js/detail.js";
var _1 = "bantrip@0.1.0/js/index.js";
var _2 = "bantrip@0.1.0/js/list.js";
var _3 = "bantrip@0.1.0/index.js";
var entries = [_0,_1,_2];
var asyncDepsToMix = {};
var globalMap = asyncDepsToMix;
define(_3, [], function(require, exports, module, __filename, __dirname) {

// Opt in to strict mode of JavaScript, [ref](http://is.gd/3Bg9QR)
// Use this statement, you can stay away from several frequent mistakes 
'use strict';



// How to use a foreign module ?
// Take 'jquery' for example:
//
// 1. to install a dependency, exec the command in your terminal
// ```bash
// cortex install jquery --save
// ```

// 2. use `require(id)`:

// var $ = require('jquery');


// 3. define exports:
// `exports` is the API of the current module,
// If another module `require('bantrip')`, it returns `exports`

// exports.my_method = function() {
// };

// or you could code like this:

// module.exports = {
// 	 my_method: function() {
// 	 }
// };

// But, NEVER do this: (Why?)
// exports = {my_method: ...}

}, {
    entries:entries,
    main:true,
    map:globalMap
});
})();