let app = new Vue({
    el: '#app',
    data: {
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

    },
    created() {
        this.loadData()
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
<<<<<<< HEAD
                .then(response => {
                    console.log(response.data);
                    this.usuario = response.data
                    console.log(this.usuario.nombre)
                })
=======
            .then(response => {
                console.log(response.data);
                this.usuario = response.data

                if(this.usuario.foto != ""){
                    this.noFoto = false
                    this.fotoPerfil = true
                }
                if(this.usuario.foto == ""){
                    this.noFoto = true
                    this.fotoPerfil = false
                }

                console.log(this.usuario.nombre)
            })
>>>>>>> 3186f2f1308cf52b2f2d85a015d8977946859ff0
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
<<<<<<< HEAD
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
=======
        editarInfo(){
            axios.patch("/api/usuarios/current",
            {"nombre": this.cambio.nombre, "apellido": this.cambio.apellido, 
            "fechaNacimiento": this.cambio.nacimiento, "descripcion": this.cambio.descripcion,
            "foto": this.cambio.foto, "ciudad": this.cambio.ciudad,
            "telefono": this.cambio.telefono})
            .then(()=> {
                console.log("Cambios realizados")
                
                window.location.reload()
            })
            .catch(error => console.log(error))
>>>>>>> 3186f2f1308cf52b2f2d85a015d8977946859ff0
        }
    },
})