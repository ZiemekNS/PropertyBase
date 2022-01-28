package com.example.propertyBase;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.propertyBase.domain.Property;
import com.example.propertyBase.repositories.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class PropertyRepositoryTests {

//
//    @Autowired
//    private PropertyRepository propertyRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void testRateBeer() {
//        Property property = new Property();
//        property.setPropertyName("Warka");
//        property.setLandlordName("Radler");
//        property.setReservationStartDate(LocalDate.of(2022,1,24));
//        property.setReservationEndDate(LocalDate.of(2022,1,28));
//
//        Property savedProperty = propertyRepository.save(property);
//
//        Property existProperty = entityManager.find(Property.class, savedProperty.getId());
//
//        assertThat(existProperty.getPropertyName()).isEqualTo(property.getPropertyName());
//    }
}
