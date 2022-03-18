let app = new Vue({
    el: '#app',
    data: {
        clases: [],
        ciudades: [],
        modalContacto: false,
        modalContacto: false,
        formEnviado: false,
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
        app.cargarClases();

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
        cargarClases() {
            axios.get("/api/clases")
                .then(response => {
                    console.log(response);
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
        }
    },
})