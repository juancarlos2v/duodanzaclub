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
        ingresar() {
            axios.post('http://localhost:8090/api/login', `email=${this.ingreso.usuario}&password=${this.ingreso.contraseña}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {
                    window.location.href = "/web/perfil.html"
                })
                .catch(response => {
                    console.log(response.data);
                })
        }
    },
})