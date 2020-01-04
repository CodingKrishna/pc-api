var a = [ '', 'one ', 'two ', 'three ', 'four ', 'five ', 'six ', 'seven ', 'eight ', 'nine ', 'ten ', 'eleven ', 'twelve ', 'thirteen ', 'fourteen ', 'fifteen ', 'sixteen ', 'seventeen ', 'eighteen ', 'nineteen ' ];
var b = [ '', '', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety' ];

Array.prototype.add = function(key) {
    var sum = 0, i;
    if(key === undefined) {
        for(i=0; i<this.length; i++) {
            sum += parseFloat(this[i]);
        }
    } else {
        for(i=0; i<this.length; i++) {
            sum += parseFloat(this[i][key]); 
        }
    }
    return sum;
};

Array.prototype.addNonBlanks = function(key) {
    var sum= 0;
    var i = this.length;
    if(key) {
        while (i--) {
            if(parseFloat(this[i][key]))
                sum += parseFloat(this[i][key]);
        }
    } else {
        while (i--) {
            if(parseFloat(this[i]))
                sum += parseFloat(this[i]);
        }
    }
    return sum;
};

Array.prototype.search = function(key, value) {
    for(var i=0; i<this.length; i++) {
        if(this[i][key] == value) {
            return this[i];
        }
    }
};
Array.prototype.getObjByKeyVal = function(key, val) {
	var i = this.length;
	while (i--) {
		if(this[i][key] == val)
			return this[i];
	}
};
Array.prototype.getIndexByKeyVal = function(key, val) {
	var i = this.length;
	while (i--) {
		if(this[i][key] == val)
			return i;
	}
};
String.prototype.toTextString = function(number) {
    return number.parseInt(number).toTextString();
};

Number.prototype.toTextString = function() {
    var num = Math.round(this.valueOf());
    n = ('000000000' + num).substr(-9).match(
        /^(\d{2})(\d{2})(\d{2})(\d{1})(\d{2})$/);
    if (!n)
        return;
    else if(num == 0) {
        return "zero rupees only";
    }
    var str = '';
    str += (n[1] != 0) ? (a[Number(n[1])] || b[n[1][0]] + ' ' + a[n[1][1]]) + 'crore ' : '';
    str += (n[2] != 0) ? (a[Number(n[2])] || b[n[2][0]] + ' ' + a[n[2][1]]) + 'lakh ' : '';
    str += (n[3] != 0) ? (a[Number(n[3])] || b[n[3][0]] + ' ' + a[n[3][1]]) + 'thousand ' : '';
    str += (n[4] != 0) ? (a[Number(n[4])] || b[n[4][0]] + ' ' + a[n[4][1]]) + 'hundred ' : '';
    str += (n[5] != 0) ? ((str != '') ? 'and ' : '') + (a[Number(n[5])] || b[n[5][0]] + ' ' + a[n[5][1]]) + '' : '';
    return str + ' rupees only';
};

String.prototype.leadingZeros = function(length) {
    return parseInt(this).leadingZeros(length);
};
Number.prototype.leadingZeros = function(length) {
    var zero = length - this.valueOf().toString().length + 1;
    return Array(+(zero > 0 && zero)).join("0") + this.valueOf();
};

function isEmpty(val) {
	return val === null || val === undefined || val === '' || val === '{}';
}

function fileToBase64(file) {
	return new Promise(function (resolve, reject) {
		var reader = new FileReader();
		reader.onload = function () {
			resolve(reader.result);
		};
		reader.onerror = function (error) {
			reject(error);
		};
		reader.readAsDataURL(file);
	});
}

(function scrollHandler() {
	function scrollTo(element, to, duration) {
		var start = element.scrollTop,
		change = to - start,
		currentTime = 0,
		increment = 20;

		var animateScroll = function() {
			currentTime += increment;
			var val = easeInOutQuad(currentTime, start, change, duration);
			element.scrollTop = val;
			if(currentTime < duration) {
				setTimeout(animateScroll, increment);
			}
		};
		animateScroll();
	}

	function easeInOutQuad(t, b, c, d) {
		t /= d/2;
		if (t < 1) return c/2*t*t + b;
		t--;
		return -c/2 * (t*(t-2) - 1) + b;
	};
	window.scrollAnimate = scrollTo;
})(window);

window.onscroll = function() {
	if(document.querySelector('.scroll-up')) {
		if(document.body.scrollTop > window.innerHeight) {
			document.querySelector('.scroll-up').style.display = 'block';
		} else {
			document.querySelector('.scroll-up').style.display = 'none';
		}
	}
};

function dateToStr(date){
	if(date) {
		return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
	} else {
		return '';
	}
};