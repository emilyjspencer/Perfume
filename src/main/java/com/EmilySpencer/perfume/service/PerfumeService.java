package com.EmilySpencer.perfume.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.Perfume;
import com.EmilySpencer.perfume.repository.PerfumeDao;

@Service
public class PerfumeService {

	private static Logger LOGGER = LogManager.getLogger(PerfumeService.class);

	@Autowired
	private PerfumeDao perfumeDao;

	public PerfumeService(PerfumeDao perfumeDao) {
		super();
		this.perfumeDao = perfumeDao;
	}

	public void create(Perfume perfume) {
		perfumeDao.save(perfume);
	}

	public List<Perfume> retrieveAll() {
		return perfumeDao.findAll();
	}

	public Optional<Perfume> retrieveOne(long perfumeId) {
		return perfumeDao.findById(perfumeId);
	}

	public void delete(long perfumeId) {
		Optional<Perfume> perfumeToDelete = perfumeDao.findById(perfumeId);
		if (perfumeToDelete.isPresent()) {
			perfumeDao.deleteById(perfumeId);
		} else {
			LOGGER.error("This perfume is not on our database");
		}
	}

	public void update(Perfume perfume) {
		perfumeDao.save(perfume);
	}

}

