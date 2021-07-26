package service;

import com.example.project3.pojo.Bid;

import java.util.List;

public interface BidService {
    void insert (Bid target);

    void drop (Integer id);

    void delete (Integer id);

    void update (Bid target);

    List<Bid> selectAll();

    Bid select(Integer id);

    List<Bid> selectByCorporateId(Integer corporateId);
}
