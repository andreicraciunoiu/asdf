( function () {

    'user strict';

    angular
        .module('app')
        .controller('EditUsersController', EditUsersController);

    EditUsersController.$inject = ['$scope', '$http'];

    function EditUsersController($scope, $http) {
        console.log("In myController...");

        $scope.newUser = {};
        $scope.clickedUser = {};
        $scope.message = "";

        $scope.getUsers = function () {
            $http.get('http://localhost:8080/usersrole')
                .success(function (data, status, headers, config) {
                    $scope.users = data;
                })
                .error(function (error, status, headers, config) {
                    console.log(status);
                    console.log("Error occured");
                });
        }
        $scope.getUsers();

        $scope.saveUser = function () {
            //$scope.users.push($scope.newUser);

            var dataObj = {
                username: $scope.newUser.user.username,
                firstName: $scope.newUser.user.firstName,
                lastName: $scope.newUser.user.firstName,
                email: $scope.newUser.user.email,
                password: $scope.newUser.user.password,
                tags: $scope.newUser.user.tags,
                enabled: 1
            }

            console.log(dataObj)

            var page = 'http://localhost:8080/user/' + $scope.newUser.role;
            var res = $http.post(page, dataObj);
            res.success(function (data, status, headers, config) {
                $scope.message = data;
            });
            res.error(function (data, status, headers, config) {
                alert("failure message: " + JSON.stringify({data: data}));
            });
            $scope.newUser = {};
        };

        $scope.selectUser = function (user) {
            console.log(user);
            $scope.clickedUser = user;
        };

        $scope.updateUser = function () {
            $scope.message = "User updated successfully!";

            var dataObj = {
                username: $scope.clickedUser.user.username,
                firstName: $scope.clickedUser.user.firstName,
                lastName: $scope.clickedUser.user.firstName,
                email: $scope.clickedUser.user.email,
                password: $scope.clickedUser.user.password,
                tags: $scope.clickedUser.user.tags,
                enabled: 1
            }

            console.log(dataObj)

            var page = 'http://localhost:8080/user/' + $scope.clickedUser.user.id + '/' + $scope.clickedUser.role;
            var res = $http.put(page, dataObj);
            res.success(function (data, status, headers, config) {
                $scope.message = data;
            });
            res.error(function (data, status, headers, config) {
                alert("failure message: " + JSON.stringify({data: data}));
            });


        };

        $scope.removeUser = function () {
            $scope.users.splice($scope.users.indexOf($scope.clickedUser), 1);
            $scope.message = "User deleted successfully!";

            var dataObj = {
                username: $scope.clickedUser.user.username,
                firstName: $scope.clickedUser.user.firstName,
                lastName: $scope.clickedUser.user.firstName,
                email: $scope.clickedUser.user.email,
                password: $scope.clickedUser.user.password,
                tags: $scope.clickedUser.user.tags,
                enabled: 1
            }

            console.log(dataObj)

            var page = 'http://localhost:8080/user/' + $scope.clickedUser.user.id;
            var res = $http.delete(page, dataObj);
            res.success(function (data, status, headers, config) {
                $scope.message = data;
            });
            res.error(function (data, status, headers, config) {
                alert("failure message: " + JSON.stringify({data: data}));
            });
        }

        $scope.clearMessage = function () {
            $scope.message = "";
        }
    }

})();