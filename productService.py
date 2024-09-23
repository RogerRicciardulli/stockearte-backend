import grpc
from flask import Flask, render_template, request
import product_pb2
import product_pb2_grpc


@app.route('/api/send', methods=['GET', 'POST'])
def create_user():
    message = ""
    if request.method == 'POST':
        data = request.json  # Cambiado para obtener JSON
        if not data or 'nombre' not in data or 'talle' not in data or 'foto' not in data or 'color' not in data:
            return {"error": "Datos inválidos. Se requieren nombre, talle, foto y color."}, 400

        nombre = data['nombre']
        talle = data['talle']
        foto = data['foto']
        color = data['color']

        # Establece la conexión con el servidor gRPC
        with grpc.insecure_channel('localhost:6565') as channel:
            stub = product_pb2_grpc.ProductServiceStub(channel)

            # Crea la solicitud
            request_data = product_pb2.Product(
                nombre=nombre,
                talle=talle,
                foto=foto,
                color=color
            )

            # Llama al método gRPC
            response = stub.CreateProduct(request_data)

            # Muestra la respuesta
            if response.success:
                message = "Producto creado exitosamente: "
            else:
                message = "Error al crear producto: " + response.message

            return {"success": response.success, "message": message}

    return {"error": "Método no permitido"}, 405  # Para GET
