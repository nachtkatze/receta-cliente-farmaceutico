function AppViewModel() {
    //Variables knockout
   	self = this;
   	self.folders = ['Home','Client','Log In']
    self.pagina = ko.observable('home');
    self.tsi = ko.observable(' ');
    self.valid = ko.observable(false);

    //Variables globales
    var date = new Date();
    $('#today').html(date.getDate() + '/' + date.getMonth() + '/' + date.getFullYear());
    var count = 2; 
    //var valid = false;

   
    //Redirección
    self.formu = function(){
      if(self.valid()==true){
        self.pagina('formulario');
        return;
      }
      else{
        alert("Debe iniciar sesión");
        self.logIn();
        return;
      }
    }
    self.logIn = function(){
      if(self.valid()==false){
      	self.pagina('login');
        $("#username").val("");
        $("#password").val("");
      }
      else{
        self.valid() = false;
        self.pagina('home');
      }
    }
    self.home = function(){
    	self.pagina('home');
    }
   self.listaCliente = function(){
      self.pagina('listaCliente');
    }
    self.resumen = function(){
      //añadir condiciones tsi
      self.pagina('resumen');
    };
    self.loginAccept = function(){
      console.log("Aceptado");
    }

    //Metodos extras
    self.validate = function(){
      var user = $("#username").val();
      var pw = $("#password").val();

      //Lo más cutre del mundo
      var userArray =  ["f1", "f2", "f3", "f4"];  // usernames
      var pwArray = ["f1", "f2", "f3", "f4"];  // the corresponding passwords;
      
      for(var i=0; i<userArray.length; i++){
        if((user== userArray[i]) && (pw == pwArray[i])){
          self.valid(true);
          alert("Login successful!");
          self.pagina('home');
          console.log(valid);
          return;
        }
      }
      alert("Wrong username and/or password. Please try again");
      $("#username").val("");
      $("#password").val("");
      console.log(valid);
      return;  
    }
 

}
  $(document).ready(function() {
    ko.applyBindings(new AppViewModel());
});      


