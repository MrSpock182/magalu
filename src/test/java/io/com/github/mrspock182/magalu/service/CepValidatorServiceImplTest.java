package io.com.github.mrspock182.magalu.service;

import io.com.github.mrspock182.magalu.TestSetup;
import io.com.github.mrspock182.magalu.exception.BadRequestException;
import io.com.github.mrspock182.magalu.service.implementation.CepValidatorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CepValidatorServiceImplTest extends TestSetup {

    @InjectMocks
    private CepValidatorServiceImpl service;

    @Override
    public void init() {

    }

    @Test
    public void cepValidatorSuccessTest() {
        service.validate("01311000");
    }

    @Test(expected = BadRequestException.class)
    public void cepValidatorWithLengthGreaterThanEightFailsTest() {
        service.validate("013110000");
    }

    @Test(expected = BadRequestException.class)
    public void cepValidatorWithLengthLowerThanEightFailsTest() {
        service.validate("0131100");
    }

    @Test(expected = BadRequestException.class)
    public void cepValidatorWithNonNumericInputFailsTest() {
        service.validate("AAAAAAAA");
    }

    @Test(expected = BadRequestException.class)
    public void cepValidatorWithZeroFailsTest() {
        service.validate("00000000");
    }
}
