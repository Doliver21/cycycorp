var app=angular.module("app",[]);

function EntidadBancariaListController($scope, $http){
    $http({
        method: "GET",
        url: contextPath+"/api/EntidadesBancarias/"
    }).success(function(data, status, headers, config) {
        $scope.entidadesBancarias = data;
    });
    
    
    
    
    $scope.mostrarTablaEntidad = function(){
    var response = $http({
        method: "GET",
        url: contextPath+"/api/EntidadesBancarias/"
    }).success(function(data,status,headers,config){
                $scope.entidadesBancarias= data;
        alert("Se muestra tabla");
        
    }).error(function(data,status,headers,config){
        alert("Error no se muestra nada");
    });
};
}

