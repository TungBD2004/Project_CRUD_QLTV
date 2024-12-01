package com.Service;

import com.Entity.Reader;
import com.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

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
        readerRepository.save(readers);
    }
}
