package com.Service;

import com.Model.Mapper.Mapper;
import com.Model.DTO.ReaderDTO;
import com.Repository.Entity.Reader;
import com.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    Mapper readerMapper;

    public List<ReaderDTO> findAll() {
        List<Reader> Readers = readerRepository.findAll();
        List<ReaderDTO> readerDTOs = new ArrayList<>();
        for (Reader reader : Readers) {
            readerDTOs.add(readerMapper.toReaderDTO(reader));
        }
        return readerDTOs;
    }

    public Reader findReaderById(Integer id) {
        if (!readerRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai ID " + id);
        }
        Reader readers = readerRepository.findById(id).get();
        return readers;
    }

    public void deleteReaderById(Integer id) {
        if (!readerRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai ID " + id);
        }
        readerRepository.deleteById(id);

    }

    public void createReader(Reader readers) {
        readerRepository.save(readers);
    }

    public void updateReaderById(Integer id, Map<String, Object> params) {
        if (!readerRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai Id " + id);
        }
        Reader readers = readerRepository.findById(id).get();
        if (params.containsKey("name")) {
            readers.setName((String) params.get("name"));
        }
        if (params.containsKey("age")) {
            readers.setAge(Integer.parseInt((String) params.get("age")));
        }
        if (params.containsKey("address")) {
            readers.setAddress((String) params.get("address"));
        }
        if (params.containsKey("phonenumber")) {
            readers.setPhoneNumber((String) params.get("phonenumber"));
        }
        if (params.containsKey("email")) {
            readers.setEmail((String) params.get("email"));
        }
        if (params.containsKey("sex")) {
            readers.setSex((String) params.get("sex"));
        }
    }
}
