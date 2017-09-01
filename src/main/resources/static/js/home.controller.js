(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', '$rootScope'];
    function HomeController(UserService, $rootScope) {
        var vm = this;

        vm.user = null;
        vm.allUsers = [];
        vm.allCourses = [];
        vm.myCourses=[];
        vm.deleteUser = deleteUser;

        initController();

        function initController() {
            loadCurrentUser();
            loadAllUsers();
            loadAllCourses();
            loadMyCourses();
        }

        function loadCurrentUser() {
            UserService.GetByUsername($rootScope.globals.currentUser.username)
                .then(function (user) {
                    vm.user = user;
                });
        }

        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }

        function loadAllCourses() {
            UserService.GetAllCourses()
                .then(function (courses) {
                    vm.allCourses = courses;
                });
        }

        function loadMyCourses() {
            UserService.GetMyCourses($rootScope.globals.currentUser.username)
                .then(function (courses) {
                    vm.myCourses = courses;
                });
        }

        function deleteUser(id) {
            UserService.Delete(id)
                .then(function () {
                    loadAllUsers();
                });
        }
    }
})();