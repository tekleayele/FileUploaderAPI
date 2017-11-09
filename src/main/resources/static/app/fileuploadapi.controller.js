(function() {
	'use strict';

	angular.module('app').controller('FileUploaderWSController', FileUploaderWSController);

	function FileUploaderWSController($http, $scope, $location, $window) {
		var vm = this;
		vm.fileMetaDataInfos = [];
		vm.getAll = getAll;
		vm.searchFile = searchFile;
		vm.deleteFile = deleteFile;
		init();

		function init() {
			getAll();
		}

		function getAll() {
			var url = "/FileUploaderAPI/all";
			var fileMetaDataInfosPromise = $http.get(url);
			fileMetaDataInfosPromise.then(function(response) {
				vm.fileMetaDataInfos = response.data;
			});
		}
		
		function searchFile(search) {
			var url = "/FileUploaderAPI/search/" + search;
			if (search) {
				console.log("posting data....");
				console.log(search);
				var bookingsPromise = $http.get(url);
				bookingsPromise.then(function(response) {
					if (response.data) {
						vm.fileMetaDataInfos = response.data;
					} else {
						vm.fileMetaDataInfos = init();
					}
				});
			} else {
				vm.fileMetaDataInfos = init();
			}
		}
		
		function deleteFile(id) {
			var url = "/FileUploaderAPI/delete/" + id;
			$http.post(url).then(function(response) {
				vm.fileMetaDataInfos = response.data;
			});
		}
	}
})();