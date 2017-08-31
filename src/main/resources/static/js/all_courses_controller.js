var myApp = angular.module("myApp", []);

myApp.controller("myController", ['$scope', '$http', function($scope, $http){
	console.log("In myController...");

	$scope.newCourse ={};
	$scope.clickedCourse={};
	$scope.message="";

	$http.get("http://localhost:8080/courses")
        .then(function(response) {
            $scope.courses = response.data;
        });

    var getTrainers = function(course) {
        var trainers = [];
        $http.get("http://localhost:8080/trainers/course/"+course.id)
            .then(function(response) {
                trainers = response.data;
        });
        console.log(trainers + " " + course.id);
        return trainers;
    }

    angular.forEach($scope.courses, function(course){
                  getTrainers(course).then(function(trainers){
                     course.trainers = trainers;
                  });
               });


    var isValidDate2 = function(s) {
      var bits = s.split('/');
      var y = bits[2],
        m = bits[1],
        d = bits[0];
      // Assume not leap year by default (note zero index for Jan)
      var daysInMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

      // If evenly divisible by 4 and not evenly divisible by 100,
      // or is evenly divisible by 400, then a leap year
      if ((!(y % 4) && y % 100) || !(y % 400)) {
        daysInMonth[1] = 29;
      }
      return !(/\D/.test(String(d))) && d > 0 && d <= daysInMonth[--m]
    }

	$scope.saveCourse= function(){
		$scope.courses.push($scope.newCourse);
		$scope.newCourse={};
		$scope.message="New user added successfully!";
	};

	$scope.selectCourse = function(course){
		console.log(course);
		$scope.clickedCourse = course;
	};

	$scope.updateCourse = function(){
		$scope.message="User updated successfully!";
	};

	$scope.removeCourse = function(){
		$scope.courses.splice($scope.courses.indexOf($scope.clickedCourse), 1);
		$scope.message="User deleted successfully!";
	}

	$scope.clearMessage = function(){
		$scope.message="";
	}
}]);
