let app = new Vue({
    el: '#app',
    data: {
        estilo: "",
        tipo: "",
        productos: [],
        productoId: 0,
        filtroProductos: [],
        carrito: [],
        abrirProducto: false,
        modalCarrito: false,
        modalContacto: false,
        datosPago: false,
        pago: {
            tarjeta: 0,
            cvv: 0
        }
    },
    created(){
        this.loadProductos()
    },
    mounted() {
        pagina = document.querySelector(".contenedor-total");
        indu = document.querySelector(".btn-ind");
        calz = document.querySelector(".btn-calz");
    },
    methods: {
        loadProductos(){
            axios.get("/api/productos")
            .then(response => this.productos = response.data)
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

        },
        verProducto(id) {
            
                pagina.classList.add('desenfocar');
                this.abrirProducto = true;
            
            this.productoId = this.productos.filter(producto => producto.id == id)
            this.productoId = this.productoId[0]
        },
        volver(){
            
                pagina.classList.remove('desenfocar');
                this.abrirProducto = false;
            
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
        agregarProducto() {

        },
        irPago() {
            this.datosPago = true;
        },
        pagar() {
            axios.post('/api/..', `nombre=${this.pago.tarjeta}&apellido=${this.pago.cvv}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                .then(response => {

                })
                .catch(error => {
                    console.log(error.data);
                })
        },
        comprar(){
            axios.post("/api/comprar",
            {"amount": this.amount, "productosTransaccion": this.productos})
            .then(console.log("Compra realizada"))
            .catch(error => console.log(error))
        }
    },

})

/**RESTRINGIR CVV A 3 DIGITOS*****/
var input = document.getElementById('cvv');
input.addEventListener('input', function() {
    if (this.value.length > 3)
        this.value = this.value.slice(0, 3);
})