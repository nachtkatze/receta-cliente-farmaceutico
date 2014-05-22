function AppViewModel() {
	// Variables knockout
	self = this;
	self.folders = [ 'Home', 'Client', 'Log In' ]
	self.pagina = ko.observable('home');
	self.tsi = ko.observable(' ');
	self.valid = ko.observable(true);
	self.farmaceutico = ko.observable('Oscar Scrum Master');
	self.farmacia = ko.observable('Farmacia ISST');
	self.medicamento = ko.observable('Parecetamol');
	self.importe = ko.observable("€");
	self.formasPago = ko.observableArray([ 'Efectivo', 'Tarjeta' ]);
	self.pago = ko.observable();
	
	self.recetasSeleccionadas = ko.observableArray();
	self.offset = ko.computed(function() {
        return parseInt(self.recetasSeleccionadas());
    }, this);


//	self.availableMeals = [
//	   			        { mealName: "Standard (sandwich)", price: 0 },
//	   			        { mealName: "Premium (lobster)", price: 34.95 },
//	   			        { mealName: "Ultimate (whole zebra)", price: 290 }
//	   			    ]; 
	self.recetas = ko.observableArray([]);

	//self.seats().push(new SeatReservation("Steve", self.availableMeals[0]));
	
	// Variables globales
	var date = new Date();
	$('#today').html(
			date.getDate() + '/' + date.getMonth() + '/' + date.getFullYear());

	// Redirección
	self.trampa = function() {
		self.valid(true);
	}
	self.formu = function() {
		if (self.valid() == true) {
			self.pagina('formulario');
			self.tsi("");
			return;
		} else {
			alert("Debe iniciar sesión");
			self.logIn();
			return;
		}
	}
	self.logIn = function() {
		if (self.valid() == false) {
			self.pagina('login');
			$("#username").val("");
			$("#password").val("");
		}
	}
	self.logOut = function() {
		if (self.valid() == true) {
			self.valid(false);
			self.pagina('home');
		}
	}
	self.home = function() {
		self.pagina('home');
	}
	self.listaCliente = function() {
		$.unblockUI(); 
		var tsiPaciente = self.tsi();
		$.ajax({
			type : 'get',
			url : "http://strauss.gsi.dit.upm.es:8080/isst/recetas?pacienteID="+tsiPaciente,
			data : {},
			contentType : 'application/json; charset=ISO-8859-1',
			success : function(allDatos) {
				self.recetas([]);
				console.log('alldatos');
				console.log(allDatos);
				if(allDatos['numeroRecetas'] == 0) {
					$('#tabla').hide();
					$('#noRecetas').show();
					return;
				}
				var recetasJSON = allDatos['recetas'];
				var recetasMostradas = 0;
				for (var i = 0; i < recetasJSON.length; i++) {
					console.log(recetasJSON[i]['expedido'])
					if(recetasJSON[i]['expedido']) {continue;}
					self.recetas.push(new RecetaCreation(recetasJSON[i]['nombreMedicamento'], recetasJSON[i]['fechaExpedicion'],
							recetasJSON[i]['nombrePaciente'], recetasJSON[i]['tarjetaSS'], recetasJSON[i]['posologia'],
							recetasJSON[i]['id']));
					recetasMostradas++;
				}
				if(recetasMostradas == 0){
					$('#tabla').hide(); 
					$('#noRecetas').show();
					console.log("No hay recetas para mostrar")
				} else {
					$('#tabla').show()
					$('#noRecetas').hide();
				}
				
			},
			error : function(jqXHR, exception) {
				console.log(exception);
				console.log("ERROR");
			}
		});
		self.pagina('listaCliente');
		self.importe("€");
		self.recetasSeleccionadas("0");
	}
	
	self.expedir = function() {
		console.log("Medicamento expedido");
		$.ajax({
			type : 'get',
			url : "http://strauss.gsi.dit.upm.es:8080/isst/recetas?recetaID="+
			self.recetas()[self.offset()].recetaId+"&opcion=modificar",
			data : {},
			contentType : 'application/json; charset=ISO-8859-1',
			success : function(allDatos) {
				self.recetas([]);
				console.log('alldatos');
				console.log(allDatos);
			},
			error : function(jqXHR, exception) {
				console.log(exception);
				console.log("ERROR");
			}
		});
		self.recetasSeleccionadas("0");
		$.blockUI({message: "Espere..."})
		window.setTimeout(self.listaCliente, 1000);
		
	}
	
	self.otraReceta = function() {
	}
	
	self.resumen = function() {
		self.pagina('resumen');
		self.importe("€")
	};
	self.loginAccept = function() {
		console.log("Aceptado");
	}

	// Metodos extras
	self.validate = function() {
		var user = $("#username").val();
		var pw = $("#password").val();

		// Lo más cutre del mundo
		var userArray = [ "f1", "f2", "f3", "f4" ]; // usernames
		var pwArray = [ "f1", "f2", "f3", "f4" ]; // the corresponding
		// passwords;

		for (var i = 0; i < userArray.length; i++) {
			if ((user == userArray[i]) && (pw == pwArray[i])) {
				self.valid(true);
				self.pagina('home');
				console.log(self.valid());
				return;
			}
		}
		alert("Usuario y/o contraseña erroneas. Por favor, vuelva a intentarlo.");
		$("#username").val("");
		$("#password").val("");
		console.log(self.valid());
		return;
	}
	
	ko.computed(function(){
		var input = self.tsi();
		var isInt = true;
		for(n in input) {
			if (!parseInt(input[n]) && (!(parseInt(input[n]) == 0))) {
				isInt = false;
				break;
			}
		}
		if (!isInt) {
			$('#botonRecetas').prop("disabled", true);
			$('#errorInput').show();
		} else {
			$('#botonRecetas').prop("disabled", false);
			$('#errorInput').hide();
		}
	}, this);
	
	$('#clienteInput').keyup(function () {
		self.tsi($('#clienteInput').val());
	});

}
$(document).ready(function() {
	ko.applyBindings(new AppViewModel());
});
function RecetaCreation(nombre, fecha, paciente, tarjetaSS, posologia, recetaId) {
    var self = this;
    self.nombre = nombre;
    self.fecha = fecha;
    self.paciente = paciente;
    self.tarjetaSS = tarjetaSS;
    self.posologia = posologia;
    self.recetaId = recetaId;
}
