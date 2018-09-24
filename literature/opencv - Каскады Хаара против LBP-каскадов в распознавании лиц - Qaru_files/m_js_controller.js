(function(_){var ba,ea,fa,ha,ia,ka,ma,la,na,pa,va,wa,Ba,Da;ba=function(a){return function(){return _.aa[a].apply(this,arguments)}};ea=function(a,b){var c=_.k(b,ca,16);c&&_.m(c,12,!1)&&_.m(b,5,!1)&&da(a,{backgroundColor:"transparent",backgroundImage:"none"})};_.aa=[];fa="function"==typeof Object.defineProperties?Object.defineProperty:function(a,b,c){a!=Array.prototype&&a!=Object.prototype&&(a[b]=c.value)};ha="undefined"!=typeof window&&window===this?this:"undefined"!=typeof window.global&&null!=window.global?window.global:this;ia=function(){ia=function(){};ha.Symbol||(ha.Symbol=ka)};ka=function(){var a=0;return function(b){return"jscomp_symbol_"+(b||"")+a++}}();ma=function(){ia();var a=ha.Symbol.iterator;a||(a=ha.Symbol.iterator=ha.Symbol("iterator"));"function"!=typeof Array.prototype[a]&&fa(Array.prototype,a,{configurable:!0,writable:!0,value:function(){return la(this)}});ma=function(){}};la=function(a){var b=0;return na(function(){return b<a.length?{done:!1,value:a[b++]}:{done:!0}})};na=function(a){ma();a={next:a};a[ha.Symbol.iterator]=function(){return this};return a};_.oa=function(a){ma();var b=a[window.Symbol.iterator];return b?b.call(a):la(a)};pa=function(a){if(a){for(var b=ha,c=["Promise"],d=0;d<c.length-1;d++){var e=c[d];e in b||(b[e]={});b=b[e]}c=c[c.length-1];d=b[c];a=a(d);a!=d&&null!=a&&fa(b,c,{configurable:!0,writable:!0,value:a})}};pa(function(a){function b(){this.g=null}function c(a){return a instanceof e?a:new e(function(b){b(a)})}if(a)return a;b.prototype.l=function(a){null==this.g&&(this.g=[],this.v());this.g.push(a)};b.prototype.v=function(){var a=this;this.o(function(){a.B()})};var d=ha.setTimeout;b.prototype.o=function(a){d(a,0)};b.prototype.B=function(){for(;this.g&&this.g.length;){var a=this.g;this.g=[];for(var b=0;b<a.length;++b){var c=a[b];delete a[b];try{c()}catch(q){this.A(q)}}}this.g=null};b.prototype.A=function(a){this.o(function(){throw a;})};var e=function(a){this.g=0;this.o=void 0;this.l=[];var b=this.v();try{a(b.resolve,b.reject)}catch(n){b.reject(n)}};e.prototype.v=function(){function a(a){return function(d){c||(c=!0,a.call(b,d))}}var b=this,c=!1;return{resolve:a(this.G),reject:a(this.A)}};e.prototype.G=function(a){if(a===this)this.A(new TypeError("A Promise cannot resolve to itself"));else if(a instanceof e)this.I(a);else{a:switch(typeof a){case "object":var b=null!=a;break a;case "function":b=!0;break a;default:b=!1}b?this.F(a):this.B(a)}};e.prototype.F=function(a){var b=void 0;try{b=a.then}catch(n){this.A(n);return}"function"==typeof b?this.J(b,a):this.B(a)};e.prototype.A=function(a){this.C(2,a)};e.prototype.B=function(a){this.C(1,a)};e.prototype.C=function(a,b){if(0!=this.g)throw Error("Cannot settle("+a+", "+b|"): Promise already settled in state"+this.g);this.g=a;this.o=b;this.D()};e.prototype.D=function(){if(null!=this.l){for(var a=this.l,b=0;b<a.length;++b)a[b].call(),a[b]=null;this.l=null}};var f=new b;e.prototype.I=function(a){var b=this.v();a.la(b.resolve,b.reject)};e.prototype.J=function(a,b){var c=this.v();try{a.call(b,c.resolve,c.reject)}catch(q){c.reject(q)}};e.prototype.then=function(a,b){function c(a,b){return"function"==typeof a?function(b){try{d(a(b))}catch(Ca){f(Ca)}}:b}var d,f,g=new e(function(a,b){d=a;f=b});this.la(c(a,d),c(b,f));return g};e.prototype["catch"]=function(a){return this.then(void 0,a)};e.prototype.la=function(a,b){function c(){switch(d.g){case 1:a(d.o);break;case 2:b(d.o);break;default:throw Error("Unexpected state: "+d.g);}}var d=this;null==this.l?f.l(c):this.l.push(function(){f.l(c)})};e.resolve=c;e.reject=function(a){return new e(function(b,c){c(a)})};e.race=function(a){return new e(function(b,d){for(var e=_.oa(a),f=e.next();!f.done;f=e.next())c(f.value).la(b,d)})};e.all=function(a){var b=_.oa(a),d=b.next();return d.done?c([]):new e(function(a,e){function f(b){return function(c){g[b]=c;l--;0==l&&a(g)}}var g=[],l=0;do g.push(void 0),l++,c(d.value).la(f(g.length-1),e),d=b.next();while(!d.done)})};return e});var qa="function"==typeof Object.create?Object.create:function(a){var b=function(){};b.prototype=a;return new b},ra;if("function"==typeof Object.setPrototypeOf)ra=Object.setPrototypeOf;else{var sa;a:{var ta={a:!0},ua={};try{ua.__proto__=ta;sa=ua.a;break a}catch(a){}sa=!1}ra=sa?function(a,b){a.__proto__=b;if(a.__proto__!==b)throw new TypeError(a+" is not extensible");return a}:null}va=ra;wa=function(a,b){a.prototype=qa(b.prototype);a.prototype.constructor=a;if(va)va(a,b);else for(var c in b)if("prototype"!=c)if(Object.defineProperties){var d=Object.getOwnPropertyDescriptor(b,c);d&&Object.defineProperty(a,c,d)}else a[c]=b[c];a.X=b.prototype};_.p=this;_.t=function(a){return void 0!==a};_.u=function(a){return"string"==typeof a};_.w=function(a,b,c){a=a.split(".");c=c||_.p;a[0]in c||!c.execScript||c.execScript("var "+a[0]);for(var d;a.length&&(d=a.shift());)!a.length&&_.t(b)?c[d]=b:c[d]&&c[d]!==Object.prototype[d]?c=c[d]:c=c[d]={}};_.xa=function(){};_.ya=function(a){var b=typeof a;if("object"==b)if(a){if(a instanceof Array)return"array";if(a instanceof Object)return b;var c=Object.prototype.toString.call(a);if("[object Window]"==c)return"object";if("[object Array]"==c||"number"==typeof a.length&&"undefined"!=typeof a.splice&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("splice"))return"array";if("[object Function]"==c||"undefined"!=typeof a.call&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("call"))return"function"}else return"null";else if("function"==b&&"undefined"==typeof a.call)return"object";return b};_.za=function(a){return"array"==_.ya(a)};_.Aa=function(a){return"function"==_.ya(a)};Ba=function(a,b,c){return a.call.apply(a.bind,arguments)};Da=function(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var c=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(c,d);return a.apply(b,c)}}return function(){return a.apply(b,arguments)}};_.y=function(a,b,c){Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?_.y=Ba:_.y=Da;return _.y.apply(null,arguments)};_.z=function(a,b){var c=Array.prototype.slice.call(arguments,1);return function(){var b=c.slice();b.push.apply(b,arguments);return a.apply(this,b)}};_.A=Date.now||function(){return+new Date};_.B=function(a,b){function c(){}c.prototype=b.prototype;a.X=b.prototype;a.prototype=new c;a.prototype.constructor=a;a.Zb=function(a,c,f){for(var d=Array(arguments.length-2),e=2;e<arguments.length;e++)d[e-2]=arguments[e];return b.prototype[c].apply(a,d)}};var Ga;_.Ea=Array.prototype.indexOf?function(a,b){return Array.prototype.indexOf.call(a,b,void 0)}:function(a,b){if(_.u(a))return _.u(b)&&1==b.length?a.indexOf(b,0):-1;for(var c=0;c<a.length;c++)if(c in a&&a[c]===b)return c;return-1};_.Fa=Array.prototype.forEach?function(a,b,c){Array.prototype.forEach.call(a,b,c)}:function(a,b,c){for(var d=a.length,e=_.u(a)?a.split(""):a,f=0;f<d;f++)f in e&&b.call(c,e[f],f,a)};Ga=Array.prototype.filter?function(a,b){return Array.prototype.filter.call(a,b,void 0)}:function(a,b){for(var c=a.length,d=[],e=0,f=_.u(a)?a.split(""):a,g=0;g<c;g++)if(g in f){var l=f[g];b.call(void 0,l,g,a)&&(d[e++]=l)}return d};_.Ha=Array.prototype.some?function(a,b){return Array.prototype.some.call(a,b,void 0)}:function(a,b){for(var c=a.length,d=_.u(a)?a.split(""):a,e=0;e<c;e++)if(e in d&&b.call(void 0,d[e],e,a))return!0;return!1};_.Ia=function(a,b){b=(0,_.Ea)(a,b);var c;(c=0<=b)&&Array.prototype.splice.call(a,b,1);return c};_.Ja=function(a){var b=a.length;if(0<b){for(var c=Array(b),d=0;d<b;d++)c[d]=a[d];return c}return[]};_.C=function(a,b){return 0==a.lastIndexOf(b,0)};_.D=function(a){return/^[\s\xa0]*$/.test(a)};_.Ka=String.prototype.trim?function(a){return a.trim()}:function(a){return/^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]};_.La=function(a){return(0,window.decodeURIComponent)(a.replace(/\+/g," "))};_.Ma=function(a){return null==a?"":String(a)};_.Na=function(){return Math.floor(2147483648*Math.random()).toString(36)+Math.abs(Math.floor(2147483648*Math.random())^(0,_.A)()).toString(36)};var Oa;a:{var Pa=_.p.navigator;if(Pa){var Qa=Pa.userAgent;if(Qa){Oa=Qa;break a}}Oa=""}var E=function(a){return-1!=Oa.indexOf(a)};var Ra=function(){return E("iPhone")&&!E("iPod")&&!E("iPad")};var Sa=function(a){Sa[" "](a);return a};Sa[" "]=_.xa;_.Ta=function(a,b){try{return Sa(a[b]),!0}catch(c){}return!1};var Wa,bb,cb;_.Ua=E("Opera");_.Va=E("Trident")||E("MSIE");Wa=E("Edge");_.Xa=E("Gecko")&&!(-1!=Oa.toLowerCase().indexOf("webkit")&&!E("Edge"))&&!(E("Trident")||E("MSIE"))&&!E("Edge");_.Ya=-1!=Oa.toLowerCase().indexOf("webkit")&&!E("Edge");_.Za=E("Android");_.$a=Ra();_.ab=E("iPad");bb=function(){var a=_.p.document;return a?a.documentMode:void 0};a:{var db="",eb=function(){var a=Oa;if(_.Xa)return/rv:([^\);]+)(\)|;)/.exec(a);if(Wa)return/Edge\/([\d\.]+)/.exec(a);if(_.Va)return/\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/.exec(a);if(_.Ya)return/WebKit\/(\S+)/.exec(a);if(_.Ua)return/(?:Version)[ \/]?(\S+)/.exec(a)}();eb&&(db=eb?eb[1]:"");if(_.Va){var fb=bb();if(null!=fb&&fb>(0,window.parseFloat)(db)){cb=String(fb);break a}}cb=db}_.gb=cb;var jb=_.p.document;_.ib=jb&&_.Va?bb()||("CSS1Compat"==jb.compatMode?(0,window.parseInt)(_.gb,10):5):void 0;_.kb=Ra()||E("iPod");_.lb=E("iPad");_.nb=E("Android")&&!((E("Chrome")||E("CriOS"))&&!E("Edge")||E("Firefox")||E("Opera")||E("Silk"));var ob,pb,rb;_.F=function(){};ob="function"==typeof window.Uint8Array;_.G=function(a,b,c){a.g=null;b||(b=[]);a.C=void 0;a.v=-1;a.l=b;a:{if(a.l.length){b=a.l.length-1;var d=a.l[b];if(d&&"object"==typeof d&&!_.za(d)&&!(ob&&d instanceof window.Uint8Array)){a.A=b-a.v;a.o=d;break a}}a.A=Number.MAX_VALUE}a.B={};if(c)for(b=0;b<c.length;b++)if(d=c[b],d<a.A)d+=a.v,a.l[d]=a.l[d]||pb;else{var e=a.A+a.v;a.l[e]||(a.o=a.l[e]={});a.o[d]=a.o[d]||pb}};pb=[];_.qb=function(a,b){if(b<a.A){b+=a.v;var c=a.l[b];return c===pb?a.l[b]=[]:c}if(a.o)return c=a.o[b],c===pb?a.o[b]=[]:c};rb=function(a,b){if(b<a.A){b+=a.v;var c=a.l[b];return c===pb?a.l[b]=[]:c}c=a.o[b];return c===pb?a.o[b]=[]:c};_.m=function(a,b,c){a=_.qb(a,b);return null==a?c:a};_.k=function(a,b,c){a.g||(a.g={});if(!a.g[c]){var d=_.qb(a,c);d&&(a.g[c]=new b(d))}return a.g[c]};_.sb=function(a,b,c){a.g||(a.g={});if(!a.g[c]){for(var d=rb(a,c),e=[],f=0;f<d.length;f++)e[f]=new b(d[f]);a.g[c]=e}b=a.g[c];b==pb&&(b=a.g[c]=[]);return b};_.tb=function(a){if(a.g)for(var b in a.g){var c=a.g[b];if(_.za(c))for(var d=0;d<c.length;d++)c[d]&&_.tb(c[d]);else c&&_.tb(c)}return a.l};var vb=function(a){_.G(this,a,ub)},ub,xb;_.B(vb,_.F);ub=[1,23];xb=function(a){return _.sb(a,_.wb,1)};_.wb=function(a){_.G(this,a,yb)};_.B(_.wb,_.F);var yb=[20,33];_.wb.prototype.getType=function(){return _.m(this,1,0)};var ca=function(a){_.G(this,a,null)};_.B(ca,_.F);_.zb=function(a){_.G(this,a,null)};_.B(_.zb,_.F);var Ab;_.Bb=function(a){_.G(this,a,Ab)};_.B(_.Bb,_.F);Ab=[3];_.Db=function(){var a=_.Cb();return _.m(a,7,!1)};var Eb;Eb={sb:0,Tb:1,Ub:45,Vb:46,Gb:48,URL:2,kb:3,ab:4,Sb:5,Mb:7,yb:8,jb:9,Ab:6,Db:34,tb:13,bb:14,zb:15,Bb:16,Cb:40,Qb:47,Xb:29,pb:30,Rb:49,Hb:17,lb:18,rb:19,qb:20,eb:21,Jb:22,Ob:23,gb:24,Lb:25,Kb:26,ib:27,Ib:28,VIDEO:39,Wb:31,ob:32,fb:33,ub:35,Eb:36,cb:37,nb:38,Fb:42,Nb:43,Pb:44,vb:1E3,wb:1001,xb:1002};_.Fb=[16,47,49,18,27,28,39];var Gb=function(a,b,c,d,e){c="&"+b+"="+c;var f=a.indexOf("&"+d+"=");c=0>f?a+c:a.substring(0,f)+c+a.substring(f);return 2E3<c.length?_.t(e)?Gb(a,b,e,d,void 0):a:c};_.H=window.document;_.J=window;_.Ib=function(){this.g="";this.l=_.Hb};_.Ib.prototype.va=!0;_.Ib.prototype.ua=function(){return this.g};_.Ib.prototype.toString=function(){return"Const{"+this.g+"}"};_.Hb={};_.K=function(a){var b=new _.Ib;b.g=a;return b};_.K("");var Mb,Ob,Jb;_.Kb=function(){this.g="";this.l=Jb};_.Kb.prototype.va=!0;_.Kb.prototype.ua=function(){return this.g};_.Lb=function(a){if(a instanceof _.Kb&&a.constructor===_.Kb&&a.l===Jb)return a.g;_.ya(a);return"type_error:SafeUrl"};Mb=/^(?:(?:https?|mailto|ftp):|[^:/?#]*(?:[/?#]|$))/i;Ob=function(a){if(a instanceof _.Kb)return a;a=a.va?a.ua():String(a);Mb.test(a)||(a="about:invalid#zClosurez");return _.Nb(a)};Jb={};_.Nb=function(a){var b=new _.Kb;b.g=a;return b};_.Nb("about:blank");_.Pb=function(a,b){b=b instanceof _.Kb?b:Ob(b);a.href=_.Lb(b)};var Qb=function(a){try{return!!a&&null!=a.location.href&&_.Ta(a,"foo")}catch(b){return!1}},Rb=function(a,b){if(a)for(var c in a)Object.prototype.hasOwnProperty.call(a,c)&&b.call(void 0,a[c],c,a)};var Sb=function(a,b){this.g=_.t(a)?a:0;this.l=_.t(b)?b:0};Sb.prototype.ceil=function(){this.g=Math.ceil(this.g);this.l=Math.ceil(this.l);return this};Sb.prototype.floor=function(){this.g=Math.floor(this.g);this.l=Math.floor(this.l);return this};Sb.prototype.round=function(){this.g=Math.round(this.g);this.l=Math.round(this.l);return this};_.L=function(a,b,c){a.addEventListener?a.addEventListener(b,c,void 0):a.attachEvent&&a.attachEvent("on"+b,c)};_.Tb=function(a,b,c){a.removeEventListener?a.removeEventListener(b,c,void 0):a.detachEvent&&a.detachEvent("on"+b,c)};_.Ub=function(a,b,c){a.google_image_requests||(a.google_image_requests=[]);var d=a.document.createElement("img");if(c){var e=function(a){c(a);_.Tb(d,"load",e);_.Tb(d,"error",e)};_.L(d,"load",e);_.L(d,"error",e)}d.src=b;a.google_image_requests.push(d)};var Vb,Wb,Xb,Yb,da;Vb=Object.prototype.hasOwnProperty;Wb=function(a,b){for(var c in a)Vb.call(a,c)&&b.call(void 0,a[c],c,a)};Xb=!!window.google_async_iframe_id;Yb=Xb&&window.parent||window;_.Zb=function(a){a.preventDefault?a.preventDefault():a.returnValue=!1};_.$b=function(a,b,c){c=void 0===c?_.H:c;switch(a){case 2:return c.getElementsByClassName(b);case 3:return c.getElementsByTagName(b)}return[]};_.M=function(a,b,c){c=void 0===c?_.H:c;switch(a){case 1:if(c.getElementById)return c.getElementById(b);break;case 2:case 3:if(a=_.$b(a,b,c),0<a.length)return a[0]}return null};da=function(a,b){a&&Wb(b,function(b,d){a.style[d]=b})};var ec,fc,hc,ic,lc,mc,nc,oc,pc;_.ac=function(a,b,c,d,e,f,g){var l="";a&&(l+=a+":");c&&(l+="//",b&&(l+=b+"@"),l+=c,d&&(l+=":"+d));e&&(l+=e);f&&(l+="?"+f);g&&(l+="#"+g);return l};_.bc=/^(?:([^:/?#.]+):)?(?:\/\/(?:([^/?#]*)@)?([^/#?]*?)(?::([0-9]+))?(?=[/#?]|$))?([^?#]+)?(?:\?([^#]*))?(?:#([\s\S]*))?$/;_.cc=function(a){return a?(0,window.decodeURI)(a):a};_.N=function(a,b){return b.match(_.bc)[a]||null};_.dc=function(a){return _.cc(_.N(3,a))};ec=function(a){var b=a.indexOf("#");0>b&&(b=a.length);var c=a.indexOf("?");if(0>c||c>b){c=b;var d=""}else d=a.substring(c+1,b);return[a.substr(0,c),d,a.substr(b)]};fc=function(a,b){return b?a?a+"&"+b:b:a};_.gc=function(a,b){if(!b)return a;a=ec(a);a[1]=fc(a[1],b);return a[0]+(a[1]?"?"+a[1]:"")+a[2]};hc=function(a,b,c){if(_.za(b))for(var d=0;d<b.length;d++)hc(a,String(b[d]),c);else null!=b&&c.push(a+(""===b?"":"="+(0,window.encodeURIComponent)(String(b))))};ic=function(a,b){var c=[];for(b=b||0;b<a.length;b+=2)hc(a[b],a[b+1],c);return c.join("&")};_.jc=function(a){var b=[],c;for(c in a)hc(c,a[c],b);return b.join("&")};_.kc=function(a,b){var c=2==arguments.length?ic(arguments[1],0):ic(arguments,1);return _.gc(a,c)};lc=function(a,b,c){c=null!=c?"="+(0,window.encodeURIComponent)(String(c)):"";return _.gc(a,b+c)};mc=function(a,b,c,d){for(var e=c.length;0<=(b=a.indexOf(c,b))&&b<d;){var f=a.charCodeAt(b-1);if(38==f||63==f)if(f=a.charCodeAt(b+e),!f||61==f||38==f||35==f)return b;b+=e+1}return-1};nc=/#|$/;_.O=function(a,b){var c=a.search(nc),d=mc(a,0,b,c);if(0>d)return null;var e=a.indexOf("&",d);if(0>e||e>c)e=c;d+=b.length+1;return _.La(a.substr(d,e-d))};oc=/[?&]($|#)/;_.P=function(a,b,c){for(var d=a.search(nc),e=0,f,g=[];0<=(f=mc(a,e,b,d));)g.push(a.substring(e,f)),e=Math.min(a.indexOf("&",f)+1||d,d);g.push(a.substr(e));a=g.join("").replace(oc,"$1");return lc(a,b,c)};pc=function(a,b){a=ec(a);var c=a[1],d=[];c&&(0,_.Fa)(c.split("&"),function(a){var c=a.indexOf("=");b.hasOwnProperty(0<=c?a.substr(0,c):a)||d.push(a)});a[1]=fc(d.join("&"),_.jc(b));return a[0]+(a[1]?"?"+a[1]:"")+a[2]};_.Q=function(a){var b=lc("https://pagead2.googlesyndication.com/pagead/gen_204","zx",_.Na());_.qc(b,a)};_.rc=function(a,b){Math.random()<=a&&_.Q(b)};_.qc=function(a,b){a=pc(a,b||{});window.googleJsEnvironment&&window.googleJsEnvironment.pinger&&window.googleJsEnvironment.pinger.pingUrl?window.googleJsEnvironment.pinger.pingUrl(a):_.Ub(window,a,void 0)};var sc,wc,yc,Bc;_.Cb=function(){sc||(sc=_.J.google_casm?new _.Bb(_.J.google_casm):new _.Bb);return sc};_.tc=function(a){if(_.nb||_.Za){if("/store/apps/details/"==_.cc(_.N(5,a))){var b="/store/apps/details";_.C(b,"/")||(b="/"+b);a=a.match(_.bc);a=_.ac(a[1],a[2],a[3],a[4],b,a[6],a[7])}return a.replace(/https?:\/\/(market.android.com|play.google.com\/store\/apps)\//,"market://")}return a};_.uc=function(a,b,c){b=(0,window.encodeURIComponent)(String(b));c=(0,window.encodeURIComponent)(String(c));return a.replace("?","?"+b+"="+c+"&")};_.vc=function(a){if(_.J.jstiming&&_.Aa(_.J.jstiming.report)){var b=new _.J.jstiming.Timer;a.send();b.tick&&(b.tick("cr_csr"),_.J.jstiming.report(b))}else a.send()};_.xc=function(a){if(_.Db())return wc(a);var b=a.match(_.bc);b=_.ac(null,null,null,null,b[5],b[6],b[7]);var c=_.J.location.toString(),d=_.dc(c);c=_.N(1,c);!c&&_.p.self&&_.p.self.location&&(c=_.p.self.location.protocol,c=c.substr(0,c.length-1));c=c?c.toLowerCase():"";"http"!=c&&"https"!=c&&(c="https",d=_.dc(a));return c+"://"+d+(b||"")};wc=function(a){var b=_.N(1,window.location.toString()),c=a.match(_.bc);return"http"===b||c[4]?a:_.ac("https",c[2],c[3],c[4],c[5],c[6],c[7])};yc=function(a){var b=_.dc(_.J.location.toString())||"",c=_.dc(a)||"";a=_.cc(_.N(5,a))||"";_.rc(.1,{id:"gmob-apps",event:"measure-fixclickurl-issues",success:b+":"+c+":"+a})};_.zc=function(a,b){var c=new window.XMLHttpRequest,d=!1,e=function(c,e){if(!d){d=!0;var f=function(a){a=a.match(_.bc);return _.ac(a[1],a[2],a[3],a[4],a[5])};_.Q({id:"gmob-apps",event:"click-server-ping",status:e,adUrlPrefix:f(window.location.toString()),clickUrlPrefix:f(a)});c?(e=_.O(c,"gclid"),_.Q({id:"gmob-apps",event:"gclid-status",success:!_.D(_.Ma(e))}),b(c,e)):b(null,null)}};yc(a);a=wc(a);a=_.uc(a,"rct","j");c.timeout=0;c.onload=function(){if(200==c.status&&c.responseText){var a=c.responseText.match(/URL='([^']*)'/);a&&1<a.length?e(a[1].replace(/&amp;/g,"&"),"ok"):e(null,"missing-landing-page")}else e(null,"http-fail")};c.onerror=function(){e(null,"error")};_.rc(.01,{id:"gmob-apps",event:"ajax-clickping-ping"});c.open("GET",a,!0);c.send()};_.Ac=function(a){if(!a)return!1;var b=_.N(1,a),c=_.dc(a);a=_.cc(_.N(5,a));return"market"==b||"market.android.com"==c||"play.google.com"==c&&("/store/apps/details"==a||"/store/apps/details/"==a)};Bc=function(a,b,c){var d=c.W;c=c.O;if(!d)return!1;var e=_.O(d,"adurl");if(e&&0!=e.length||!_.Ac(c))return!1;_.Zb(a);a=c;d=_.xc(d);c=new window.XMLHttpRequest;c.overrideMimeType("application/json");c.open("GET",d,!1);_.vc(c);d=String(c.responseText);if(!_.C(d,")]}'\n"))throw Error("Got JSON response without safety prefix: "+d);d=JSON.parse(d.substr(5)).referrer;c=_.O(a,"referrer");e=[];c&&e.push(c);d&&e.push(d);e.push("network=d");(d=e.join("&"))&&(a=_.P(a,"referrer",d));a=_.tc(a);_.K("Play store URL from Ad");a=_.Nb(a);_.Pb(b,a);return!0};var Cc=function(a,b,c,d){b=c(d,b);if(!(b instanceof Array))return a;(0,_.Fa)(b,function(b){if(2!==b.length&&3!==b.length)return a;a=Gb(a,b[0],b[1],"adurl",b[2])});return a};var Dc=function(a,b){this.l=a;this.D=b;this.A=[];this.o=[];this.C={};this.g={};this.B=this.v=!1},Ec=function(a,b,c){var d=b=b.getAttribute("data-original-click-url");if(d)for(var e=0;e<a.A.length;e++)d=Cc(d,b,a.A[e],c);return d},Fc=function(a){var b=_.P(a.href,"shc","1");b=_.P(b,"ri","13");window.navigator.sendBeacon(b,"");b=_.P(a.href,"ri","14");b=b instanceof _.Kb?b:Ob(b);a.href=_.Lb(b)},Gc=function(a,b,c,d){if(0!=a.o.length&&(d.preventDefault?!d.defaultPrevented:!1!==d.returnValue)){var e=1==d.which&&!d.ctrlKey&&"_blank"!=b.target&&"_new"!=b.target;e&&_.Zb(d);for(var f=[],g={},l=0;l<a.o.length;g={url:g.url},l++)if(g.url=a.o[l](c),g.url){var n=new window.Promise(function(a){return function(b){_.Ub(_.J,a.url,b)}}(g));f.push(n)}c=window.Promise.all(f);f=new window.Promise(function(a){window.setTimeout(a,2E3)});e&&window.Promise.race([c,f]).then((0,_.y)(Dc.prototype.G,a,b,d))}};Dc.prototype.G=function(a,b){this.v=!0;var c=!1;if(b.target)a:{c=b.target;var d=b.button,e=b.ctrlKey,f=b.shiftKey,g=b.metaKey,l=b.altKey,n=new Sb(b.x,b.y);if(window.document.createEvent){var q=window.document.createEvent("MouseEvents");q.initMouseEvent("click",!0,!0,null,0,n.g,n.l,n.g,n.l,e,l,f,g,d,null)}else if(window.document.createEventObject)q=window.document.createEventObject(),q.Na="onclick",q.button=d,q.ctrlKey=e,q.altKey=l,q.shiftKey=f,q.metaKey=g,q.clientX=n.g,q.clientY=n.l,q.screenX=n.g,q.screenY=n.l;else{c=!1;break a}if(c.dispatchEvent)c.dispatchEvent(q);else if(c.fireEvent)c.fireEvent(q.Na,q);else{c=!1;break a}c=!0}!a.href||c||Hc(this,a,b)||(_.J.top.location=a.href)};Dc.prototype.F=function(a,b,c,d){if(this.v)this.v=!1;else{d||(d=_.J.event);this.g[c][b].forEach(function(a){a(d)});if(a.href){var e=Ec(this,a,d.type);e&&(a.href=e)}"click"==c&&(_.m(this.l,36,!1)&&Fc(a),Gc(this,a,b,d),(d.preventDefault?d.defaultPrevented:!1===d.returnValue)||Hc(this,a,d))}};var Ic=function(a,b,c,d){a.g[d]||(a.g[d]={});a.g[d][c]||(a.g[d][c]=[]);_.L(b,d,(0,_.y)(a.F,a,b,c,d))},Hc=function(a,b,c){var d=b.href;if(a.D){if(a.D.g(b,c,a.l,a.B))return!0}else if(Bc(c,_.J.top.location,{W:d,O:_.m(a.l,15,"")}))return!0;if(_.m(a.l,31,!1)&&_.m(a.l,30,!1)&&_.m(a.l,28,"")){var e=_.m(a.l,32,"");_.Zb(c);_.zc(d,function(b,c){_.Q({id:"gmob-apps",event:"mgdn-app-click","gclid-generated":c?!0:!1,"reengagement-ping-tag":e});b=_.m(a.l,28,"");c=c?_.kc(b,"gclid",c):b;_.J.open(c,"_top")});return!0}return!1};var Jc;Jc=function(a){if(a.classList)return a.classList;a=a.className;return _.u(a)&&a.match(/\S+/g)||[]};_.Kc=function(a,b){a.classList?a.classList.add(b):(a.classList?a.classList.contains(b):0<=(0,_.Ea)(Jc(a),b))||(a.className+=0<a.className.length?" "+b:b)};_.Lc=function(a,b){if(a.classList)a.classList.remove(b);else if(a.classList?a.classList.contains(b):0<=(0,_.Ea)(Jc(a),b))a.className=Ga(Jc(a),function(a){return a!=b}).join(" ")};var Mc=function(a){_.p.setTimeout(function(){throw a;},0)},Nc,Oc=function(){var a=_.p.MessageChannel;"undefined"===typeof a&&"undefined"!==typeof window&&window.postMessage&&window.addEventListener&&!E("Presto")&&(a=function(){var a=window.document.createElement("IFRAME");a.style.display="none";a.src="";window.document.documentElement.appendChild(a);var b=a.contentWindow;a=b.document;a.open();a.write("");a.close();var c="callImmediate"+Math.random(),d="file:"==b.location.protocol?"*":b.location.protocol+"//"+b.location.host;a=(0,_.y)(function(a){if(("*"==d||a.origin==d)&&a.data==c)this.port1.onmessage()},this);b.addEventListener("message",a,!1);this.port1={};this.port2={postMessage:function(){b.postMessage(c,d)}}});if("undefined"!==typeof a&&!E("Trident")&&!E("MSIE")){var b=new a,c={},d=c;b.port1.onmessage=function(){if(_.t(c.next)){c=c.next;var a=c.za;c.za=null;a()}};return function(a){d.next={za:a};d=d.next;b.port2.postMessage(0)}}return"undefined"!==typeof window.document&&"onreadystatechange"in window.document.createElement("SCRIPT")?function(a){var b=window.document.createElement("SCRIPT");b.onreadystatechange=function(){b.onreadystatechange=null;b.parentNode.removeChild(b);b=null;a();a=null};window.document.documentElement.appendChild(b)}:function(a){_.p.setTimeout(a,0)}};var Pc=function(a,b){this.o=a;this.v=b;this.l=0;this.g=null};Pc.prototype.get=function(){if(0<this.l){this.l--;var a=this.g;this.g=a.next;a.next=null}else a=this.o();return a};var Qc=function(){this.l=this.g=null},Sc=new Pc(function(){return new Rc},function(a){a.reset()});Qc.prototype.add=function(a,b){var c=Sc.get();c.set(a,b);this.l?this.l.next=c:this.g=c;this.l=c};var Uc=function(){var a=Tc,b=null;a.g&&(b=a.g,a.g=a.g.next,a.g||(a.l=null),b.next=null);return b},Rc=function(){this.next=this.l=this.g=null};Rc.prototype.set=function(a,b){this.g=a;this.l=b;this.next=null};Rc.prototype.reset=function(){this.next=this.l=this.g=null};var Yc=function(a){Vc||Wc();Xc||(Vc(),Xc=!0);Tc.add(a,void 0)},Vc,Wc=function(){if(-1!=String(_.p.Promise).indexOf("[native code]")){var a=_.p.Promise.resolve(void 0);Vc=function(){a.then(Zc)}}else Vc=function(){var a=Zc;!_.Aa(_.p.setImmediate)||_.p.Window&&_.p.Window.prototype&&!E("Edge")&&_.p.Window.prototype.setImmediate==_.p.setImmediate?(Nc||(Nc=Oc()),Nc(a)):_.p.setImmediate(a)}},Xc=!1,Tc=new Qc,Zc=function(){for(var a;a=Uc();){try{a.g.call(a.l)}catch(c){Mc(c)}var b=Sc;b.v(a);100>b.l&&(b.l++,a.next=b.g,b.g=a)}Xc=!1};_.R=function(){this.A=this.A;this.o=this.o};_.R.prototype.A=!1;_.R.prototype.qa=ba(0);_.R.prototype.L=ba(2);_.$c=function(a){_.R.call(this);this.C=1;this.v=[];this.B=0;this.g=[];this.l={};this.F=!!a};_.B(_.$c,_.R);_.$c.prototype.subscribe=function(a,b,c){var d=this.l[a];d||(d=this.l[a]=[]);var e=this.C;this.g[e]=a;this.g[e+1]=b;this.g[e+2]=c;this.C=e+3;d.push(e);return e};_.$c.prototype.G=function(a){var b=this.g[a];b&&(b=this.l[b],0!=this.B?(this.v.push(a),this.g[a+1]=_.xa):(b&&_.Ia(b,a),delete this.g[a],delete this.g[a+1],delete this.g[a+2]))};_.$c.prototype.D=function(a,b){var c=this.l[a];if(c){for(var d=Array(arguments.length-1),e=1,f=arguments.length;e<f;e++)d[e-1]=arguments[e];if(this.F)for(e=0;e<c.length;e++){var g=c[e];ad(this.g[g+1],this.g[g+2],d)}else{this.B++;try{for(e=0,f=c.length;e<f;e++)g=c[e],this.g[g+1].apply(this.g[g+2],d)}finally{if(this.B--,0<this.v.length&&0==this.B)for(;c=this.v.pop();)this.G(c)}}}};var ad=function(a,b,c){Yc(function(){a.apply(b,c)})};_.$c.prototype.L=ba(1);var cd=function(a,b,c,d){this.v=new _.$c;this.l=a;this.l[0]=[b];this.A=[];this.o=new Dc(c,d);this.g=c;b=_.m(this.g,22,"");c=_.m(this.g,23,"");b&&c&&d&&(d.canOpenIntents([{url:b,id:b,K:c}],(0,_.y)(this.Fa,this))||d.canOpenURLs(b,(0,_.y)(this.Fa,this)));(d=_.M(1,"common_15click_anchor"))?(a[20]=[d],bd(this,20)):(d=_.Ja(_.$b(2,"common_15click_anchor")),0<d.length&&(a[20]=d,bd(this,20)))},bd,ed;_.h=cd.prototype;_.h.Fa=function(a,b){b=(a=_.m(this.g,22,""))&&b?b[a]:!1;this.o.B=!!b;this.H(0,"app_installed",!b)};_.h.navigationAdPieces=function(){return this.A};_.h.na=function(){return!0};_.h.has=function(a){return(a=this.l[a])&&0<a.length};_.h.listen=function(a,b,c){var d=this.l[a];if(d){var e=this.o;c=_.z(c,a,this);var f=("click"==b||"mousedown"==b)&&e.C[a];e.g[b]||(e.g[b]={});e.g[b][a]||(e.g[b][a]=[]);e.g[b][a].push(c);if(!f)for(a=0;a<d.length;a++)_.L(d[a],b,c)}};_.h.H=function(a,b,c){if(b){a=this.getElementsByAdPiece(a);for(var d=0;d<a.length;d++)c?_.Lc(a[d],b):_.Kc(a[d],b)}};_.h.getElementsByAdPiece=function(a){return this.l[a]?this.l[a]:[]};_.dd=function(a,b,c){a=a.getElementsByAdPiece(b);if(c)for(b=0;b<a.length;b++){var d=a[b].getAttribute(c);if(d)return d}return null};bd=function(a,b){if(a.l[b]&&a.na(b)){a.A.push(b);var c=a.o;a=a.l[b];for(var d=0;d<a.length;d++){var e=a[d];e.href&&e.setAttribute("data-original-click-url",e.href);Ic(c,e,b,"mousedown");Ic(c,e,b,"click")}c.C[b]=!0}};ed=function(a,b){a=a.getElementsByAdPiece(b);for(b=0;b<a.length;b++)if(!a[b].href)return!1;return!0};_.h=cd.prototype;_.h.creativeConversionUrl=function(){return _.m(this.g,6,"")};_.h.redirectUrl=function(){return _.m(this.g,8,"")};_.h.getIndex=function(){return _.m(this.g,2,0)};_.h.listenOnObject=function(a,b){this.v.subscribe(a,b)};_.h.fireOnObject=function(a,b){this.v.D(a,b)};var fd=function(a,b,c){c=void 0===c?{}:c;this.error=a;this.context=b.context;this.line=b.line||-1;this.msg=b.message||"";this.file=b.file||"";this.id=b.id||"jserror";this.meta=c};var gd=/^https?:\/\/(\w|-)+\.cdn\.ampproject\.(net|org)(\?|\/|$)/,hd=function(a,b){this.g=a;this.l=b},id=function(a,b){this.url=a;this.Ca=!!b;this.depth=null};var jd=function(){this.o="&";this.v=_.t(void 0)?void 0:"trn";this.A=!1;this.l={};this.B=0;this.g=[]},ld=function(a,b){var c={};c[a]=b;return[c]},nd=function(a,b,c,d,e){var f=[];Rb(a,function(a,l){(a=md(a,b,c,d,e))&&f.push(l+"="+a)});return f.join(b)},md=function(a,b,c,d,e){if(null==a)return"";b=b||"&";c=c||",$";"string"==typeof c&&(c=c.split(""));if(a instanceof Array){if(d=d||0,d<c.length){for(var f=[],g=0;g<a.length;g++)f.push(md(a[g],b,c,d+1,e));return f.join(c[d])}}else if("object"==typeof a)return e=e||0,2>e?(0,window.encodeURIComponent)(nd(a,b,c,d,e+1)):"...";return(0,window.encodeURIComponent)(String(a))},od=function(a,b,c,d){a.g.push(b);a.l[b]=ld(c,d)},qd=function(a,b,c,d){b=b+"//"+c+d;var e=pd(a)-d.length;if(0>e)return"";a.g.sort(function(a,b){return a-b});d=null;c="";for(var f=0;f<a.g.length;f++)for(var g=a.g[f],l=a.l[g],n=0;n<l.length;n++){if(!e){d=null==d?g:d;break}var q=nd(l[n],a.o,",$");if(q){q=c+q;if(e>=q.length){e-=q.length;b+=q;c=a.o;break}else a.A&&(c=e,q[c-1]==a.o&&--c,b+=q.substr(0,c),c=a.o,e=0);d=null==d?g:d}}f="";a.v&&null!=d&&(f=c+a.v+"="+d);return b+f},pd=function(a){if(!a.v)return 4E3;var b=1,c;for(c in a.l)b=c.length>b?c.length:b;return 4E3-a.v.length-b-a.o.length-1};var rd=function(a,b,c,d,e,f){if((d?a.A:Math.random())<(e||a.g))try{if(c instanceof jd)var g=c;else g=new jd,Rb(c,function(a,b){var c=g,d=c.B++;a=ld(b,a);c.g.push(d);c.l[d]=a});var l=qd(g,a.v,a.l,a.o+b+"&");l&&("undefined"===typeof f?_.Ub(_.p,l,void 0):_.Ub(_.p,l,f))}catch(n){}};var sd=null;var td=function(){var a=_.p.performance;return a&&a.now&&a.timing?Math.floor(a.now()+a.timing.navigationStart):(0,_.A)()},ud=function(){var a=void 0===a?_.p:a;return(a=a.performance)&&a.now?a.now():null};var vd=function(a,b,c){this.label=a;this.type=b;this.value=c;this.duration=0;this.uniqueId=this.label+"_"+this.type+"_"+Math.random();this.slotId=void 0};var S=_.p.performance,wd=!!(S&&S.mark&&S.measure&&S.clearMarks),xd=function(a){var b=!1,c;return function(){b||(c=a(),b=!0);return c}}(function(){var a;if(a=wd){var b;if(null===sd){sd="";try{a="";try{a=_.p.top.location.hash}catch(c){a=_.p.location.hash}a&&(sd=(b=a.match(/\bdeid=([\d,]+)/))?b[1]:"")}catch(c){}}b=sd;a=!!b.indexOf&&0<=b.indexOf("1337")}return a}),zd=function(){var a=yd;this.events=[];this.l=a||_.p;var b=null;a&&(a.google_js_reporting_queue=a.google_js_reporting_queue||[],this.events=a.google_js_reporting_queue,b=a.google_measure_js_timing);this.g=xd()||(null!=b?b:1>Math.random())},Ad=function(a){a&&S&&xd()&&(S.clearMarks("goog_"+a.uniqueId+"_start"),S.clearMarks("goog_"+a.uniqueId+"_end"))};zd.prototype.start=function(a,b){if(!this.g)return null;var c=ud()||td();a=new vd(a,b,c);b="goog_"+a.uniqueId+"_start";S&&xd()&&S.mark(b);return a};var Dd=function(){var a=Bd;this.o=Cd;this.v=this.l;this.g=void 0===a?null:a},Gd;Dd.prototype.pinger=function(){return this.o};Gd=function(a,b,c){try{if(a.g&&a.g.g){var d=a.g.start(b.toString(),3);var e=c();var f=a.g;c=d;if(f.g&&"number"==typeof c.value){var g=ud()||td();c.duration=g-c.value;var l="goog_"+c.uniqueId+"_end";S&&xd()&&S.mark(l);f.g&&f.events.push(c)}}else e=c()}catch(n){f=!0;try{Ad(d),f=a.v.call(a,b,new Ed(Fd(n),n.fileName,n.lineNumber),void 0,void 0)}catch(q){a.l(217,q)}if(!f)throw n;}return e};_.Id=function(a,b,c){var d=Hd;return function(e){for(var f=[],g=0;g<arguments.length;++g)f[g]=arguments[g];return Gd(d,a,function(){return b.apply(c,f)})}};Dd.prototype.l=function(a,b,c,d,e){e=e||"jserror";try{var f=new jd;f.A=!0;od(f,1,"context",a);b.error&&b.meta&&b.id||(b=new Ed(Fd(b),b.fileName,b.lineNumber));b.msg&&od(f,2,"msg",b.msg.substring(0,512));b.file&&od(f,3,"file",b.file);0<b.line&&od(f,4,"line",b.line);var g=b.meta||{};if(d)try{d(g)}catch(kd){}b=[g];f.g.push(5);f.l[5]=b;g=_.p;b=[];var l=null;do{d=g;if(Qb(d)){var n=d.location.href;l=d.document&&d.document.referrer||null}else n=l,l=null;b.push(new id(n||""));try{g=d.parent}catch(kd){g=null}}while(g&&d!=g);n=0;for(var q=b.length-1;n<=q;++n)b[n].depth=q-n;d=_.p;if(d.location&&d.location.ancestorOrigins&&d.location.ancestorOrigins.length==b.length-1)for(n=1;n<b.length;++n){var v=b[n];v.url||(v.url=d.location.ancestorOrigins[n-1]||"",v.Ca=!0)}var r=new id(_.p.location.href,!1);q=null;var x=b.length-1;for(v=x;0<=v;--v){var I=b[v];!q&&gd.test(I.url)&&(q=I);if(I.url&&!I.Ca){r=I;break}}I=null;var Yg=b.length&&b[x].url;0!=r.depth&&Yg&&(I=b[x]);var Ca=new hd(r,I);Ca.l&&od(f,6,"top",Ca.l.url||"");od(f,7,"url",Ca.g.url||"");rd(this.o,e,f,!1,c)}catch(kd){try{rd(this.o,e,{context:"ecmserr",rctx:a,msg:Fd(kd),url:Ca&&Ca.g.url},!1,c)}catch(qj){}}return!0};var Fd=function(a){var b=a.toString();a.name&&-1==b.indexOf(a.name)&&(b+=": "+a.name);a.message&&-1==b.indexOf(a.message)&&(b+=": "+a.message);if(a.stack){a=a.stack;var c=b;try{-1==a.indexOf(c)&&(a=c+"\n"+a);for(var d;a!=d;)d=a,a=a.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/,"$1");b=a.replace(/\n */g,"\n")}catch(e){b=c}}return b},Ed=function(a,b,c){fd.call(this,Error(a),{message:a,file:void 0===b?"":b,line:void 0===c?-1:c})};wa(Ed,fd);var Cd,Hd;if(Xb&&!Qb(Yb)){var Jd="."+_.H.domain;try{for(;2<Jd.split(".").length&&!Qb(Yb);)_.H.domain=Jd=Jd.substr(Jd.indexOf(".")+1),Yb=window.parent}catch(a){}Qb(Yb)||(Yb=window)}var yd=Yb,Bd=new zd,Kd=function(){if(!yd.google_measure_js_timing){var a=Bd;a.g=!1;a.events!=a.l.google_js_reporting_queue&&(xd()&&(0,_.Fa)(a.events,Ad),a.events.length=0)}};Cd=new function(){var a=void 0===a?_.J:a;this.v="http:"===a.location.protocol?"http:":"https:";this.l="pagead2.googlesyndication.com";this.o="/pagead/gen_204?id=";this.g=.01;this.A=Math.random()};Hd=new Dd;"complete"==yd.document.readyState?Kd():Bd.g&&_.L(yd,"load",function(){Kd()});_.Ld=function(a,b,c){rd(Cd,a,b,"jserror"!=a,c,void 0)};var T,Md;T=function(a){this.F=new _.$c;this.A=null;this.B="none";this.A&&(this.B=this.A.style.display);this.v=[];this.g=a;this.C=[];this.D=!1;this.l=[];this.o=null};Md=function(a){a=new T(new vb(a));_.w("adSlot",a,void 0);return a};_.Nd=function(){var a=_.p.adSlot;return a?a:(Hd.l("hdrNDslt",Error("no adslot"),void 0,void 0),Md(null))};_.h=T.prototype;_.h.forEachAd=function(a){(0,_.Fa)(this.v,a)};_.h.oa=function(a){this.v.push(a)};_.h.Oa=function(a){if(a=_.M(1,a))this.A=a,this.B=this.A.style.display;if(0==this.v.length)_.p.css=null;else{for(a=0;a<this.C.length;++a)this.C[a]();this.D=!0}};_.h.listenOnObject=function(a,b){this.F.subscribe(a,b)};_.h.fireOnObject=function(a,b){b.Yb=this;this.F.D(a,b)};_.h.registerFinalizeCallback=function(a){this.D?a():this.C.push(a)};_.h.registerWidget=function(a,b){0<=(0,_.Ea)(this.l,a)||(this.l[b]=a,a.reset(this))};var Od=function(a){a.A.style.display="none";for(var b=0;b<a.l.length;b++)a.l[b]&&a.l[b].hide(a)};T.prototype.resetAll=function(){this.A.style.display=this.B;for(var a=0;a<this.l.length;a++)this.l[a]&&this.l[a].reset(this)};T.prototype.showOnly=function(a){var b=this;Od(this);Pd(this,a,function(a){a.show(b)})};var Pd=function(a,b,c){a.l[b]&&c(a.l[b])};T.prototype.getSerializedAdSlotData=function(){return _.tb(this.g)};T.prototype.getAdsLength=function(){return this.v.length};T.prototype.getAd=function(a){return 0<=a&&a<this.v.length&&this.v[a].getIndex()==a?this.v[a]:null};T.prototype.openSystemBrowser=function(a){return this.o?(this.o.openSystemBrowser(a,{useFirstPackage:!0,useRunningProcess:!0}),!0):!1};var Rd=function(a,b,c){cd.call(this,a,b,c,_.Nd().o);for(a=0;a<Qd.length;a++)bd(this,Qd[a])};wa(Rd,cd);var Sd=function(a,b){var c=U,d={};if(!b)return null;d[0]=[b];Wb(Eb,function(a){c[a]&&(d[a]=_.Ja(_.$b(2,c[a],b)))});return new Rd(d,b,a)};Rd.prototype.na=function(a){return ed(this,a)||4==a};var Td=function(a){_.m(a,19,!1)&&(0,_.Fa)(rb(a,20),function(a){_.Ub(_.J,a,void 0)})};Rd.prototype.B=function(a,b){return this.na(b)?a:""};var Qd=[1,2,3,4,8,6,40,24,33,25,36,37,38,9];var Ud="UNKNOWN",Vd="UNKNOWN",Wd=null,Xd=function(a,b){b.gqid=Ud;b.qqid=Vd;b.com=a;_.Ld("glaurung",b)},V={},U=(V[1]="ad-title",V[2]="ad-url",V[3]="ad-body",V[4]="ad-button",V[8]="ad-favicon",V[6]="ad-image",V[26]="ad-price",V[23]="ad-reviews",V[43]="ad-rating-stars",V[44]="ad-reviews-count",V[24]="ad-app-store-image",V[25]="ad-promo-headline",V[33]="ad-app-icon",V[16]="ad-image-gallery",V[40]="ad-image-gallery-image",V[36]="ad-logo",V[37]="ad-advertiser",V[38]="ad-call-to-action",V[39]="ad-video",V[42]="ad-logo-wrapper",V[9]="ad-background",V),Yd=function(a,b,c){var d=a.g,e=_.k(d,ca,16);if(e&&_.m(e,1,!1)){e=U;for(var f in e)delete e[f];U[1]="title-link";U[2]="url-link";U[3]="body-link";U[4]="button-link";U[8]="favicon-link";U[6]="image-link";U[26]="price";U[23]="reviews";U[43]="rating-stars";U[44]="reviews-count";U[24]="app-store";U[25]="promo-headline";U[33]="app-icon";U[16]="image-gallery";U[40]="image-gallery-image-link";U[36]="logo-link";U[37]="advertiser-link";U[38]="call-to-action-link";U[39]="video";U[42]="logo";U[9]="ad-background";_.M(2,"app-store-link",b)&&(U[24]="app-store-link");_.M(2,"app-icon-link",b)&&(U[33]="app-icon-link");_.M(2,"promo-headline-link",b)&&(U[25]="promo-headline-link")}f=_.M(1,"adunit",b);e=_.M(1,"ads",b);if(!f||!e)return 1;var g={};0==_.m(d,32,0)?(g.width=_.m(d,2,0)+"px",g.height=_.m(d,3,0)+"px",g.position="absolute",g.top="0",g.left="0"):(g.width="100%",g.height="100%");g.overflow="hidden";da(f,g);ea(f,d);ea(e,d);try{c(e,a)}catch(q){return _.m(d,13,!1)&&(Wd=q),2}c=0;d=xb(d);for(f=0;f<d.length;f++){g=d[f];var l="taw"+_.m(g,2,0);e=_.M(1,l,b);if(!e)return 3;e=Sd(g,e);if(!e)return 1;_.J.registerAd?_.J.registerAd(e,l):c=4;_.m(g,11,!1)&&_.J.initAppPromo&&_.J.initAppPromo(e,a);Td(g);if(_.m(g,19,!1))if(l=rb(g,33),0<l.length)for(g=0;g<l.length;g++){var n=(0,_.y)(Rd.prototype.B,e,l[g]);e.o.o.push(n)}else g=(0,_.y)(Rd.prototype.B,e,_.m(g,21,"")),e.o.o.push(g);a.oa(e)}return c};var Zd=function(a,b,c){var d=[];d[0]=[c];d[15]=[b];(b=_.M(1,"abgc"))&&(d[27]=[b]);(b=_.M(1,"cbc"))&&(d[28]=[b]);cd.call(this,d,c,a,_.Nd().o);bd(this,15)};wa(Zd,cd);var $d=function(a,b){var c={};c[0]=[b];cd.call(this,c,b,a,_.Nd().o)};wa($d,cd);var be=function(a,b,c){cd.call(this,a,b,c,_.Nd().o);for(a=0;a<ae.length;a++)bd(this,ae[a]);this.listen(4,"mouseover",(0,_.y)(this.H,this,0,"onhoverbg",!1));this.listen(4,"mouseout",(0,_.y)(this.H,this,0,"onhoverbg",!0))};wa(be,cd);be.prototype.na=function(a){return ed(this,a)||4==a};var W={},ce=(W[1]="rhtitle",W[45]="rhtitleline1",W[46]="rhtitleline2",W[48]="rhlongtitle",W[3]="rhbody",W[2]="rhurl",W[4]="rhbutton",W[8]="rhfavicon",W[14]="rhaddress",W[6]="rhimage",W[34]="rhimagetemplate",W[49]="rh-scrollflow",W[16]="rhimagegallery",W[47]="rhreviewgallery",W[29]="rhviewimagegallery",W[30]="rhcloseimagegalleryview",W[31]="rhtrydemobutton",W[32]="rhclosetrydemoview",W[39]="rhvideo",W[9]="rhbackground",W[13]="rh-icore-empty",W[5]="rhsitelink",W[7]="rhradlink",W[17]="rh-multiframe",W[18]="rh-box-breadcrumbs",W[21]="rh-ms-mute-overlay",W[22]="rh-ms-mute-undo",W[23]="rhstarratings",W[24]="rhstoreicon",W[25]="rhpromotext",W[26]="rhprice",W[27]="abgc",W[28]="cbc",W[35]="rhdemocountdowntimer",W[36]="rhlogo",W[1001]="rhoverlap-imagegallery",W[1002]="rhoverlap-trydemo",W),ae=[1,45,46,48,2,4,5,7,8,3,9,6,14,15,34,26,24,36];T.prototype.forEachAd=T.prototype.forEachAd;T.prototype.addAd=T.prototype.oa;T.prototype.finalize=T.prototype.Oa;_.w("buildAdSlot",Md,void 0);_.w("buildGlaurungAds",function(a,b,c){var d=(new Date).getTime(),e=1,f=!1;Wd=null;try{f=_.m(a.g,13,!1),Ud=_.m(a.g,8,""),Vd=_.m(a.g,7,""),e=Yd(a,b,c)}catch(g){f&&(Wd=g),e=1}a=(new Date).getTime();b={};b.r=e;b.d=a-d;Xd("bridge",b);return e},void 0);_.w("glaurungError",function(){return Wd},void 0);_.w("glaurungBridge.log",Xd,void 0);_.w("glaurungBridge.getAdPieceClassName",function(a){return U[a]},void 0);_.w("buildImageAd",function(a,b){if(0>b||b>=xb(a.g).length)a=null;else{a=xb(a.g)[b];b=_.M(1,"google_image_div");var c=_.M(1,"aw0");a=b&&c?new Zd(a,c,b):null}return a},void 0);_.w("buildRichmediaAd",function(a,b){return 0>b||b>=xb(a.g).length?null:new $d(xb(a.g)[b],_.H.body)},void 0);_.w("buildTextAd",function(a,b){var c=a.g;if(!(0>b||b>=xb(c).length)){if(0>b||b>=xb(a.g).length)var d=null;else{d=xb(a.g)[b];var e=_.M(1,"taw"+b);if(e){var f={0:[e]},g;for(g in Eb){var l=Eb[g],n=ce[l];n&&(f[l]=_.Ja(_.$b(2,n,e)))}d=new be(f,e,d)}else d=null}d&&(_.J.registerAd&&_.J.registerAd(d,"taw"+b),a.oa(d),_.m(xb(c)[b],11,!1)&&_.J.initAppPromo&&_.J.initAppPromo(d,a))}},void 0);})(window.hydra=window.hydra||{});
