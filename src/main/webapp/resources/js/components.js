$(document).ready(function() {
	/**
	 * Header Animation Starts
	 */
	/*$(window).scroll(function() {
		if($('.page-header-top').height() <= this.document.body.scrollTop) {
			$('.sticky-wrapper').height('100px');
			$('.sticky-wrapper>.sticky-menu').addClass('scrolling');
		} else {
			$('.sticky-wrapper').height('auto');
			$('.sticky-wrapper>.sticky-menu').removeClass('scrolling');
		}
	});*/
	/** Header Animation Ends **/
	
	
	/**
	 * tutorial tab switching start
	 */
	$("body").on("click", ".tabs-btn", function() {
		var idBtn = ($(this).attr("data-tabs-id"));
		var f = $(".tabs [data-tabs-id=cont-"+idBtn+"]");
		$(f).addClass("active").siblings(".container-tabs").removeClass('active');
		$(".container-tabs").fadeOut( 0 );
		$(".container-tabs.active").fadeIn( 300 );
		$(this).addClass("active").siblings(".tabs-btn").removeClass('active');
	});
	/** tutorial tab switching end **/
});

function runSlider(selector) {
	var sliderContainer = document.querySelector(selector);
	var slideElements = sliderContainer.querySelectorAll(".slider-item");
	var sliderContainerWidth = slideElements.length * slideElements[0].offsetWidth;
	for(var i=0; i<slideElements.length; i++) {
		slideElements[i].style.width = slideElements[0].offsetWidth + 'px';
	}
	sliderContainer.style.width = sliderContainerWidth+'px';
	var slidingCount = 0;
	window.setInterval(function() {
		slidingCount++;
		sliderContainer.style.left = '-' + (slidingCount * slideElements[0].offsetWidth) + 'px';
		if(slidingCount == slideElements.length-1) {
			slidingCount = 0;
		}
	}, 5000 || sliderContainer.getAttribute('duration'));
	
	window.onresize = function() {
		runSlider(selector);
	};
}