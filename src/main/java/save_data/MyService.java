package save_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class MyService {

    @Autowired
    @Oracle
    private Dao oracleDao;
    @Autowired
    @Derby
    private  Dao derbyDao;

    @Scheduled(fixedDelay = 1000)
    public void doWork(){
        oracleDao.save();
    }
    @Scheduled(fixedDelay = 5000)
    public  void doBackup(){
        derbyDao.save();
    }
}
