package com.unla.stockearte.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import com.unla.stockearte.repository.entity.FiltersModel;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.stockearte_backend.CreateFiltersModelRequest;
import com.stockearte_backend.CreateFiltersModelResponse;
import com.stockearte_backend.DeleteFiltersModelRequest;
import com.stockearte_backend.DeleteFiltersModelResponse;
import com.stockearte_backend.UpdateFiltersModelRequest;
import com.stockearte_backend.UpdateFiltersModelResponse;
import com.unla.stockearte.services.FiltersServiceLogic;

@Endpoint
public class FiltersEndpoint {
	
	private static final String NAMESPACE_URI = "http://stockearte-backend.com/";

    @Autowired
    private FiltersServiceLogic filtersService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createFiltersModelRequest")
    @ResponsePayload
    public CreateFiltersModelResponse createFiltersModel(@RequestPayload CreateFiltersModelRequest request) {
    	FiltersModel filtersModel = new FiltersModel();
        filtersModel.setProductCode(request.getProductCode());
        filtersModel.setFiltersName(request.getFiltersName());
        filtersModel.setState(request.getState());
        filtersModel.setIdTienda(request.getIdTienda());
        filtersModel.setDesde(toLocalDate(request.getDesde()));
        filtersModel.setHasta(toLocalDate(request.getHasta()));
        filtersModel.setHabilitado(true);
        
        Long id = filtersService.create(filtersModel).getId();

        CreateFiltersModelResponse response = new CreateFiltersModelResponse();
        response.setId(id);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateFiltersModelRequest")
    @ResponsePayload
    public UpdateFiltersModelResponse updateFiltersModel(@RequestPayload UpdateFiltersModelRequest request) {
        FiltersModel filtersModel = new FiltersModel();
        filtersModel.setId(request.getId());
        filtersModel.setProductCode(request.getProductCode());
        filtersModel.setFiltersName(request.getFiltersName());
        filtersModel.setState(request.getState());
        filtersModel.setIdTienda(request.getIdTienda());
        filtersModel.setDesde(toLocalDate(request.getDesde()));
        filtersModel.setHasta(toLocalDate(request.getHasta()));
        filtersModel.setHabilitado(true);

        boolean success = filtersService.update(filtersModel.getId(), filtersModel);

        UpdateFiltersModelResponse response = new UpdateFiltersModelResponse();
        response.setSuccess(success);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteFiltersModelRequest")
    @ResponsePayload
    public DeleteFiltersModelResponse deleteFiltersModel(@RequestPayload DeleteFiltersModelRequest request) {
        boolean success = filtersService.delete(request.getId());

        DeleteFiltersModelResponse response = new DeleteFiltersModelResponse();
        response.setSuccess(success);
        return response;
    }
    
    public XMLGregorianCalendar convertToXMLGregorianCalendar(LocalDateTime timestamp) {
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(timestamp.atZone(ZoneId.systemDefault()));
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
    
    public static LocalDate toLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            return null;
        }
        // Convertir XMLGregorianCalendar a GregorianCalendar
        GregorianCalendar gregorianCalendar = xmlGregorianCalendar.toGregorianCalendar();
        return gregorianCalendar.toZonedDateTime().toLocalDate();
    }

}
