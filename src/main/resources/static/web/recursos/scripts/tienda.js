let app = new Vue({
    el: '#app',
    data: {
        estilo: "",
        tipo: "",
        productos: [],
        productoId: 0,
        filtroProductos: [],
        carrito: [],
        stock: 0,
        total: 0,
        abrirProducto: false,
        modalCarrito: false,
        modalContacto: false,
        formEnviado: false,
        datosPago: false,
        descripcion: "",
        pago: {
            tarjeta: "",
            cvv: 0
        }
    },
    created() {
        this.loadProductos()
    },
    mounted() {
        pagina = document.querySelector(".contenedor-total");
        indu = document.querySelector(".btn-ind");
        calz = document.querySelector(".btn-calz");
    },
    methods: {
        loadProductos() {
            axios.get("/api/productos")
                .then(response => this.productos = response.data)
        },
        formatoPrecio(number){
            if(number != undefined){
                let balance = number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
                return balance;
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

        },
        verProducto(id) {

            pagina.classList.add('desenfocar');
            this.abrirProducto = true;

            this.productoId = this.productos.filter(producto => producto.id == id)
            this.productoId = this.productoId[0]
        },
        volver() {

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
<<<<<<< HEAD
            if (app.stock <= app.productoId.stock) {
                for (let i = 0; i < app.stock; i++) {
=======
            if(app.stock <= app.productoId.stock && app.stock > 0){
                for(let i = 0; i < app.stock ; i++){
>>>>>>> 3186f2f1308cf52b2f2d85a015d8977946859ff0
                    app.carrito.push(app.productoId);
                    app.total += app.productoId.precio;
                }
                app.productoId.stock -= app.stock;
                console.log(app.carrito);
            }
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
        comprar() {
            this.descripcion = "Gracias por su compra";

            axios.post("http://localhost:8060/api/payments", { "amount": this.total, "productosTransaccion": this.productos, "numberCard": this.pago.tarjeta, "cvv": this.pago.cvv, "description": app.descripcion })
                .then(response => {
                    console.log("Compra realizada")
                    window.location.href = "/web/perfil.html";
                })
                .catch(error => console.log(error))
        },
        enviarFormulario() {
            this.formEnviado = true;
            this.modalContacto = false;
            pagina.classList.add('desenfocar');
        },
        cerrar() {
            this.formEnviado = false;
            pagina.classList.remove('desenfocar');
        }
    },

})

/**RESTRINGIR CVV A 3 DIGITOS*****/
var input = document.getElementById('cvv');
input.addEventListener('input', function() {
    if (this.value.length > 3)
        this.value = this.value.slice(0, 3);
})