let app = new Vue({
    el: '#app',
    data: {
        estilo: "",
        tipo: "",
        productos: [],
        filtroProductos: [],
        carrito: [],
        abrirProducto: false,
        modalCarrito: false,
        modalContacto: false,
    },
    mounted() {
        pagina = document.querySelector(".contenedor-total");
        indu = document.querySelector(".btn-ind");
        calz = document.querySelector(".btn-calz");
    },
    methods: {
        verProducto() {
            if (this.abrirProducto == false) {
                pagina.classList.add('desenfocar');
                this.abrirProducto = true;
            } else {
                pagina.classList.remove('desenfocar');
                this.abrirProducto = false;
            }
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
        abrirCarrito() {
            if (this.modalCarrito == false) {
                this.abrirProducto = false;
                this.modalCarrito = true;
            } else {
                this.modalCarrito = false;
                pagina.classList.remove('desenfocar');
            }
        },
        elegirEstilo(estilo) {
            this.estilo = estilo;
        },
        elegirTipo(tipo) {
            this.tipo = tipo;
            if (tipo == 'indumentaria') {
                indu.classList.add('linea-seleccion');
                calz.classList.remove('linea-seleccion');
            }
            if (tipo == 'calzado') {
                indu.classList.remove('linea-seleccion');
                calz.classList.add('linea-seleccion');
            }

        }

    },
})