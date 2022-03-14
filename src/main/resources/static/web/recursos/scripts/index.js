let app = new Vue({
    el: '#app',
    data: {
        ingreso: {
            usuario: "",
            contraseña: ""
        },
        modalIngreso: false
    },
    mounted() {
        pagina = document.querySelector(".contenedor-total");
    },
    methods: {
        abrirModal() {
            if (!this.modalIngreso) {
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
        ingresar() {
            axios.post('/api/login', `email=${this.ingreso.usuario}&password=${this.ingreso.contraseña}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {
                    console.log('ingreso');
                })
                .catch(response => {
                    console.log(response.data);
                })
        }
    },
})