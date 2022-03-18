let app = new Vue({
    el: '#app',
    data: {
        academias: [],
        academia: {},
        clase: {},
        clases: [],
        ciudades: [],
        alumnos: [],
        modalContacto: false,
        modalContacto: false,
        formEnviado: false,
        detalleClase: false,
    },
    mounted() {
        // axios.get('https://infra.datos.gob.ar/catalog/modernizacion/dataset/7/distribution/7.3/download/departamentos.json', headers: {
        //         "Access-Control-Allow-Headers": "Content-Type",
        //         "Access-Control-Allow-Origin": "https://www.example.com/",
        //         "Access-Control-Allow-Methods": "OPTIONS,POST,GET"
        //     })
        //     .then(response => {
        //         console.log(response.data);
        //     })
        this.cargarClases();
        this.cargarAcademias();

    },
    methods: {
        abrirContacto() {
            pagina = document.querySelector(".contenedor-total");
            if (this.modalContacto == false) {
                pagina.classList.add('desenfocar');
                this.modalContacto = true;
            } else {
                pagina.classList.remove('desenfocar');
                this.modalContacto = false;

            }
        },
        cargarAcademias() {
            axios.get("/api/academias")
                .then(response => {
                    app.academias = response.data;
                })
        },
        cargarClases() {
            axios.get("/api/clases")
                .then(response => {
                    app.clases = response.data;
                })
        },
        enviarFormulario() {
            pagina = document.querySelector(".contenedor-total");
            this.formEnviado = true;
            this.modalContacto = false;
            pagina.classList.add('desenfocar');
        },
        cerrar() {
            pagina = document.querySelector(".contenedor-total");
            this.formEnviado = false;
            pagina.classList.remove('desenfocar');
        },
        abrirClase() {
            pagina = document.querySelector(".contenedor-total");
            pagina.classList.add('desenfocar');
            this.detalleClase = true;
            console.log("entro clase");
        },
        cerrarClase() {
            pagina = document.querySelector(".contenedor-total");
            pagina.classList.remove('desenfocar');
            this.detalleClase = false;
        },
        elegirClase(clase) {
            app.clase = app.clases[clase - 1];
            app.alumnos = app.clase.usuarios;
            app.academia = app.academias[app.clase.academiaId - 1];
        }
    },
})