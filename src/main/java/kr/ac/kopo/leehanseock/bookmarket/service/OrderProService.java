package kr.ac.kopo.leehanseock.bookmarket.service;

import kr.ac.kopo.leehanseock.bookmarket.domain.Order;
import kr.ac.kopo.leehanseock.bookmarket.repository.OrderProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OrderProService {
    @Autowired
    private OrderProRepository orderProRepository;

    public void save(Order order){
        orderProRepository.save(order);
    }

    public Page<Order> listAll(int pageNum, String sortField, String sortDir){
        int paszeSize = 5;
        Sort sort = sortDir.equals("asc")?Sort.by(sortField).ascending():Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNum-1, paszeSize, sort);
        return orderProRepository.findAll(pageable);
    }

    public Order get(long id){
        return orderProRepository.findById(id).get();
    }

    public void delete(long id){
        orderProRepository.deleteById(id);
    }

    public void deleteAll(){
        orderProRepository.deleteAll();
    }
}
