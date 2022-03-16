let app = new Vue({
    el: '#app',
    data: {
        abriProducto: false,
        modalContacto: false,
    },
    mounted() {
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
        }
    },
})