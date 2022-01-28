package com.example.propertyBase;

import com.example.propertyBase.domain.Property;
import com.example.propertyBase.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

    public HashMap<Property, String> checkTheDates(Property property) {
        String result = "submit_success";
        HashMap<Property, String> resultMap = new HashMap<>();

        if (property.getReservationEndDate().isBefore(property.getReservationStartDate())) {
            throw new IllegalStateException("Niestety data końcowa musi być późniejsza od daty początkowej");
        }

        List<Property> listOfStartDates = propertyRepository.findAll();
        for (int i = 0; i < listOfStartDates.size(); i++) {
            if (property.getPropertyName().equals(listOfStartDates.get(i).getPropertyName())) {
                if ((property.getReservationStartDate().isAfter(listOfStartDates.get(i).getReservationStartDate()) &&
                        property.getReservationStartDate().isBefore(listOfStartDates.get(i).getReservationEndDate().minusDays(1))) ||
                        (property.getReservationEndDate().isBefore(listOfStartDates.get(i).getReservationEndDate()) &&
                                (property.getReservationEndDate().isAfter(listOfStartDates.get(i).getReservationStartDate().minusDays(1))))) {
                    throw new IllegalStateException("Niestety termin jest już zajęty");

                }
            }
        }

        resultMap.put(property, result);

        return resultMap;
    }
}
