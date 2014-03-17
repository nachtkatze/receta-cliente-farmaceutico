function AppViewModel() {
    //Variables knockout
   	self = this;
   	self.folders = ['Home','Client','Log In']
    self.pagina = ko.observable('home');
    self.tsi = ko.observable(' ');
    self.valid = ko.observable(false);
    self.farmaceutico = ko.observable('Óscar Scrum Master');
    self.farmacia = ko.observable('Farmacia X');
    self.medicamento = ko.observable('Parecetamol');
    self.importe = ko.observable("€");
    self.formasPago = ko.observableArray(['Efectivo','Tarjeta']);
    self.pago = ko.observable();



    //Variables globales
    var date = new Date();
    $('#today').html(date.getDate() + '/' + date.getMonth() + '/' + date.getFullYear());
       
    //Redirección
    self.trampa=function(){
      self.valid(true);
    }
    self.formu = function(){
      if(self.valid()==true){
        self.pagina('formulario');
        self.tsi("");
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
    }
    self.logOut = function(){
      if(self.valid()==true){
        self.valid(false);
        self.pagina('home');
      }
    }
    self.home = function(){
    	self.pagina('home');
    }
   self.listaCliente = function(){
      //Añadir condiciones tsi =13
      self.pagina('listaCliente');
      self.importe("€");
    }
    self.resumen = function(){
      self.pagina('resumen');
      self.importe("€")
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
          self.pagina('home');
          console.log(valid);
          return;
        }
      }
      alert("Usuario y/o contraseña erroneas. Por favor, vuelva a intentarlo.");
      $("#username").val("");
      $("#password").val("");
      console.log(valid);
      return;  
    }
 

}
  $(document).ready(function() {
    ko.applyBindings(new AppViewModel());
});      


