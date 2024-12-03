package com.Service;

import com.Entity.Reader;
import com.Model.DTO.ReaderDTO;
import com.Model.Mapper.Mapper;
import com.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private Mapper mapper;

    public ReaderDTO findReaderById(Integer id) {
        if (!readerRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai ID " + id);
        }
        Reader readers = readerRepository.findById(id).get();
        return mapper.toReaderDTO(readers);
    }

    public void deleteReaderById(Integer id) {
        if (!readerRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai ID " + id);
        }
        readerRepository.deleteById(id);

    }

    public void createReader(@RequestParam Map<String, Object> params) {
        Reader readers = new Reader();
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
        readerRepository.save(readers);
    }

    public void updateReaderById(Map<String, Object> params) {
        Reader readers = new Reader();
        if (params.containsKey("id")) {
            readers.setId(Integer.parseInt((String) params.get("id")));
        }
        if (!readerRepository.existsById(readers.getId())) {
            throw new IllegalArgumentException("Khong ton tai doc gia ");
        }
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
        readerRepository.save(readers);
    }
}
