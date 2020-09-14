package save_data;

import heroes.RandomUtil;
import org.springframework.stereotype.Component;

@Component
@Oracle
public class OracleDao implements Dao {
    @Override
    public void save() {
        if (RandomUtil.getIntBetween(1,5) == 1)
            throw new DataBaseRuntimeExceptions("Can't get access to DB");
        System.out.println("Save in Oracle");
    }
}
