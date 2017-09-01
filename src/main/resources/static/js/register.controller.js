(function () {
    'use strict';

    angular
        .module('app')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function RegisterController(UserService, $location, $rootScope, FlashService) {
        var vm = this;

        vm.register = register;

        function register() {
            vm.dataLoading = true;

            UserService.GetByUsername(vm.user.username)
                .then(function (responseUser) {
                    if (!responseUser.username){
                        UserService.Create(vm.user)
                            .then(function (response) {
                                    FlashService.Success('Registration successful', true);
                                    $location.path('/login');
                            })
                    } else {
                        FlashService.Error('Username already exists');
                        vm.dataLoading = false;
                    }
                    
                });

           ;
        }
    }

})();