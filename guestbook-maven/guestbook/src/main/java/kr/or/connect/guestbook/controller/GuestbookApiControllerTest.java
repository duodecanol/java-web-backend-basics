package kr.or.connect.guestbook.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.config.WebMvcContextConfiguration;
import kr.or.connect.guestbook.service.GuestbookService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {  WebMvcContextConfiguration.class, ApplicationConfig.class})
public class GuestbookApiControllerTest {
	
	@InjectMocks
	public GuestbookApiController guestbookApiController;
	
	@Mock
	GuestbookService guestbookService;
	
	private MockMvc mockMvc;
	
	@Before
	public void createController() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(guestbookApiController).build();
	}
	
	@Test
	public void getGuestbooks() throws Exception {
		
	}
	
	@Test
	public void deleteGuestbooks() throws Exception {
		
	}
	

}
