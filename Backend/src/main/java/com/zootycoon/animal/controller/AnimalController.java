package com.zootycoon.animal.controller;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zootycoon.animal.dto.AnimalDTO;
import com.zootycoon.animal.dto.ResponseDTO;
import com.zootycoon.animal.service.AnimalService;
import com.zootycoon.animal.vo.AnimalVO;

 

@RestController
@RequestMapping("/animal")
public class AnimalController {
    
	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private DTOMapper dtoMapper;
	
    @GetMapping("/all")
    public ResponseEntity<?> getAllAnimalList(){
        
    	List<AnimalVO> animalVOList = animalService.getAllAnimalList();
        List<AnimalDTO> animalDTOList = dtoMapper.toAnimalDTO(animalVOList);
        
        ResponseDTO<AnimalDTO> responseDTO = ResponseDTO.<AnimalDTO>builder().data(animalDTOList).build();
        
        return ResponseEntity.ok().body(responseDTO);
        
        
    }

 

}