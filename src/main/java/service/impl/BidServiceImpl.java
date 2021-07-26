package service.impl;

import com.example.project3.manager.BidManager;
import com.example.project3.pojo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BidService;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {
    private BidManager bidManager;

    @Autowired
    public void setBidManager(BidManager bidManager){
        this.bidManager=bidManager;
    }

    @Override
    public void insert(Bid bid) {
        bidManager.insert(bid);
    }

    @Override
    public void drop(Integer id) {
        bidManager.drop(id);
    }

    @Override
    public void delete(Integer id) {
        bidManager.delete(id);
    }

    @Override
    public void update(Bid bid) {
        bidManager.update(bid);
    }

    @Override
    public List<Bid> selectAll() {
        return bidManager.selectAll();
    }

    @Override
    public Bid select(Integer id) {
        return bidManager.select(id);
    }

    @Override
    public List<Bid> selectByCorporateId(Integer corporateId) {
        return selectByCorporateId(corporateId);
    }
}
