package com.unla.stockearte.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.stockearte.repository.FiltersRepository;
import com.unla.stockearte.repository.entity.FiltersModel;

@Service
public class FiltersServiceLogic {

	@Autowired
	private FiltersRepository repository;

	public FiltersModel create(FiltersModel filtersModel) {
		return repository.save(filtersModel);
	}

	public boolean update(Long id, FiltersModel filtersModel) {
		Optional<FiltersModel> existing = repository.findById(id);
		if (existing.isPresent()) {
			repository.save(filtersModel);
			return true;
		}
		return false;
	}

	public boolean delete(Long id) {
		Optional<FiltersModel> existing = repository.findById(id);
		if (existing.isPresent()) {
			existing.get().setHabilitado(false);
			repository.save(existing.get());
			return true;
		}
		return false;
	}

}
