var app = angular.module("myStockList");
app.controller("myCtrl", function($scope, $http) {

	$http.get("/stockdetail").then(function(response) {
		$scope.products = response.data;
	});

	$scope.addItem = function() {
		$scope.errortext = "";
		if (!$scope.addMe) {
			return;
		}
		if ($scope.products.indexOf($scope.addMe) == -1) {

			var data = {'stockName': $scope.addMe};
			
			var config = {
					 params: data
					};
			
			$http.get('/isvalidstock',config).then(function(response) {
				$scope.stock = response.data;
				$scope.products.push($scope.stock);
				$http.post("/addstock",$scope.stock);
			});
		} else {
			$scope.errortext = "The stock is already in your list.";
		}
	}
	$scope.removeItem = function(x) {
		$scope.errortext = "";
	
		$http.post('/deletestock',$scope.products[x]);	
		
		$scope.products.splice(x, 1);
	}
});