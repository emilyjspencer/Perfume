package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.EmilySpencer.perfume.model.Perfume;
import com.EmilySpencer.perfume.service.PerfumeService;

	@SpringBootTest
	@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
	public class PerfumeTest {

		@Autowired
		private PerfumeService perfumeService;
		private List<Perfume> perfumesList;

		@Test
		void test_ThatAPerfumeCanBeCreated() {
			Perfume perfume = new Perfume();
			perfumeService.create(perfume);
			assertTrue(perfume.getPerfumeId() > 0);
		}
	
}
