let app = new Vue({
    el: '#app',
    data: {
        // abriProducto: false,
        // modalContacto: false,
        estilo: "",
        academias: "",
        academia: "",
        logueado: false,
        ingreso: {
            usuario: "",
            contraseña: ""
        },
        modalIngreso: false,
        modalContacto: false,
        formEnviado: false,
        festivales: "",
        festivalesActuales: ""
        



    },
    created() {
        this.loadData()
        this.loadAcademia()
    },
    mounted() {
        pagina = document.querySelector(".contenedor-total");

    },
    methods: {
        abrirCarrito() {

        },
        abrirContacto() {
            if (this.modalContacto == false) {
                pagina.classList.add('desenfocar');
                this.modalContacto = true;
            } else {
                pagina.classList.remove('desenfocar');
                this.modalContacto = false;

            }
        },
        abrirModal() {
            if(app.logueado == false){
                axios.get("/api/usuarios/current")
                .then(response => {
                    if(response.data != null){
                        app.logueado = true;
                        window.location.href = "/web/perfil.html";
                    }
                })
            }
            if (this.modalIngreso == false) {
                this.modalIngreso = true;
                pagina.classList.add('desenfocar');
            } else {
                this.modalIngreso = false;
                pagina.classList.remove('desenfocar');
            }
        },
        loadAcademia() {
            axios.get("http://localhost:8090/api/academias")
                .then(response => {
                    console.log(response.data)
                    this.academias = response.data
                })
                .catch(error => console.log(error))
        },
        loadData() {
            axios.get("http://localhost:8090/api/festivales")
                .then(response => {
                    console.log(response.data)
                    
                    this.festivales = response.data
                    this.festivalesActuales = response.data
                    
                    console.log(this.festivales);
                })
                
                .catch(error => console.log(error))
        },
        filtrar(){
            console.log("CLICK");
            if(this.academia != "") {
                this.festivales = this.festivales.map(festival => {
                    festival.academia == this.academia
                })
            }
            if(this.estilo != "") {
               this.festivalesActuales = this.festivales.filter(festival => {
                   return festival.estilo == this.estilo
                })
            }
            
        },
        mostrar(){
           return this.festivalesActuales = this.festivales
        },
        /*comprar(id){
            axios.post()
        },*/
        

        ingresar() {
            axios.post('/api/login', `email=${this.ingreso.usuario}&password=${this.ingreso.contraseña}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {
                    window.location.href = "/web/perfil.html"
                })
                .catch(response => {
                    console.log(response.data);
                })
        },
        abrirModal() {
            if (this.modalIngreso == false) {
                this.modalIngreso = true;
                pagina.classList.add('desenfocar');
            } else {
                this.modalIngreso = false;
                pagina.classList.remove('desenfocar');
            }
        },
        cerrarModal() {
            this.modalIngreso = false;
        },
        
        abrirContacto() {
            if (this.modalContacto == false) {
                pagina.classList.add('desenfocar');
                this.modalContacto = true;
            } else {
                pagina.classList.remove('desenfocar');
                this.modalContacto = false
            }
        },
        enviarFormulario() {
            this.formEnviado = true;
            this.modalContacto = false;
            pagina.classList.add('desenfocar');
        },
        cerrar() {
            this.formEnviado = false;
            pagina.classList.remove('desenfocar');
        }
    }

})