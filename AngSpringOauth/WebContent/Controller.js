var app=angular.module("myApp",[]);

app.factory("httpreqInterceptor",function($q,$location){
	return {
		request:function(req){
			console.log('inside request interceptor ',req);
			return req;
		},
		response:function(response){
			var defer=$q.defer();
			console.log('inside response interceptor ',response);
			defer.resolve(response);
			return defer.promise;
		},
	
		responseError:function(response){
			var defer=$q.defer();
			console.log("response location ",response.config.headers);
			console.log('inside response interceptor error ',response);
			if(response.status==302){
				defer.reject(response);
				window.location=response.data;
			}
			else{
				defer.resolve(response);
			}
			return response;
		}
	};
});

app.config(function($httpProvider){
	$httpProvider.interceptors.push('httpreqInterceptor');
});

app.controller("oauthController",function($scope,$http){
	
	$scope.init=function(){
		console.log('inside init function');
	};
	
	$scope.googleLogin=function(){
		console.log('inside google login function');
		$http.get('rest/googleLogin').then(function(res){
			console.log("login service called ",res);
		},function(error){
			console.log('error while calling login service');
		});
	};
	
	$scope.init();
});