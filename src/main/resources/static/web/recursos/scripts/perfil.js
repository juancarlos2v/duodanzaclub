let app = new Vue({
    el: '#app',
    data: {
        suscripciones: "",
        suscriptions: "",
        suscripcionSelected: "",
        usuario: {},
        fotoPerfil: false,
        noFoto: true,
        cambio: {
            nombre: "",
            apellido: "",
            nacimiento: "",
            email: "",
            ciudad: "",
            telefono: "",
            contraseña: "",
            descripcion: "",
            foto: ""
        },
        clase: {
            cantidadClases: 0,
            modoPago: "",
            precioFinal: 0,
        },
        editarPerfil: false,
        modalContacto: false,
        formEnviado: false,
        modalIngreso: false,
        modalRegistro: false,
        id: ""

    },
    created() {
        this.loadData()
        this.getSuscripciones()
        
    },
    
    mounted() {
        pagina = document.querySelector(".contenedor-total");
        s = document.querySelector(".suelta");
        m = document.querySelector(".mensual");
        t = document.querySelector(".trimestral");
    },
    methods: {
        loadData() {
            axios.get("/api/usuarios/current")
                
                .then(response => {
                    console.log(response.data);
                    this.usuario = response.data

                    if (this.usuario.foto != "") {
                        this.noFoto = false
                        this.fotoPerfil = true
                    }
                    if (this.usuario.foto == "") {
                        this.noFoto = true
                        this.fotoPerfil = false
                    }

                    console.log(this.usuario.nombre)
                })
        },
        getSuscripciones(){
            axios.get("/api/suscripciones")
            .then(response => {
                this.suscripciones = response.data
            })
            .catch(error => console.log(error))
        },
        cerrarSesion() {
            axios.post("/api/logout")
                .then(response => {
                    window.location.href = "/web/index.html"
                })
        },
        clickSuelta() {
            s.classList.add('abono-activo');
            m.classList.remove('abono-activo');
            t.classList.remove('abono-activo');
            console.log('entro');
        },
        clickMensual() {
            s.classList.remove("abono-activo");
            m.classList.add("abono-activo");
            t.classList.remove("abono-activo");
            console.log('entro mensual');
        },
        clickTrimestral() {
            s.classList.remove("abono-activo");
            m.classList.remove("abono-activo");
            t.classList.add("abono-activo");
            console.log('entro trimestral');
        },
        clickEditar() {
            if (this.editarPerfil == false) {
                this.editarPerfil = true;
                pagina.classList.add('desenfocar');
            } else {
                this.editarPerfil = false;
                pagina.classList.remove('desenfocar');
            }
        },
        confirmarCambios() {

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
        mostrarSuscripcion(){
            this.suscripcionSelected = this.suscripciones.filter(suscripcion => {
               return suscripcion.id = this.suscriptions
            })
        },
        enviarFormulario() {
            this.formEnviado = true;
            this.modalContacto = false;
            pagina.classList.add('desenfocar');
        },
        cerrar() {
            this.formEnviado = false;
            pagina.classList.remove('desenfocar');
        },
        editarInfo() {
            axios.patch("/api/usuarios/current", {
                    "nombre": this.usuario.nombre,
                    "apellido": this.usuario.apellido,
                    "fechaNacimiento": this.usuario.nacimiento,
                    "descripcion": this.usuario.descripcion,
                    "foto": this.usuario.foto,
                    "ciudad": this.usuario.ciudad,
                    "telefono": this.usuario.telefono
                })
                .then(() => {
                    console.log("Cambios realizados")

                    window.location.reload()
                })
                .catch(error => console.log(error))
        },
        abrirRegistro() {
            this.modalRegistro = true;
        },
        suscribirse(){
            
            axios.patch("/api/usuarios/current/suscripciones/", `id=${this.id}`)
            .then(response => console.log(response))
            .catch(error => console.log(error))
        }
    }
})