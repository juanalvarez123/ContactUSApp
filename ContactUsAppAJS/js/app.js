var myApp = angular.module('myApp', []);

var url = 'http://localhost:8081/WS/rest/wsContactUs/';
myApp.factory('myAppFactory', function ($http) {
    return {
        consultarMedios: function (estado) {
            return $http.get(url + 'consultarMedios/' + estado);
        },
        registrarContacto: function (contacto) {
        	return $http.post(url + 'registrarContacto', contacto);
        }
    };
});

myApp.config(['$httpProvider', function($httpProvider) {
	$httpProvider.defaults.headers.put = {
	        'Access-Control-Allow-Origin': '*',
	        'Access-Control-Allow-Methods': 'GET, POST, PUT',
	        'Access-Control-Allow-Headers': '*'
	        };
	}
]);

myApp.controller('formController', ['$scope', 'myAppFactory', '$http', function ($scope, myAppFactory, $http) {
	
	myAppFactory.consultarMedios(1).success(function (data) {
        $scope.lstMedios = data;
    })
    .error(function (data) {
        console.log(data.ExceptionMessage);
    })
	
	$scope.onlyLetters = /^[a-zA-Z]+$/;
	$scope.onlyNumbers = /^[0-9]+$/;
	$scope.websitePattern = /./;

	$scope.submitForm = function(isValid) {
		if (isValid) { 	
			var medio = {
				idMedio: $('#selectMedio').val(), 
				descripcion: null,
				estado: null
			}
		    var contacto = {
				nombres: $('#name').val(),
				apellidos: $('#lastName').val(),
				email: $('#email').val(),
				telefono: $('#telephone').val(),
				pais: $('#country').val(),
				medio: medio,
				comentarios: $('#comments').val(),
				respuesta: null,
				url: $('#webSite').val(),
				nombreCompleto: null
		    }
		    myAppFactory.registrarContacto(contacto).success(function (data) {
		    	if(data == true) {
		    		alert('Your request has been sent. Thank you !!!');
		    		 location.reload();
		    	} else {
		    		alert('Error saving information. Contact the web page administrator.');
		    	}		    		
		    }).error(function (data) {
		        console.log(error.ExceptionMessage);
		    });		
		}
	};

}]);

myApp.controller("listController", function($scope, $http, $location) {
	///$scope.names = {};
	$scope.lstContactos = {};
	
	//$http.get("http://www.w3schools.com/angular/customers.php")
	$http.get(url + "consultarContactos")
	.success(
		function (response) {
			///$scope.names = response.records;
			$scope.lstContactos = response;
		}
	).error(
		function (response) {
			alert("Falla");
		}
	);

	$scope.go = function(path, event){
		alert('regresar ' + path);
		$location.path( path );
		alert('regresar ' + path);
	}

});