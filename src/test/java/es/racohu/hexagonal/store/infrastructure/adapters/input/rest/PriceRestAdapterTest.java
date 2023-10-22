package es.racohu.hexagonal.store.infrastructure.adapters.input.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest 
@AutoConfigureMockMvc
public class PriceRestAdapterTest {

	@Autowired 
	private MockMvc mockMvc; 

	@Test
	void whenThereIsPrice_thenOk() throws Exception {
		String uri = "/v1/price";

		MvcResult mvcResult = mockMvc
								.perform(MockMvcRequestBuilders
											.get(uri)
											.param("date", "2020-06-14T10:00:00.000+0200")
											.param("productId", "35455")
											.param("brandId", "1"))
								.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "{\"brandId\":1,\"startDate\":\"2020-06-14T00:00:00+02:00\",\"endDate\":\"2020-12-31T23:59:59+01:00\",\"priceList\":1,\"productId\":35455,\"price\":35.5,\"currency\":\"EUR\"}");
	}
	
	@Test
	void whenThereIsNotPrice_thenReturnKo() throws Exception {
		String uri = "/v1/price";

		MvcResult mvcResult = mockMvc
								.perform(MockMvcRequestBuilders
											.get(uri)
											.param("date", "2020-06-14T10:00:00.000+0200")
											.param("productId", "35455")
											.param("brandId", "10"))
								.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertThat(content).contains("Price not found");
	}
	
	@Test
	void whenValidationFailed_thenReturnKo() throws Exception {
		String uri = "/v1/price";

		MvcResult mvcResult = mockMvc
								.perform(MockMvcRequestBuilders
											.get(uri)
											.param("date", "")
											.param("productId", "")
											.param("brandId", ""))
								.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

}
