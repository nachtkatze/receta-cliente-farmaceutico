function AppViewModel() {
    self = this;
    this.firstName = "Bert";
    this.lastName = "Bertington";
    self.pagina = ko.observable('menu');
    self.formu = function(){
        self.pagina('formulario');
    }
}
  $(document).ready(function() {
    ko.applyBindings(new AppViewModel());
});      


