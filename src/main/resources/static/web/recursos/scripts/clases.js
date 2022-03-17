let app = new Vue({
    el: '#app',
    data: {
        clases: [],
        ciudades: [],
        modalContacto: false,
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
        pagina = document.querySelector(".contenedor-total");
    },
    methods: {
        abrirContacto() {
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
        }
    },
})