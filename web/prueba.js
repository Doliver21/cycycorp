var app=angular.module("app",[]);

function EntidadBancariaController($scope, $http){
    var response = $http({
        method: "GET",
        url: contextPath+"/api/EntidadBancaria/"+getParameterByName('idEntidadBancaria')
        
    });

    response.success(function(data, status, headers, config) {
        $scope.entidadBancaria = data;
    });

$scope.deleteEntidad = function(idEntidad){
     var response = $http({
        method: "DELETE",
        url: contextPath+"/api/EntidadBancaria/"+idEntidad
     });
    response.success(function(data,status, headers,config){
        alert("Se ha borrado corrrectamente");
       
    }).error(function (data,status,headers,config){
        alert("no Existe o no se pudo borrar");
    });
};
$scope.buscarEntidad = function(idEntidad){
     var response = $http({
        method: "GET",
        url: contextPath+"/api/EntidadBancaria/"+idEntidad
        
    });
    response.success(function(data,status, headers,config){
        $scope.entidadBancaria= data;
       
    }).error(function (data,status,headers,config){
        alert("No existe o no se pudo encontrar: "+idEntidad);
    });

};
$scope.modificarEntidad= function(idEntidad , codigoEntidad,nombre){
     var response = $http({
        method: "PUT",
        url:  contextPath+"/api/EntidadBancaria/"+idEntidad+"&&nombreEntidad="+nombre+"&&codigoEntidad="+codigoEntidad
        
     });
    response.success(function(data,status, headers,config){
        alert("Se ha modificado corrrectamente");
       
    }).error(function (data,status,headers,config){
        alert("no se pudo modificar o no existe");
    });
};
$scope.insertarEntidad= function(idEntidad , codigoEntidad,nombre){
     var response = $http({
        method: "POST",
        url:  contextPath+"/api/EntidadBancaria/"+idEntidad+"&&nombreEntidad="+nombre+"&&codigoEntidad="+codigoEntidad
     });
    response.success(function(data,status, headers,config){
        alert("Se ha insertado corrrectamente");
       
    }).error(function (data,status,headers,config){
        alert("no se pudo insertar la entidad");
    });
};
    $scope.mostrarTablaEntidad = function(){
    var response = $http({
        method: "GET",
        url: contextPath+"/api/EntidadesBancarias/"
    });
    response.success(function(data,status,headers,config){
        alert("Se muestra tabla");
        
    }).error(function(data,status,headers,config){
        alert("Error no se muestra nada");
    });
};
    
}
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
var prodId = getParameterByName('prodId');
