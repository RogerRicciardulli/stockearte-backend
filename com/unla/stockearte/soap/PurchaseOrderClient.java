import com.unla.stockearte.soap.PurchaseOrderService;
import com.unla.stockearte.soap.PurchaseOrderPortType;
import com.unla.stockearte.soap.GetPurchaseOrdersRequest;
import com.unla.stockearte.soap.GetPurchaseOrdersResponse;

public class PurchaseOrderClient {

    public static void main(String[] args) {
        try {
            System.out.println("Llego la peticion!: " + order.getId());
            // Create a service object using the generated class
            PurchaseOrderService service = new PurchaseOrderService();

            // Get the port for the service interface (PurchaseOrderPortType)
            PurchaseOrderPortType port = service.getPurchaseOrderPort();

            // Create a request object
            GetPurchaseOrdersRequest request = new GetPurchaseOrdersRequest();
            request.setId(0);  // Setting 0 to get all orders

            // Invoke the SOAP operation
            GetPurchaseOrdersResponse response = port.getPurchaseOrders(request);

            // Process the response
            response.getPurchaseOrders().forEach(order -> {
                System.out.println("Order ID: " + order.getId());
                System.out.println("Estado: " + order.getEstado());
                System.out.println("Observaciones: " + order.getObservaciones());
                // Print other details as needed...
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
