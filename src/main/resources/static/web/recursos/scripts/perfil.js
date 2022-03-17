let app = new Vue({
    el: '#app',
    data: {
        usuario: {},
        cambio: {
            nombre: "",
            apellido: "",
            nacimiento: "",
            email: "",
            ciudad: "",
            telefono: "",
            contraseña: ""
        },
        clase: {
            cantidadClases: 0,
            modoPago: "",
            precioFinal: 0,
        },
        editarPerfil: false,
    },
    created(){
        this.loadData()
    },
    mounted() {
        pagina = document.querySelector(".contenedor-total");
        s = document.querySelector(".suelta");
        m = document.querySelector(".mensual");
        t = document.querySelector(".trimestral");
    },
    methods: {
        loadData(){
            axios.get("/api/usuarios/current")
            .then(response => {
                console.log(response.data);
                this.usuario = response.data
                console.log(this.usuario.nombre)
            })
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

        }
    },
})