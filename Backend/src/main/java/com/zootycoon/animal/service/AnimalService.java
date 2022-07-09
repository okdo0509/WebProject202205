package com.zootycoon.animal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zootycoon.animal.entity.AnimalEntity;
import com.zootycoon.animal.repository.AnimalRepository;
import com.zootycoon.animal.vo.AnimalVO;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private VOMapper voMapper;
	

	public List<AnimalVO> getAllAnimalList() {
		List<AnimalEntity> animalEntities = animalRepository.findAll();
		List<AnimalVO> animalVOes = voMapper.toAnimalvo(animalEntities);
		return animalVOes;
	}

}