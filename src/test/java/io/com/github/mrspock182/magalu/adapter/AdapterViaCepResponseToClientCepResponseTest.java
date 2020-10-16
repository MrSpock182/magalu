package io.com.github.mrspock182.magalu.adapter;

import io.com.github.mrspock182.magalu.TestSetup;
import io.com.github.mrspock182.magalu.adapter.implementation.AdapterPostmonResponseToClientCepResponse;
import io.com.github.mrspock182.magalu.dto.ClientCepResponse;
import io.com.github.mrspock182.magalu.dto.PostmonResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AdapterViaCepResponseToClientCepResponseTest extends TestSetup {

    @InjectMocks
    public AdapterPostmonResponseToClientCepResponse adapter;

    @Override
    public void init() {

    }

    @Test
    public void castTest() {
        PostmonResponse viaCepResponse = new PostmonResponse( "Bela Vista" , "São Paulo",
                "Avenida Paulista","SP");
        ClientCepResponse response = adapter.cast(viaCepResponse);
        assertEquals("Avenida Paulista", response.getStreet());
        assertEquals("Bela Vista", response.getNeighborhood());
        assertEquals("São Paulo", response.getCity());
        assertEquals("SP", response.getState());
    }

}
