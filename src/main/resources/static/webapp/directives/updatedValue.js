angular.module("myStockList").directive("updatedValue", function() {
	return {
		restrict : "AE",
		templateUrl : function(element, arg) {

			return '/webapp/template/updatedValue' + arg.type + '.html';

		}
	};

});